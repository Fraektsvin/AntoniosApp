package com.example.dannyappPokemonApp.Util;

import android.util.Log;

import com.example.dannyappPokemonApp.models.Pokeliste;
import com.example.dannyappPokemonApp.models.PokemonKort;
import com.example.dannyappPokemonApp.models.PokemonSet;

import java.util.List;

public class Testing {

    public static void printPokemonlist(String tag, List<PokemonSet> list) {
        for (PokemonSet pokemonSet : list) {
            Log.d(tag, "printPokemonlist: " + pokemonSet.getId() + "." + pokemonSet.getReleaseDate());
        }
    }
    public static void printPokemonlistCards(String tag, List< PokemonKort > list) {
        for(PokemonKort pokemonKort: list) {
            Log.d(tag, "printPokemonlist: "+ pokemonKort.getId() + "." + pokemonKort.getName());
        }
    }
}
