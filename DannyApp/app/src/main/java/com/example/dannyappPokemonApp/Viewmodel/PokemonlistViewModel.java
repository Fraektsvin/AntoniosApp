package com.example.dannyappPokemonApp.Viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import com.example.dannyappPokemonApp.Repository.PokemonRepository;
import com.example.dannyappPokemonApp.models.Pokeliste;
import com.example.dannyappPokemonApp.models.PokemonSet;

public class PokemonlistViewModel extends ViewModel {
    private PokemonRepository RpokemonRepository;

    public PokemonlistViewModel() {
        RpokemonRepository = PokemonRepository.getInstance();
    }

    public LiveData<List<PokemonSet>> getSet() {
        return RpokemonRepository.getSet();
    }


    public void searchPokemonApi(String query, int page, int pageSize) {
        RpokemonRepository.searchPokemonApi(query, page, pageSize);
    }

}
