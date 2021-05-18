package com.example.dannyappPokemonApp.Repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import com.example.dannyappPokemonApp.AppExecutors;
import com.example.dannyappPokemonApp.Request.Response.ApiResponseGeneric;
import com.example.dannyappPokemonApp.Request.Response.PokelistResponse;
import com.example.dannyappPokemonApp.Util.NetworkRessourcehelper;
import com.example.dannyappPokemonApp.Util.Ressource;
import com.example.dannyappPokemonApp.models.PokemonKort;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainRepository {
        private static MainRepository instance;
        private PokemonKortDAO pokemonKortDAO;
        private PokemonSetDAO pokemonSetDAO;


        public static MainRepository getInstance(){
            if(instance == null){
                instance = new MainRepository();
            }
            return instance;
        }


        private MainRepository() {
            pokemonSetDAO = PokemonSetDAO.getInstance();
            pokemonKortDAO = PokemonKortDAO.getInstance();
        }

        public LiveData<Ressource<List<PokemonKort>>> searchRecipesApi(String query, int page, int pageSize){
            return new NetworkRessourcehelper<List<PokemonKort>, PokelistResponse>(AppExecutors.getInstance() ){


                @Override
                protected void saveCallResult(@NonNull @NotNull PokelistResponse item) {
                    return;
                }

                @Override
                protected boolean shouldFetch(@Nullable @org.jetbrains.annotations.Nullable List<PokemonKort> data) {
                    return false;
                }

                @NonNull
                @NotNull
                @Override
                protected LiveData<List<PokemonKort>> loadFromDb() {
                    return null;
                }

                @NonNull
                @NotNull
                @Override
                protected LiveData<ApiResponseGeneric<PokelistResponse>> createCall() {
                    return null;
                }
            }.getAsLiveData();
        }
    }


