package com.example.dannyappPokemonApp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class PokemonKort implements Parcelable   {

    public String id;
    public String name;
    public String supertype;
    public List<String> subtypes;
    public List<String> types;
    public PokemonSet set;
    public String number;
    public String artist;
    public String rarity;
    public List<Integer> nationalPokedexNumbers;
    public Legalities legalities;
    public Images images;
    public Tcgplayer tcgplayer;
    public String Description;

    public PokemonKort() {
    }

    public PokemonKort(String id, String name, String supertype, List<String> subtypes, List<String> types, PokemonSet set, String number, String artist, String rarity, List<Integer> nationalPokedexNumbers, Legalities legalities, Images images, Tcgplayer tcgplayer, String description) {
        this.id = id;
        this.name = name;
        this.supertype = supertype;
        this.subtypes = subtypes;

        this.types = types;

        this.set = set;
        this.number = number;
        this.artist = artist;
        this.rarity = rarity;
        this.nationalPokedexNumbers = nationalPokedexNumbers;
        this.legalities = legalities;
        this.images = images;
        this.tcgplayer = tcgplayer;

        Description = description;
    }

    protected PokemonKort(Parcel in) {
        id = in.readString();
        name = in.readString();
        supertype = in.readString();
        subtypes = in.createStringArrayList();

        types = in.createStringArrayList();

        number = in.readString();
        artist = in.readString();
        rarity = in.readString();

        Description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(supertype);
        dest.writeStringList(subtypes);
        dest.writeStringList(types);
        dest.writeString(number);
        dest.writeString(artist);
        dest.writeString(rarity);
        dest.writeString(Description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PokemonKort> CREATOR = new Creator<PokemonKort>() {
        @Override
        public PokemonKort createFromParcel(Parcel in) {
            return new PokemonKort(in);
        }

        @Override
        public PokemonKort[] newArray(int size) {
            return new PokemonKort[size];
        }
    };

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

    public String getSupertype() {
        return supertype;
    }

    public void setSupertype(String supertype) {
        this.supertype = supertype;
    }

    public List<String> getSubtypes() {
        return subtypes;
    }

    public void setSubtypes(List<String> subtypes) {
        this.subtypes = subtypes;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public PokemonSet getSet() {
        return set;
    }

    public void setSet(PokemonSet set) {
        this.set = set;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public List<Integer> getNationalPokedexNumbers() {
        return nationalPokedexNumbers;
    }

    public void setNationalPokedexNumbers(List<Integer> nationalPokedexNumbers) {
        this.nationalPokedexNumbers = nationalPokedexNumbers;
    }

    public Legalities getLegalities() {
        return legalities;
    }

    public void setLegalities(Legalities legalities) {
        this.legalities = legalities;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public Tcgplayer getTcgplayer() {
        return tcgplayer;
    }

    public void setTcgplayer(Tcgplayer tcgplayer) {
        this.tcgplayer = tcgplayer;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}