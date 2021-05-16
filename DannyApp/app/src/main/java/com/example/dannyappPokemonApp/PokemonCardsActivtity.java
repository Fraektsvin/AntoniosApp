package com.example.dannyappPokemonApp;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.dannyapp.R;
import com.example.dannyappPokemonApp.Adapter.OnPokemonListener;
import com.example.dannyappPokemonApp.models.PokemonKort;

public class PokemonCardsActivtity extends BaseActivity implements OnPokemonListener {

    private static final String Tag = "PokemoncardsActivitiy";
    private ImageView Pokemoncard;
    private TextView Pokemoncardtxt, Pokemon_Number;
    private LinearLayout LinearLayoutContainer;
    private ScrollView ScrollViewParent;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemoncarditems);
        Pokemoncard = findViewById(R.id.Pokemoncard_image);
        Pokemoncardtxt = findViewById(R.id.Pokemoncardtxt);
        Pokemon_Number = findViewById(R.id.Pokemon_Number);
        LinearLayoutContainer = findViewById(R.id.LinearLayoutContainer);
        ScrollViewParent = findViewById(R.id.ScrollViewParent);
        getIncomingIntent();
    }
    private void getIncomingIntent() {
    if(getIntent().hasExtra("pokemonKort")) {
        PokemonKort pokemonKort = getIntent().getParcelableExtra("pokemonKort");
        Log.d(Tag, "getIncomingIntent" + pokemonKort.getId());
    }
    }

    @Override
    public void onPokemonclick(int position) {

    }

    @Override
    public void onPokemonCardClick(int position) {

    }
}
