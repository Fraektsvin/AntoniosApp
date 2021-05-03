package com.example.dannyappPokemonApp.Repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import com.example.dannyappPokemonApp.Request.PokemonApiClient;
import com.example.dannyappPokemonApp.models.PokemonSet;

public class PokemonRepository {
    private static PokemonRepository instance;
    private PokemonApiClient rPokemonApiClient;

    public static PokemonRepository getInstance() {
        if(instance== null) {
            instance = new PokemonRepository();
        }
        return instance;
    }
    private  PokemonRepository() {
        rPokemonApiClient = PokemonApiClient.getInstance();

    }
    //Right here i make sure to send the life data to the repository to be observed
    public LiveData<List<PokemonSet>> getSet() {
        return rPokemonApiClient.getSet();
    }

    public void searchPokemonApi(String query, int page) {
            if(page==0) {
                page = 1;
            }
            rPokemonApiClient.searchPokemonApi(query, page);
    }
}

