package com.example.dannyappPokemonApp.Request.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.example.dannyappPokemonApp.models.PokemonSet;

import java.util.List;

public class PokeSearchSet {
    @SerializedName("data")
    @Expose
    private List<PokemonSet> set;

    @SerializedName("count")
    @Expose
    private int count;

    public int getCount() {
        return count;
    }

    public List<PokemonSet> getSet() {
        return set;
    }

    @Override
    public String toString() {
        return "PokeSearchSet{" +
                "set=" + set +
                ", count=" + count +
                '}';
    }
}
