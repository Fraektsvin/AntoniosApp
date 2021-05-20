package com.example.dannyappPokemonApp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Images implements Parcelable {
    public String Symbol;
    public String logo;
    public String small;
    public String large;

    protected Images(Parcel in) {
        Symbol = in.readString();
        logo = in.readString();
        small = in.readString();
        large = in.readString();

    }


    public static final Creator<Images> CREATOR = new Creator<Images>() {
        @Override
        public Images createFromParcel(Parcel in) {
            return new Images(in);
        }

        @Override
        public Images[] newArray(int size) {
            return new Images[size];
        }
    };

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




    public Images(String symbol, String logo, String small, String large) {
        Symbol = symbol;
        this.logo = logo;
        this.small = small;
        this.large = large;

    }

    public Images() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Symbol);
        dest.writeString(logo);
        dest.writeString(small);
        dest.writeString(large);
    }
}
