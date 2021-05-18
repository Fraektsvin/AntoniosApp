package com.example.dannyappPokemonApp.Viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import com.example.dannyappPokemonApp.Repository.PokemonSetDAO;
import com.example.dannyappPokemonApp.models.PokemonSet;

public class PokemonlistViewModel extends ViewModel {
    private PokemonSetDAO rpokemonSetDAO;
    private boolean ViewingPomemonCards;

    public boolean isViewingPomemonCards() {
        return ViewingPomemonCards;
    }

    public void setViewingPomemonCards(boolean viewingPomemonCards) {
        ViewingPomemonCards = viewingPomemonCards;
    }

    public PokemonlistViewModel() {
        ViewingPomemonCards = false;
        rpokemonSetDAO = PokemonSetDAO.getInstance();
    }

    public LiveData<List<PokemonSet>> getSet() {
        return rpokemonSetDAO.getSet();
    }



    public void searchPokemonApi(String query, int page, int pageSize) {
        ViewingPomemonCards = true;
        rpokemonSetDAO.searchPokemonApi(query, page, pageSize);
    }

}
