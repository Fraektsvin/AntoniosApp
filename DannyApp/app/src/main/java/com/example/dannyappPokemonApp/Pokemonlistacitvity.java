package com.example.dannyappPokemonApp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dannyapp.R;
import com.example.dannyappPokemonApp.Adapter.OnPokemonListener;
import com.example.dannyappPokemonApp.Adapter.PokemonRecycleAdapter;
import com.example.dannyappPokemonApp.Util.Testing;
import com.example.dannyappPokemonApp.Viewmodel.PokemonlistViewModel;
import java.util.List;

import com.example.dannyappPokemonApp.models.PokemonKort;
import com.example.dannyappPokemonApp.models.PokemonSet;

public class Pokemonlistacitvity extends BaseActivity implements OnPokemonListener {
    private RecyclerView recyclerView;
    private PokemonRecycleAdapter pokemonRecycleAdapter;
    private static final String TAG = "BaseActivity";
    private PokemonlistViewModel pokemonlistViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemonlist_item);
        recyclerView = findViewById(R.id.pokemonlistRecycler);

        pokemonlistViewModel = ViewModelProviders.of(this).get(PokemonlistViewModel.class);
        initRecyclerView();
        subscribeObservers();
        subscribeObserversCards();
        initSearchView();
        if(!pokemonlistViewModel.isViewingPomemonCards()) {
            displayPokemoncards();
        }
    }
    private void subscribeObservers() {

        pokemonlistViewModel.getSet().observe(this, new Observer<List<PokemonSet>>() {

            @Override
            public void onChanged(@Nullable List<PokemonSet> pokelistes) {
               if(pokelistes!= null){
                   Testing.printPokemonlist("Pokemon Test", pokelistes);
                   pokemonRecycleAdapter.setPokemonlist(pokelistes);
               }
            }
        });
    }
    private void subscribeObserversCards() {

        pokemonlistViewModel.getData().observe(this, new Observer<List<PokemonKort>>() {

            @Override
            public void onChanged(@Nullable List<PokemonKort> pokemonKorts) {
                if(pokemonKorts!= null){
                    Testing.printPokemonlistCards("Pokemon Test", pokemonKorts);
                    pokemonRecycleAdapter.setPokemonKorts(pokemonKorts);
            }


            }
        });
    }
    private void initRecyclerView() {
        pokemonRecycleAdapter = new PokemonRecycleAdapter( this);
        recyclerView.setAdapter(pokemonRecycleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void initSearchView() {
        final SearchView searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                pokemonRecycleAdapter.displayLoading();

                pokemonlistViewModel.searchPokemonApi("name:" + query, 1, 250);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }



    @Override
    public void onPokemonclick(int position) {


    }

    @Override
    public void onPokemonCardClick(String category) {
        Log.d(TAG, "onPokemonclick: clicked" + category);
        pokemonRecycleAdapter.displayLoadingCards();
        pokemonlistViewModel.searchPokemonApiCards("name:" + category, 1, 250);
    }
    private void displayPokemoncards() {
        Log.d(TAG, "DisplayPokemoncards:called.");
        pokemonlistViewModel.setViewingPomemonCards(false);
        pokemonRecycleAdapter.displayLoadingCards();
    }
}
