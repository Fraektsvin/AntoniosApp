package com.example.dannyappPokemonApp.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dannyapp.R;

public class PokemonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView title, setname, releasedate;
    ImageView image,loading;
    OnPokemonListener onPokemonListener;

    public PokemonViewHolder( View itemView, OnPokemonListener onPokemonListener) {
        super(itemView);
        this.onPokemonListener = onPokemonListener;

        title = itemView.findViewById(R.id.Pokemon_title);
        setname = itemView.findViewById(R.id.Pokemon_setname);
        releasedate = itemView.findViewById(R.id.Pokemon_releasedate);
        image = itemView.findViewById(R.id.Pokemon_image);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    onPokemonListener.onPokemonclick(getAdapterPosition());
    }
}
