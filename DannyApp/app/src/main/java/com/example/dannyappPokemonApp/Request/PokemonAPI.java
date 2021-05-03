package com.example.dannyappPokemonApp.Request;

import com.example.dannyappPokemonApp.Request.Response.PokeSearchSet;
import com.example.dannyappPokemonApp.Request.Response.PokelistResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokemonAPI {
        @GET("v2/cards")
        Call<PokelistResponse> getList(
                @Query("key") String key,
                @Query("q") String query,
                @Query("page") String page,
                @Query("pageSize") String pageSize
        );
        @GET("v2/sets")
        Call<PokeSearchSet> getSet(
                @Query("key") String key,
                @Query("q") String query



        );

}
