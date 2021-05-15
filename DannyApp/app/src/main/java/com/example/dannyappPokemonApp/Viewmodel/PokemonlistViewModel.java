package com.example.dannyappPokemonApp.Viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import com.example.dannyappPokemonApp.Repository.PokemonRepository;
import com.example.dannyappPokemonApp.models.Pokeliste;
import com.example.dannyappPokemonApp.models.PokemonKort;
import com.example.dannyappPokemonApp.models.PokemonSet;

public class PokemonlistViewModel extends ViewModel {
    private PokemonRepository RpokemonRepository;
    private boolean ViewingPomemonCards;

    public boolean isViewingPomemonCards() {
        return ViewingPomemonCards;
    }

    public void setViewingPomemonCards(boolean viewingPomemonCards) {
        ViewingPomemonCards = viewingPomemonCards;
    }

    public PokemonlistViewModel() {
        ViewingPomemonCards = false;
        RpokemonRepository = PokemonRepository.getInstance();
    }

    public LiveData<List<PokemonSet>> getSet() {
        return RpokemonRepository.getSet();
    }

    public LiveData<List<PokemonKort>> getData() {
        return RpokemonRepository.getData();
    }

    public void searchPokemonApi(String query, int page, int pageSize) {
        ViewingPomemonCards = true;
        RpokemonRepository.searchPokemonApi(query, page, pageSize);
    }

    public void searchPokemonApiCards(String query, int page, int pageSize) {
        RpokemonRepository.searchPokemonApiCards(query, page, pageSize);

    }
}
