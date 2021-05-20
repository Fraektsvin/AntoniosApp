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

import com.example.dannyapp.R;
import com.example.dannyappPokemonApp.models.PokemonKort;

public class PokemonSingleCardsActivity extends BaseActivity {
    // UI components
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

        getIncomingIntent();
    }


    private void getIncomingIntent(){
        if(getIntent().hasExtra("PokemonKort")){
            PokemonKort pokemonKort = getIntent().getParcelableExtra("Pokemonkort");
            Log.d(TAG, "getIncomingIntent: " +pokemonKort.getName());
        }
    }
}

