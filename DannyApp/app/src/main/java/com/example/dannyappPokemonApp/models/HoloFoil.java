package com.example.dannyappPokemonApp.models;

public class HoloFoil {
    private double low;
    private double mid;
    private double market;
    private double directLow;

    public HoloFoil(double low, double mid, double market, double directLow) {
        this.low = low;
        this.mid = mid;
        this.market = market;
        this.directLow = directLow;
    }

    public HoloFoil() {
    }
}
