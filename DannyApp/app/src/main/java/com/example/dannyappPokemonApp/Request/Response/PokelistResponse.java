package com.example.dannyappPokemonApp.Request.Response;

import com.example.dannyappPokemonApp.models.PokemonKort;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.example.dannyappPokemonApp.models.Pokeliste;

import java.util.List;

public class PokelistResponse {
//tells retrofit what to look for in response and serialized and deserilazed with expose
    @SerializedName("data")
    @Expose()
    private List<PokemonKort> pokeData;

    public List<PokemonKort> getPokeData() {
        return  pokeData;
    }

    @Override
    public String toString() {
        return "PokelistResponse{" +
                "pokeData=" + pokeData +
                '}';
    }
}
