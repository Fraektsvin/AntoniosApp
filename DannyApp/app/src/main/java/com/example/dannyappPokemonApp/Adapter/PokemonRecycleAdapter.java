package com.example.dannyappPokemonApp.Adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dannyapp.R;
import com.example.dannyappPokemonApp.models.Images;
import com.example.dannyappPokemonApp.models.Pokeliste;
import com.example.dannyappPokemonApp.models.PokemonSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PokemonRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<PokemonSet> list;
    private OnPokemonListener onPokemonListener;
    private static final int Setlist_type = 1;
    private static final int Loading_type = 2;


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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        int itemViewType = getItemViewType(i);
        if (itemViewType == Setlist_type) {

            RequestOptions requestOptions = new RequestOptions()
                    .centerCrop()
                    .error(R.drawable.ic_launcher_background);

            Glide.with(((PokemonViewHolder) viewHolder).itemView)
                    .setDefaultRequestOptions(requestOptions)
                    .load(list.get(i).getImages().getLogo())
                    .into(((PokemonViewHolder) viewHolder).image);


            ((PokemonViewHolder) viewHolder).title.setText(list.get(i).getName());
            ((PokemonViewHolder) viewHolder).setname.setText(list.get(i).getSeries());
            ((PokemonViewHolder) viewHolder).releasedate.setText(list.get(i).getReleaseDate());

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
            pokemonSet.setName("LOADING...");
            List<PokemonSet> loadingList = new ArrayList<>();
            loadingList.add(pokemonSet);
            list = loadingList;
            notifyDataSetChanged();
        }
    }

    private boolean isLoading() {
        if (list != null) {
            if (list.size() > 0) {
                if (list.get(list.size() - 1).getName().equals("LOADING...")) {
                    return true;
                }
            }

        }
        return false;

    }
    @Override
    public int getItemCount() {
        return list.size();
}

    public void setPokemonlist(List<PokemonSet> pokemonlist) {
        list = pokemonlist;
        notifyDataSetChanged();
    }

}
