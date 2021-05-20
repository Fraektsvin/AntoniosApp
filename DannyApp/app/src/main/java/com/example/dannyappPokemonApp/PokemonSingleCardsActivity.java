package com.example.dannyappPokemonApp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dannyapp.R;
import com.example.dannyappPokemonApp.Viewmodel.PokemonKortSingleViewModel;
import com.example.dannyappPokemonApp.models.PokemonKort;

public class PokemonSingleCardsActivity extends BaseActivity {
    // UI components
    private PokemonKortSingleViewModel pokemonKortSingleViewModel;

    private ImageView PokemonSingleCardView;
    private TextView Pokemonkorttitel, PokemonNumber;
    private LinearLayout Pokemon_container;
    private NestedScrollView PokemonScrollview;
    private static final String TAG = "PokemonSingleCardsActiv";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemonsinglecardactivity);
        PokemonSingleCardView = findViewById(R.id.PokemonViewForSingleCard);
        Pokemonkorttitel = findViewById(R.id.Pokemontitleforsingles);
        PokemonNumber = findViewById(R.id.PokemonSingleNumber);
        Pokemon_container = findViewById(R.id.Pokemonkort_container);
        PokemonScrollview = findViewById(R.id.parent);
        pokemonKortSingleViewModel = ViewModelProviders.of(this).get(PokemonKortSingleViewModel.class);
        subscribeObservers();
        getIncomingIntent();
    }


    private void getIncomingIntent(){
        if(getIntent().hasExtra("pokemonKort")){
            PokemonKort pokemonKort = getIntent().getParcelableExtra("pokemonkort");
            Log.d(TAG, "getIncomingIntent: " +pokemonKort.getName());
            pokemonKortSingleViewModel.searchPokemonApiCards(pokemonKort.getId());

        }
    }
    private void subscribeObservers() {
        pokemonKortSingleViewModel.getSingleData().observe(this, new Observer<PokemonKort>() {
            @Override
            public void onChanged(PokemonKort pokemonKort) {
                if(pokemonKort != null) {
                    Log.d(TAG, "onChanged: ------------");
                    Log.d(TAG, "onChanged: " + pokemonKort.getName());
                }
            }
        });
    }
}

