package com.example.dannyappPokemonApp.Viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import com.example.dannyappPokemonApp.Repository.PokemonSetRepository;
import com.example.dannyappPokemonApp.models.PokemonSet;

public class PokemonlistViewModel extends ViewModel {
    private PokemonSetRepository rpokemonSetRepository;
    private boolean ViewingPomemonCards;

    public boolean isViewingPomemonCards() {
        return ViewingPomemonCards;
    }

    public void setViewingPomemonCards(boolean viewingPomemonCards) {
        ViewingPomemonCards = viewingPomemonCards;
    }

    public PokemonlistViewModel() {
        ViewingPomemonCards = false;
        rpokemonSetRepository = PokemonSetRepository.getInstance();
    }

    public LiveData<List<PokemonSet>> getSet() {
        return rpokemonSetRepository.getSet();
    }



    public void searchPokemonApi(String query, int page, int pageSize) {
        ViewingPomemonCards = true;
        rpokemonSetRepository.searchPokemonApi(query, page, pageSize);
    }

}
