package com.example.dannyappPokemonApp.Request;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.dannyappPokemonApp.AppExecutors;
import com.example.dannyappPokemonApp.Request.Response.PokeSearchSet;
import com.example.dannyappPokemonApp.Request.Response.PokelistResponse;
import com.example.dannyappPokemonApp.Util.Constants;
import com.example.dannyappPokemonApp.models.PokemonSet;
import com.example.dannyappPokemonApp.models.PokemonKort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;

import static com.example.dannyappPokemonApp.Util.Constants.CONNECTION_TIMEOUT;

public class PokemonApiCards {
    private static final String TAG = "PokemonApiCards";

    private static PokemonApiCards instance;
    private MutableLiveData<List<PokemonKort>> pokemonkortlist;
    private PokemonApiCards.RetrieveRunnablePokemonlist retrieveRunnablePokemonlist;


    public static PokemonApiCards getInstance() {
        if (instance == null) {
            instance = new PokemonApiCards();
        }
        return instance;
    }


    public PokemonApiCards() {
        pokemonkortlist = new MutableLiveData<>();
    }
    public LiveData<List<PokemonKort>> getData() {
        return pokemonkortlist;
    }

    public void searchPokemonKortApi(String query, int page, int pageSize) {
        if(retrieveRunnablePokemonlist!= null) {
            retrieveRunnablePokemonlist = null;

        }
        retrieveRunnablePokemonlist = new PokemonApiCards.RetrieveRunnablePokemonlist(query, page, pageSize);
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
        private int pageSize;
        private boolean cancelRequest;

        public RetrieveRunnablePokemonlist(String query, int page, int pageSize) {
            this.query = query;
            this.page = page;
            this.pageSize = pageSize;
            cancelRequest = false;
        }

        @Override
        public void run() {
            try {
                Response response = getData(query, page, pageSize).execute();
                if (cancelRequest) {
                    return;
                }
                if (response.code() == 200) {

                    List<PokemonKort> list = new ArrayList<>(((PokelistResponse) response.body()).getPokeData());
                    if (page == 1) {
                        pokemonkortlist.postValue(list);
                    }
                    else {
                        List<PokemonKort> currentPokemonlist = pokemonkortlist.getValue();
                        currentPokemonlist.addAll(list);
                        pokemonkortlist.postValue(currentPokemonlist);

                    }
                }
                else {
                    String error = response.errorBody().string();
                    Log.e(TAG, "run: "+ error );
                    pokemonkortlist.postValue(null);
                }
            } catch (IOException e) {
                e.printStackTrace();
                pokemonkortlist.postValue(null);
            }

        }
        private Call<PokelistResponse> getData(String query, int page, int pageSize) {
            return ServiceGenerator.getPokemonAPI().getList(
                    Constants.API_KEY,
                    query,
                    String.valueOf(page),
                    String.valueOf(pageSize)



            );
        }
        private void CancelRequest() {
            Log.d(TAG, "CancelRequest: cancel the search ");
            cancelRequest = true;
        }
    }
}
