package com.example.dannyappPokemonApp.Repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import com.example.dannyappPokemonApp.Request.PokemonApiClient;
import com.example.dannyappPokemonApp.models.Pokeliste;
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
    public LiveData<List<PokemonSet>> getPokeliste() {
        return rPokemonApiClient.getPokeliste();
    }

    public void searchPokemonApi(String query) {

            rPokemonApiClient.searchPokemonApi(query);
    }
}

