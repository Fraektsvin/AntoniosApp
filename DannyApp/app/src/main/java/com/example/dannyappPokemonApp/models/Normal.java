package com.example.dannyappPokemonApp.models;

public class Normal {
    public double low;
    public double mid;
    public double high;
    public double market;
    public double directLow;

    public Normal(double low, double mid, double high, double market, double directLow) {
        this.low = low;
        this.mid = mid;
        this.high = high;
        this.market = market;
        this.directLow = directLow;
    }

    public Normal() {
    }
}
