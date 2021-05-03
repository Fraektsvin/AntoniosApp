package com.example.dannyappPokemonApp.Request;

import com.example.dannyappPokemonApp.Util.Constants;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder =
                new Retrofit.Builder()
                .baseUrl(Constants.Base_URL)
                .addConverterFactory(GsonConverterFactory.create());

        private static Retrofit retrofit = retrofitBuilder.build();

        private static PokemonAPI pokemonAPI = retrofit.create(PokemonAPI.class);

        public static PokemonAPI getPokemonAPI() {
            return pokemonAPI;
    }
}