package com.example.dannyappPokemonApp.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dannyappPokemonApp.Repository.PokemonKortDAO;
import com.example.dannyappPokemonApp.models.PokemonKort;

import java.util.List;

public class PokemonKortViewModel extends ViewModel {
    private PokemonKortDAO pokemonKortDAO;
    private boolean ViewingPomemonCards;


    // private MutableLiveData<ViewState> viewState;
    //public enum ViewState {Pokemonkort, PokemonSet};

    /*public PokemonKortViewModel(@NonNull Application application) {
        super(application);
       // init();
    }

     */
        public PokemonKortViewModel() {
        pokemonKortDAO = PokemonKortDAO.getInstance();
    }

    public LiveData<List<PokemonKort>> getData() {
        return pokemonKortDAO.getData();
    }


    public void searchPokemonApiCards(String query, int page, int pageSize) {
        pokemonKortDAO.searchPokemonApiCards(query, page, pageSize);

    }
    /*
    private void init() {
        if(viewState == null) {
            viewState = new MutableLiveData<>();
            viewState.setValue(ViewState.Pokemonkort);
        }

    }

*/
/*  public LiveData<ViewState> getViewState() {
        return viewState;
}

 */
}
