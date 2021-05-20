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

public class FutureRepository {
    /*    private static FutureRepository instance;
        private PokemonKortRepository pokemonKortRepository;
        private PokemonSetRepository pokemonSetRepository;


        public static FutureRepository getInstance(){
            if(instance == null){
                instance = new FutureRepository();
            }
            return instance;
        }


        private FutureRepository() {
            pokemonSetRepository = PokemonSetRepository.getInstance();
            pokemonKortRepository = PokemonKortRepository.getInstance();
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

     */
    }


