package com.example.dannyappPokemonApp;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.dannyapp.R;
import com.example.dannyappPokemonApp.Util.Testing;
import com.example.dannyappPokemonApp.Viewmodel.PokemonlistViewModel;
import java.util.List;
import com.example.dannyappPokemonApp.models.Pokeliste;
import com.example.dannyappPokemonApp.models.PokemonSet;

public class Pokemonlistacitvity extends BaseActivity {
    Toolbar toolbar;
    private static final String TAG = "BaseActivity";
    private PokemonlistViewModel pokemonlistViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemonlist_item);
        pokemonlistViewModel = ViewModelProviders.of(this).get(PokemonlistViewModel.class);
        subscribeObservers();
        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                testRetrofitRequest();


            }
        });
    }
    private void subscribeObservers() {

        pokemonlistViewModel.getmPokemon().observe(this, new Observer<List<PokemonSet>>() {

            @Override
            public void onChanged(@Nullable List<PokemonSet> pokelistes) {
               if(pokelistes!= null){
                   Testing.printPokemonlist(pokelistes,"Pokemon Test");
               }
            }
        });
    }


    private void testRetrofitRequest() {
        pokemonlistViewModel.searchPokemonApi("id:base1");
    }

}
