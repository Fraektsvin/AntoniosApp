package com.example.dannyappPokemonApp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dannyapp.R;

import com.example.dannyappPokemonApp.models.PokemonSet;

import java.util.ArrayList;
import java.util.List;

public class PokemonRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<PokemonSet> list;
    private OnPokemonListener onPokemonListener;
    private static final int Setlist_type = 1;
    private static final int Loading_type = 2;
    private static final int PokemonCard_type = 3;
    private LoadViewholder LoadViewholder;

    public PokemonRecycleAdapter(OnPokemonListener onPokemonListenes) {
        onPokemonListener = onPokemonListenes;
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = null;

        switch (i) {
            case Setlist_type: {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layoutpokemonlist_item, viewGroup, false);
                return new PokemonViewHolder(view, onPokemonListener);

            }
            case Loading_type: {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_loadinglist, viewGroup, false);
                return new LoadViewholder(view);
            }

            default: {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layoutpokemonlist_item, viewGroup, false);
                return new PokemonViewHolder(view, onPokemonListener);
            }
        }

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        int itemViewType = getItemViewType(position);
        if (itemViewType == Setlist_type) {

            RequestOptions requestOptions = new RequestOptions()
                    .placeholder(R.drawable.ic_launcher_foreground);

            Glide.with(viewHolder.itemView.getContext())
                    .setDefaultRequestOptions(requestOptions)
                    .load(list.get(position).getSetImages().getLogo())
                    .into(((PokemonViewHolder) viewHolder).image);


            ((PokemonViewHolder) viewHolder).title.setText(list.get(position).getName());
            ((PokemonViewHolder) viewHolder).setname.setText(list.get(position).getSeries());
            ((PokemonViewHolder) viewHolder).releasedate.setText(list.get(position).getReleaseDate());
        }

        }




    //creating an method towards displaying the
    @Override
    public int getItemViewType(int position) {
       if (list.get(position).getName().equals("Loading...")) {
            return Loading_type;
        } else {
            return Setlist_type;
        }
    }

    public void displayLoading() {
        if (!isLoading()) {
            PokemonSet pokemonSet = new PokemonSet();
            pokemonSet.setName("Loading...");
            List<PokemonSet> loadingList = new ArrayList<>();
            loadingList.add(pokemonSet);
            list = loadingList;
            notifyDataSetChanged();
        }
    }

    private boolean isLoading() {

        if (list != null) {
            if (list.size() > 0) {
                if (list.get(list.size() - 1).getName().equals("Loading...")) {
                    return true;
                }
            }

        }
        return false;

    }



    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
            return 0;
        }


    public void setPokemonlist(List<PokemonSet> pokemonlist) {
        list = pokemonlist;
        notifyDataSetChanged();
    }



}
