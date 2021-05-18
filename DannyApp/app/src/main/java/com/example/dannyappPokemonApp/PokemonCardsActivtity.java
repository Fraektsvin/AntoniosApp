package com.example.dannyappPokemonApp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dannyapp.R;
import com.example.dannyappPokemonApp.Adapter.OnPokemonListener;
import com.example.dannyappPokemonApp.Adapter.PokemonCardViewHolder;
import com.example.dannyappPokemonApp.Adapter.PokemonRecycleAdapter;
import com.example.dannyappPokemonApp.Viewmodel.PokemonKortViewModel;
import com.example.dannyappPokemonApp.models.PokemonKort;

import java.util.List;

public class PokemonCardsActivtity extends BaseActivity implements OnPokemonListener {

    private static final String Tag = "PokemoncardsActivitiy";
    private ImageView Pokemoncard;
    private TextView Pokemoncardtxt, Pokemon_Number;
    private LinearLayout LinearLayoutContainer;
    private ScrollView ScrollViewParent;
    private PokemonKortViewModel pokemonKortViewModel;
    private PokemonRecycleAdapter pokemonRecycleAdapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemoncarditems);
        Pokemoncard = findViewById(R.id.Pokemoncard_image);
        Pokemoncardtxt = findViewById(R.id.Pokemoncardtxt);
        Pokemon_Number = findViewById(R.id.Pokemon_Number);
        LinearLayoutContainer = findViewById(R.id.LinearLayoutContainer);
        ScrollViewParent = findViewById(R.id.ScrollViewParent);
        pokemonKortViewModel = ViewModelProviders.of(this).get(PokemonKortViewModel.class);
        showProgressBar(true);
        initRecyclerView();
        SubscribeObservers();
        getIncomingIntent();
    }
    private void getIncomingIntent() {
    if(getIntent().hasExtra("pokemonKort")) {
        PokemonKort pokemonKort = getIntent().getParcelableExtra("pokemonKort");
        Log.d(Tag, "getIncomingIntent" + pokemonKort.getId());
        pokemonKortViewModel.searchPokemonApiCards("set.id:" , 1, 250);
    }
    }
private void SubscribeObservers() {
        pokemonKortViewModel.getViewState().observe(this, new Observer<PokemonKortViewModel.ViewState>() {
            @Override
            public void onChanged(PokemonKortViewModel.ViewState viewState) {
                if(viewState!= null) {
                    switch (viewState) {
                        case Pokemonkort: {
                            displaypokemoncards();
                            break;
                        }

                        case PokemonSet: {
                            // another observer will work 
                        }
                    }
                }

            }
        } {
            @Override
            public void onChanged(@NonNull List<PokemonKort> pokemonKortList) {
                if (viewState != null) {
                    pokemonRecycleAdapter.setPokemonKorts(pokemonKortList);

                }
            }
        });
        }

    private void displaypokemoncards() {
        pokemonRecycleAdapter.displayLoadingCards();
    }

    private void initRecyclerView() {
        pokemonRecycleAdapter = new PokemonRecycleAdapter( this);
        recyclerView.setAdapter(pokemonRecycleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



    private void SetPokemonDetails(List<PokemonKort> pokemonKort) {
        if(pokemonKort!= null) {
            RequestOptions requestOptions = new RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background);
            Glide.with(this)
                    .setDefaultRequestOptions(requestOptions)
                    .load(new PokemonKort().getImage().getSmall())
                    .into(Pokemoncard);

            Pokemon_Number.setText(new PokemonKort.getName());
            Pokemoncardtxt.setText(pokemonKort.getNumber());



            }
        showParent();
        showProgressBar(false);
        }




        private void showParent() {
        ScrollViewParent.setVisibility(View.VISIBLE);
        }

    @Override
    public void onPokemonclick(int position) {

    }

    @Override
    public void onPokemonCardClick(int position) {

    }

}



