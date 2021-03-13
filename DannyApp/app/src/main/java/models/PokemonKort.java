package models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class PokemonKort implements Parcelable {

     private String id;
    private String name;
    private String supertype;
    private String[] set;
    private String[] images;

    public  PokemonKort(String id, String name, String supertype,
                       String[] set, String[] images) {
        this.id = id;
        this.name = name;
        this.supertype = supertype;
        this.set = set;
        this.images = images;
    }

    protected PokemonKort(Parcel in) {
        id = in.readString();
        name = in.readString();
        supertype = in.readString();
        set = in.createStringArray();
        images = in.createStringArray();
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

    public String[] getSet() {
        return set;
    }

    public void setSet(String[] set) {
        this.set = set;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "PokemonKort{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", supertype='" + supertype + '\'' +
                ", set=" + Arrays.toString(set) +
                ", images=" + Arrays.toString(images) +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(supertype);
        dest.writeStringArray(set);
        dest.writeStringArray(images);
    }
}
