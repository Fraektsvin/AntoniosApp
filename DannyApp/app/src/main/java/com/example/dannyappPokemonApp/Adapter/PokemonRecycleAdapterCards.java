package com.example.dannyappPokemonApp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dannyapp.R;

import com.example.dannyappPokemonApp.models.PokemonKort;
import com.example.dannyappPokemonApp.models.PokemonSet;


import java.util.ArrayList;
import java.util.List;

public class PokemonRecycleAdapterCards extends RecyclerView.Adapter<RecyclerView. ViewHolder>   {
    private List<PokemonKort> pokemonKorts;
    private OnPokemonListener onPokemonListener;
    private static final int Loading_types = 4;
    private static final int PokemonCard_type = 3;
    private LoadViewholder LoadViewholder;

    public PokemonRecycleAdapterCards(OnPokemonListener onPokemonListenes) {
        onPokemonListener = onPokemonListenes;
        pokemonKorts = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = null;

        switch (i) {
            case PokemonCard_type: {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_pokemoncarditems, viewGroup, false);
                return new PokemonCardViewHolder(view, onPokemonListener);
            }
             case Loading_types: {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_loadinglist, viewGroup, false);
                return new LoadViewholder(view);
            }


            default: {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_pokemoncarditems, viewGroup, false);
                return new PokemonViewHolder(view, onPokemonListener);
            }
        }
    }
    @Override
    public void onBindViewHolder( @NonNull RecyclerView.ViewHolder viewHolder, int position) {

        int itemViewType1 = getItemViewType(position);
        if (itemViewType1 == PokemonCard_type) {

            RequestOptions requestOptions = new RequestOptions()
                    .placeholder(R.drawable.ic_launcher_foreground);

            Glide.with(viewHolder.itemView.getContext())
                    .setDefaultRequestOptions(requestOptions)
                    .load(pokemonKorts.get(position).getImages().getSmall())
                    .fitCenter().centerInside()
                    .into(((PokemonCardViewHolder) viewHolder).Pokemoncard_image);



            ((PokemonCardViewHolder) viewHolder).pokemoncardname.setText(pokemonKorts.get(position).getName());
            ((PokemonCardViewHolder) viewHolder).pokemon_number.setText(pokemonKorts.get(position).getNumber());

        }
    }
    //creating an method towards displaying the
    @Override
    public int getItemViewType(int position) {
        if (pokemonKorts.get(position).getName().equals("Loadings...")) {
            return Loading_types;
        } else {
            return PokemonCard_type;
        }
    }
    public void displayLoadingCards() {
        if (!isLoadingCards()) {
            PokemonKort pokemonKort = new PokemonKort();
            pokemonKort.setName("Loadings...");
            List<PokemonKort> loadingList = new ArrayList<>();
            loadingList.add(pokemonKort);
            pokemonKorts = loadingList;
            notifyDataSetChanged();
        }
    }

    private boolean isLoadingCards() {
        if (pokemonKorts != null) {
            if (pokemonKorts.size() > 0) {
                if (pokemonKorts.get(pokemonKorts.size() - 1).getName().equals("Loadings...")) {
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public int getItemCount() {
            if (pokemonKorts != null) {
                return pokemonKorts.size();
            }
            return 0;
        }
    public void setPokemonKorts(List<PokemonKort> pokemonKortslist) {
        pokemonKorts = pokemonKortslist;
        notifyDataSetChanged();
    }
    public PokemonKort getSelectSet(int position) {
        if(pokemonKorts!=null) {
            if(pokemonKorts.size()>0) {

            }
        }
        return  null;
    }
    public PokemonKort getSelectedCard(int position) {
        if(pokemonKorts != null) {
            if(pokemonKorts.size()> 0 ) {
                return pokemonKorts.get(position);
            }
        }
        return null;
    }

}
