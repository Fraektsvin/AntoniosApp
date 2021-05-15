package com.example.dannyappPokemonApp.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dannyapp.R;

import org.jetbrains.annotations.NotNull;

public class PokemonCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    OnPokemonListener listener;
    ImageView Pokemoncard;
    TextView pokemoncardname;
    public PokemonCardViewHolder( View itemView, OnPokemonListener listener) {
        super(itemView);
        this.listener =listener;
        Pokemoncard = itemView.findViewById(R.id.Pokemoncard_image);
        pokemoncardname = itemView.findViewById(R.id.Pokemoncardtxt);

        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
    listener.onPokemonCardClick(pokemoncardname.getText().toString());
    }
}


