package com.example.dannyappPokemonApp.Repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import com.example.dannyappPokemonApp.Request.PokemonApiCards;
import com.example.dannyappPokemonApp.Request.PokemonApiClient;
import com.example.dannyappPokemonApp.models.PokemonKort;
import com.example.dannyappPokemonApp.models.PokemonSet;

public class PokemonRepository {
    private static PokemonRepository instance;
    private PokemonApiClient rPokemonApiClient;
    private PokemonApiCards pokemonApiCards;

    public static PokemonRepository getInstance() {
        if(instance== null) {
            instance = new PokemonRepository();
        }
        return instance;
    }
    private  PokemonRepository() {
        rPokemonApiClient = PokemonApiClient.getInstance();
        pokemonApiCards = PokemonApiCards.getInstance();
    }

    //Right here i make sure to send the life data to the repository to be observed
    public LiveData<List<PokemonSet>> getSet() {
        return rPokemonApiClient.getSet();
    }
    public LiveData<List<PokemonKort>> getData() {
        return pokemonApiCards.getData();
    }

    public void searchPokemonApi(String query, int page, int pageSize) {
            if(page== 0) {
                page = 1;
            }
            rPokemonApiClient.searchPokemonApi(query, page, pageSize);
    }
    public void searchPokemonApiCards(String query, int page, int pageSize) {
        if(page== 0) {
            page = 1;
        }
        pokemonApiCards.searchPokemonKortApi(query, page, pageSize);
    }
}

