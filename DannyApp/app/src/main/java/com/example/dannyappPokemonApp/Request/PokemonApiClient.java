package com.example.dannyappPokemonApp.Request;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.example.dannyappPokemonApp.AppExecutors;
import com.example.dannyappPokemonApp.Request.Response.PokeSearchSet;
import com.example.dannyappPokemonApp.Util.Constants;
import com.example.dannyappPokemonApp.models.PokemonSet;

import retrofit2.Call;
import retrofit2.Response;

import static com.example.dannyappPokemonApp.Util.Constants.CONNECTION_TIMEOUT;

public class PokemonApiClient {
    private static final String TAG = "PokemonApiClient";

    private static PokemonApiClient instance;
    private MutableLiveData<List<PokemonSet>> pokelistes;
    private RetrieveRunnablePokemonlist retrieveRunnablePokemonlist;


    public static PokemonApiClient getInstance() {
        if (instance == null) {
            instance = new PokemonApiClient();
        }
        return instance;
    }


    public PokemonApiClient() {
        pokelistes = new MutableLiveData<>();
    }
    public LiveData<List<PokemonSet>> getSet() {
        return pokelistes;
    }

    public void searchPokemonApi(String query, int page) {
        if(retrieveRunnablePokemonlist!= null) {
            retrieveRunnablePokemonlist = null;

        }
        retrieveRunnablePokemonlist = new RetrieveRunnablePokemonlist(query, page);
        final Future handler = AppExecutors.getInstance().networkIO().submit(retrieveRunnablePokemonlist);

        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                //make sure if the data is not received then it willll let the user know that there is a time out
                handler.cancel(true);

            }
        },CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS);
    }
    private class RetrieveRunnablePokemonlist implements Runnable {
        private String query;
        private int page;
        private boolean cancelRequest;

        public RetrieveRunnablePokemonlist(String query, int page) {
            this.query = query;
            this.page = page;
            cancelRequest = false;
        }

        @Override
        public void run() {
            try {
                Response response = getSet(query, page).execute();
                if (cancelRequest) {
                    return;
                }
                if (response.code() == 200) {

                    List<PokemonSet> list = new ArrayList<>(((PokeSearchSet) response.body()).getSet());
                    if (page == 1) {
                        pokelistes.postValue(list);
                }
                else {
                    List<PokemonSet> currentPokemonlist = pokelistes.getValue();
                    currentPokemonlist.addAll(list);
                        pokelistes.postValue(currentPokemonlist);

                    }
            }
                else {
                    String error = response.errorBody().string();
                    Log.e(TAG, "run: "+ error );
                    pokelistes.postValue(null);
                }
            } catch (IOException e) {
                e.printStackTrace();
                pokelistes.postValue(null);
            }

        }
        private Call<PokeSearchSet> getSet(String query, int page) {
            return ServiceGenerator.getPokemonAPI().getSet(
                    Constants.API_KEY,
                    query,
                    String.valueOf(page)


            );
        }
        private void CancelRequest() {
            Log.d(TAG, "CancelRequest: cancel the search ");
            cancelRequest = true;
        }
    }
}

