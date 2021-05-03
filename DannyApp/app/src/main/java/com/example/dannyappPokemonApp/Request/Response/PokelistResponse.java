package com.example.dannyappPokemonApp.Request.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.example.dannyappPokemonApp.models.Pokeliste;

public class PokelistResponse {
//tells retrofit what to look for in response and serialized and deserilazed with expose
    @SerializedName("data")
    @Expose()
    private Pokeliste pokeData;

    public Pokeliste getPokeData() {
        return pokeData;
    }

    @Override
    public String toString() {
        return "PokelistResponse{" +
                "pokeData=" + pokeData +
                '}';
    }
}
