package com.example.dannyappPokemonApp.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dannyapp.R;


public class PokemonCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView Pokemoncard_image;
    TextView pokemoncardname,pokemon_number;
    OnPokemonListener listener;

    public PokemonCardViewHolder( View itemView, OnPokemonListener listener) {
        super(itemView);
        this.listener =listener;

        Pokemoncard_image = itemView.findViewById(R.id.Pokemoncard_image);
        pokemoncardname = itemView.findViewById(R.id.Pokemoncardtxt);
        pokemon_number = itemView.findViewById(R.id.Pokemon_Number);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    listener.onPokemonCardClick(getAdapterPosition());

    }
}


