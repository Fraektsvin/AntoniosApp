package com.example.dannyappPokemonApp.Request.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.example.dannyappPokemonApp.models.PokemonSet;

public class PokeSearchSet {
    @SerializedName("data")
    @Expose
    private PokemonSet set;

    public PokemonSet getSet() {
        return set;
    }

    @Override
    public String toString() {
        return "PokeSearchSet{" +
                "set=" + set +
                '}';
    }
}
