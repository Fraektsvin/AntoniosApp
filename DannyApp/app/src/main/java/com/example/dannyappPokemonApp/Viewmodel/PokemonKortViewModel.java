package com.example.dannyappPokemonApp.Viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.dannyappPokemonApp.Repository.PokemonKortRepository;
import com.example.dannyappPokemonApp.models.PokemonKort;

import java.util.List;

public class PokemonKortViewModel extends ViewModel {
    private PokemonKortRepository pokemonKortRepository;
    private boolean ViewingPomemonCards;


    // private MutableLiveData<ViewState> viewState;
    //public enum ViewState {Pokemonkort, PokemonSet};

    /*public PokemonKortViewModel(@NonNull Application application) {
        super(application);
       // init();
    }

     */
        public PokemonKortViewModel() {
        pokemonKortRepository = PokemonKortRepository.getInstance();
    }

    public LiveData<List<PokemonKort>> getData() {
        return pokemonKortRepository.getData();
    }


    public void searchPokemonApiCards(String query, int page, int pageSize) {
        pokemonKortRepository.searchPokemonApiCards(query, page, pageSize);

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
