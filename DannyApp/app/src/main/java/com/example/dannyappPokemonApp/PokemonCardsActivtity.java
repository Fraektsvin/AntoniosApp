package com.example.dannyappPokemonApp;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dannyapp.R;
import com.example.dannyappPokemonApp.Adapter.OnPokemonListener;
import com.example.dannyappPokemonApp.Adapter.PokemonRecycleAdapterCards;
import com.example.dannyappPokemonApp.Util.Testing;
import com.example.dannyappPokemonApp.Viewmodel.PokemonKortViewModel;

import com.example.dannyappPokemonApp.models.PokemonKort;

import java.util.List;

public class PokemonCardsActivtity extends BaseActivity implements OnPokemonListener {

    private static final String Tag = "PokemoncardsActivitiy";
    private PokemonKortViewModel pokemonKortViewModel;
    private PokemonRecycleAdapterCards pokemonRecycleAdapterCards;
    private RecyclerView recyclerViewcards;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemoncarditems);
        recyclerViewcards = findViewById(R.id.pokemonlistRecyclercards);
        pokemonKortViewModel = ViewModelProviders.of(this).get(PokemonKortViewModel.class);
        initRecyclerViewcards();
        SubscribeObservers();
        initSearchViews();
        //  getIncomingIntent();
    }

        private void SubscribeObservers() {
        pokemonKortViewModel.getData().observe(this, new Observer<List<PokemonKort>>() {


        @Override
        public void onChanged(@Nullable List<PokemonKort> pokelistes) {
            if(pokelistes!= null){

                Testing.printPokemonlistCards("Pokemon Test", pokelistes);
                pokemonRecycleAdapterCards.setPokemonKorts(pokelistes);
            }
        }
    });
}


    private void initRecyclerViewcards() {
        pokemonRecycleAdapterCards = new PokemonRecycleAdapterCards( this);
        recyclerViewcards.setAdapter(pokemonRecycleAdapterCards);
        recyclerViewcards.setLayoutManager(new LinearLayoutManager(this));
    }
    private void initSearchViews() {
        final SearchView searchView = findViewById(R.id.search_viewcards);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                pokemonRecycleAdapterCards.displayLoadingCards();

                pokemonKortViewModel.searchPokemonApiCards("set.id:base1" + query, 1, 250);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }



  /*  private void SetPokemonDetails(List<PokemonKort> pokemonKort) {
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
    private void getIncomingIntent() {
    if(getIntent().hasExtra("pokemonKort")) {
        PokemonKort pokemonKort = getIntent().getParcelableExtra("pokemonKort");
        Log.d(Tag, "getIncomingIntent" + pokemonKort.getId());
        pokemonKortViewModel.searchPokemonApiCards("set.id:" , 1, 250);
    }
    }
*/
     /*   private void showParent() {
        ScrollViewParent.setVisibility(View.VISIBLE);
        }
*/
    @Override
    public void onPokemonclick(int position) {

    }

    @Override
    public void onPokemonCardClick(int position) {

    }




}



