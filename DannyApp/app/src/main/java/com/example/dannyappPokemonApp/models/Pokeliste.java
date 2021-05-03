package com.example.dannyappPokemonApp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Pokeliste implements Parcelable {

        public List<PokemonKort> data;
        public int page;
        public int pageSize;
        public int count;
        public int totalCount;

        public Pokeliste() {
        }

        public Pokeliste(List<PokemonKort> data, int page, int pageSize, int count, int totalCount) {
                this.data = data;
                this.page = page;
                this.pageSize = pageSize;
                this.count = count;
                this.totalCount = totalCount;
        }

        protected Pokeliste(Parcel in) {
                page = in.readInt();
                pageSize = in.readInt();
                count = in.readInt();
                totalCount = in.readInt();
        }

        public static final Creator<Pokeliste> CREATOR = new Creator<Pokeliste>() {
                @Override
                public Pokeliste createFromParcel(Parcel in) {
                        return new Pokeliste(in);
                }

                @Override
                public Pokeliste[] newArray(int size) {
                        return new Pokeliste[size];
                }
        };

        public List<PokemonKort> getData() {
                return data;
        }

        public void setData(List<PokemonKort> data) {
                this.data = data;
        }

        public int getPage() {
                return page;
        }

        public void setPage(int page) {
                this.page = page;
        }

        public int getPageSize() {
                return pageSize;
        }

        public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
        }

        public int getCount() {
                return count;
        }

        public void setCount(int count) {
                this.count = count;
        }

        public int getTotalCount() {
                return totalCount;
        }

        public void setTotalCount(int totalCount) {
                this.totalCount = totalCount;
        }

        @Override
        public int describeContents() {
                return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(page);
                dest.writeInt(pageSize);
                dest.writeInt(count);
                dest.writeInt(totalCount);
        }
}



