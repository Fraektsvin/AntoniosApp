package com.example.dannyappPokemonApp.models;

public class Images {
    public String Symbol;
    public String logo;
    public String small;
    public String large;

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public Images(String symbol, String logo, String small, String large) {
        Symbol = symbol;
        this.logo = logo;
        this.small = small;
        this.large = large;
    }

    public Images() {
    }
}
