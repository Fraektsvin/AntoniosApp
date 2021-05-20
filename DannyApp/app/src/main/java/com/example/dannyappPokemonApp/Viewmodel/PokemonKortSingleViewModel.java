package com.example.dannyappPokemonApp.Viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.dannyappPokemonApp.Repository.PokemonKortRepository;
import com.example.dannyappPokemonApp.models.PokemonKort;

public class PokemonKortSingleViewModel extends ViewModel {

    private PokemonKortRepository pokemonKortRepository;

    public PokemonKortSingleViewModel() {
        pokemonKortRepository = PokemonKortRepository.getInstance();
    }

    public LiveData<PokemonKort> getSingleData() {
        return pokemonKortRepository.getSingleData();
    }
    public void searchPokemonApiCards(String pokemonkortID ) {

        pokemonKortRepository.searchPokemonSingleAPICards(pokemonkortID);
    }
}
