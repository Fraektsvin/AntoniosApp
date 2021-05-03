package com.example.dannyappPokemonApp.Util;

import android.util.Log;

import com.example.dannyappPokemonApp.models.Pokeliste;
import com.example.dannyappPokemonApp.models.PokemonSet;

import java.util.List;

public class Testing {

    public static void printPokemonlist(List<PokemonSet> list, String tag) {
        for(PokemonSet pokemonSet: list) {
            Log.d(tag, "printPokemonlist: "+ pokemonSet.getId());
        }
    }
}
