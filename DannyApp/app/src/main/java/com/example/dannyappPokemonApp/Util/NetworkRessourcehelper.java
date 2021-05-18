package com.example.dannyappPokemonApp.Util;

import android.util.Log;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import com.example.dannyappPokemonApp.AppExecutors;
import com.example.dannyappPokemonApp.Request.Response.ApiResponseGeneric;

import java.util.concurrent.Executor;

public abstract class NetworkRessourcehelper <FirebaseObject, RequestObject> {

        private static final String TAG = "Called";
        private AppExecutors appExecutors;
        private MediatorLiveData<Ressource<FirebaseObject>> results = new MediatorLiveData<>();

        public NetworkRessourcehelper(AppExecutors appExecutors) {
                this.appExecutors = appExecutors;
        }
        public void init() {

                results.setValue((Ressource<FirebaseObject>) Ressource.loading(null));
                //observe livedata from firebase
                final LiveData<FirebaseObject> dbSource = loadFromDb();
                results.addSource(dbSource, new Observer<FirebaseObject>() {
                        @Override
                        public void onChanged(FirebaseObject firebaseObject) {
                                results.removeSource(dbSource);

                                if(shouldFetch(firebaseObject)) {
                                        fetchFromNetwork(dbSource);
                                }
                                else {
                                        results.addSource(dbSource, new Observer<FirebaseObject>() {
                                                @Override
                                                public void onChanged(FirebaseObject firebaseObject) {
                                                        setvalue(Ressource.success(firebaseObject));
                                                }
                                        });
                                }

                        }
                });
        }

        private void setvalue(Ressource<FirebaseObject> newValue) {
                if (results.getValue() != newValue) {
                        results.setValue(newValue);
                }
        }
        private void fetchFromNetwork(final LiveData<FirebaseObject> dbsource) {
                Log.d(TAG, "fetchFromNetwork: ");
                results.addSource(dbsource, new Observer<FirebaseObject>() {
                        @Override
                        public void onChanged(FirebaseObject firebaseObject) {
                                setvalue(Ressource.loading(firebaseObject));
                        }
                });
                final LiveData<ApiResponseGeneric<RequestObject>> apiResponseGenericLiveData = createCall();
                results.addSource(apiResponseGenericLiveData, new Observer<ApiResponseGeneric<RequestObject>>() {
                        @Override
                        public void onChanged(ApiResponseGeneric<RequestObject> requestObjectApiResponseGeneric) {
                                results.removeSource(dbsource);
                                results.removeSource(apiResponseGenericLiveData);
                                /*
                                these Observers handlles 3 cases
                                1. Apisucess
                                2.Apierror
                                3.ApiEmpty
                                 */
                                if(requestObjectApiResponseGeneric instanceof ApiResponseGeneric.Apisuccesfullresponse) {
                                        appExecutors.ManagingData().execute(new Runnable() {
                                                @Override
                                                public void run() {
                                                        // save the response
                                                        saveCallResult((RequestObject) processresponse((ApiResponseGeneric.Apisuccesfullresponse)requestObjectApiResponseGeneric));

                                                        appExecutors.mainThread().execute(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                        results.addSource(loadFromDb(), new Observer<FirebaseObject>() {
                                                                                @Override
                                                                                public void onChanged(FirebaseObject firebaseObject) {
                                                                                        setvalue(Ressource.success(firebaseObject));
                                                                                }
                                                                        });
                                                                }
                                                        });
                                                }
                                        });
                                }
                                else if(requestObjectApiResponseGeneric instanceof ApiResponseGeneric.ApisuccessfuullEmpty) {
                                        Log.d(TAG, "onChanged: ApiEmptyresponse");
                                        appExecutors.mainThread().execute(new Runnable() {
                                                @Override
                                                public void run() {
                                                        results.addSource(loadFromDb(), new Observer<FirebaseObject>() {
                                                                @Override
                                                                public void onChanged(FirebaseObject firebaseObject) {
                                                                        setvalue(Ressource.success(firebaseObject));
                                                                }
                                                        });
                                                }
                                        });
                                }
                                else if(requestObjectApiResponseGeneric instanceof ApiResponseGeneric.ErrorResponse) {
                                        Log.d(TAG, "onChanged: ApiError");
                                        results.addSource(dbsource, new Observer<FirebaseObject>() {
                                                @Override
                                                public void onChanged(FirebaseObject firebaseObject) {
                                                        setvalue(
                                                                Ressource.error(
                                                                        ((ApiResponseGeneric.ErrorResponse)requestObjectApiResponseGeneric).getErrormessage(),
                                                                        firebaseObject
                                                                )

                                                        );
                                                }
                                        });
                                }
                                }
                });
        }
        private FirebaseObject processresponse(ApiResponseGeneric.Apisuccesfullresponse apisuccesfullresponse) {
                return (FirebaseObject) apisuccesfullresponse.getBody();
        }

        // Called to save the result of the API response into the database.
        @WorkerThread
        protected abstract void saveCallResult(@NonNull RequestObject item);

        // Called with the data in the database to decide whether to fetch
        // potentially updated data from the network.
        @MainThread
        protected abstract boolean shouldFetch(@Nullable FirebaseObject data);

        // Called to get the cached data from the database.
        @NonNull
        @MainThread
        protected abstract LiveData<FirebaseObject> loadFromDb();

        // Called to create the API call.
        @NonNull @MainThread
        protected abstract LiveData<ApiResponseGeneric<RequestObject>> createCall();

        // Returns a LiveData object that represents the resource that's implemented
        // in the base class.
        public final LiveData<Ressource<FirebaseObject>> getAsLiveData(){
            return results;
        };
    }

