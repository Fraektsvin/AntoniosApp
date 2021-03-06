package com.example.dannyappPokemonApp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class PokemonSet implements Parcelable {
    public String id;
    public String name;
    public String series;
    public Legalities legalities;
    public String releaseDate;
    public String updatedAt;
    public Images images;


    public PokemonSet(String id, String name, String series, Legalities legalities, String releaseDate, String updatedAt, Images images) {
        this.id = id;
        this.name = name;
        this.series = series;
        this.legalities = legalities;
        this.releaseDate = releaseDate;
        this.updatedAt = updatedAt;
        this.images = images;
    }



    public PokemonSet() {

    }

    protected PokemonSet(Parcel in) {
        id = in.readString();
        name = in.readString();
        series = in.readString();
        releaseDate = in.readString();
        updatedAt = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(series);
        dest.writeString(releaseDate);
        dest.writeString(updatedAt);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PokemonSet> CREATOR = new Creator<PokemonSet>() {
        @Override
        public PokemonSet createFromParcel(Parcel in) {
            return new PokemonSet(in);
        }

        @Override
        public PokemonSet[] newArray(int size) {
            return new PokemonSet[size];
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

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
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

    public Images getSetImages() {
        return images;
    }

    public void setSetImages(Images images) {
        this.images = images;
    }



    @Override
    public String toString() {
        return "PokemonSet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", series='" + series + '\'' +
                ", legalities=" + legalities +
                ", releaseDate='" + releaseDate + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", images=" + images +
                '}';
    }
}

