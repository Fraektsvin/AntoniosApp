package com.example.dannyappPokemonApp.models;

public class BoosterPacks {

    public String id;
    public String name;
    public PokemonSet set;
    public Images images;
    public String Description;

    public BoosterPacks(String id, String name, PokemonSet set, Images images, String description) {
        this.id = id;
        this.name = name;
        this.set = set;
        this.images = images;
        Description = description;
    }

    public BoosterPacks() {
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

    public PokemonSet getSet() {
        return set;
    }

    public void setSet(PokemonSet set) {
        this.set = set;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
