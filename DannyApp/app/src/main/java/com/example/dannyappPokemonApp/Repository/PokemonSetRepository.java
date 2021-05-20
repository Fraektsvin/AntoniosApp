package com.example.dannyappPokemonApp.Repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import com.example.dannyappPokemonApp.Request.PokemonApiClient;
import com.example.dannyappPokemonApp.models.PokemonSet;

public  class PokemonSetRepository {
    private static PokemonSetRepository instance;
    private PokemonApiClient rPokemonApiClient;

    public static PokemonSetRepository getInstance() {
        if(instance== null) {
            instance = new PokemonSetRepository();
        }
        return instance;
    }
    private PokemonSetRepository() {
        rPokemonApiClient = PokemonApiClient.getInstance();
    }

    //Right here i make sure to send the life data to the repository to be observed
    public LiveData<List<PokemonSet>> getSet() {
        return rPokemonApiClient.getSet();
    }


    public void searchPokemonApi(String query, int page, int pageSize) {
            if(page== 0) {
                page = 1;
            }
            rPokemonApiClient.searchPokemonApi(query, page, pageSize);
    }


}

