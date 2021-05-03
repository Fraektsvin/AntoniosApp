package com.example.dannyappPokemonApp.models;

public class PokemonSet {
    public String id;
    public String name;
    public String series;
    public int printedTotal;
    public int total;
    public Legalities legalities;
    public String releaseDate;
    public String updatedAt;
    public Images images;


    public PokemonSet(String id, String name, String series, int printedTotal, int total, Legalities legalities, String ptcgoCode, String releaseDate, String updatedAt, Images images) {
        this.id = id;
        this.name = name;
        this.series = series;
        this.printedTotal = printedTotal;
        this.total = total;
        this.legalities = legalities;
        this.releaseDate = releaseDate;
        this.updatedAt = updatedAt;
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public int getPrintedTotal() {
        return printedTotal;
    }

    public void setPrintedTotal(int printedTotal) {
        this.printedTotal = printedTotal;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Legalities getLegalities() {
        return legalities;
    }

    public void setLegalities(Legalities legalities) {
        this.legalities = legalities;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }
}
