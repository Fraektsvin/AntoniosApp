package com.example.dannyappPokemonApp.Viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.dannyappPokemonApp.Repository.PokemonKortDAO;
import com.example.dannyappPokemonApp.models.PokemonKort;

public class PokemonKortSingleViewModel extends ViewModel {

    private PokemonKortDAO pokemonKortDAO;

    public PokemonKortSingleViewModel() {
        pokemonKortDAO = PokemonKortDAO.getInstance();
    }

    public LiveData<PokemonKort> getSingleData() {
        return pokemonKortDAO.getSingleData();
    }
    public void searchPokemonApiCards(String pokemonkortID ) {

        pokemonKortDAO.searchPokemonSingleAPICards(pokemonkortID);
    }
}
