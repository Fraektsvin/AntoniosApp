package com.example.dannyappPokemonApp.Util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

//Good for checcking data and make sure your code runs smoothly
public class Ressource<T> {

    @NonNull
    public final Status status;

    @Nullable
    public final T data;

    @Nullable
    public final String message;

    private Ressource(@NonNull Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Ressource<T> success(@NonNull T data) {
        return new Ressource<>(Status.SUCCESS, data, null);
    }

    public static <T> Ressource<T> error(@NonNull String msg, @Nullable T data) {
        return new Ressource<>(Status.ERROR, data, msg);
    }

    public static <T> Ressource<T> loading(@Nullable T data) {
        return new Ressource<>(Status.LOADING, data, null);
    }

    public enum Status {SUCCESS, ERROR, LOADING}
}

    //documentation fra https://developer.android.com/jetpack/guide#recommended-app-arch