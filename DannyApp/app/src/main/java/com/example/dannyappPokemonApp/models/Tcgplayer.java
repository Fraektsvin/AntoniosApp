package com.example.dannyappPokemonApp.models;

public class Tcgplayer {
    private String url;
    private String updatedAt;
    private Prices prices;

    public Tcgplayer(String url, String updatedAt, Prices prices) {
        this.url = url;
        this.updatedAt = updatedAt;
        this.prices = prices;
    }

    public Tcgplayer() {
    }
}
