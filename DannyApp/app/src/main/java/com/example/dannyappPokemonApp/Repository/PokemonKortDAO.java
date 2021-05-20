package com.example.dannyappPokemonApp.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.dannyappPokemonApp.Request.PokemonApiCards;
import com.example.dannyappPokemonApp.Request.PokemonApiClient;
import com.example.dannyappPokemonApp.models.PokemonKort;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
/*import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
*/
import java.util.ArrayList;
import java.util.List;

public class PokemonKortDAO {
    private PokemonApiCards pokemonApiCards;
    private static PokemonKortDAO instance;
   /* private FirebaseDatabase database;
    private static DatabaseReference databaseReference;
   // private StorageReference storageReference;
   // private StorageTask storageTask;
   /* private final String datainfo = "PokemonCardHolder";
    private MutableLiveData<List<PokemonKort>> Actullist;
    private MutableLiveData<List<PokemonKort>> Pokemonholder;
*/
    public static PokemonKortDAO getInstance() {
        if(instance== null) {
            instance = new PokemonKortDAO();
        }
        return instance;
    }

    private  PokemonKortDAO() {
      /*  Pokemonholder = new MutableLiveData<>(new ArrayList<>());
        Actullist = new MutableLiveData<>(new ArrayList<>());
        database = FirebaseDatabase.getInstance("https://dannyapp-3152f-default-rtdb.europe-west1.firebasedatabase.app/");
        databaseReference = database.getReference().child("user");
      //  storageReference = FirebaseStorage.getInstance("")
*/
        pokemonApiCards = PokemonApiCards.getInstance();
    }
    public LiveData<List<PokemonKort>> getData() {
        return pokemonApiCards.getData();
    }

    public LiveData<PokemonKort> getSingleData() {
        return pokemonApiCards.getSingleData();
    }

    public void searchPokemonApiCards(String query, int page, int pageSize) {
        if(page== 0) {
            page = 1;
        }
        pokemonApiCards.searchPokemonKortApi(query, page, pageSize);
    }
    public void searchPokemonSingleAPICards(String pokemonkortID ) {

        pokemonApiCards.searchPokemonkortID(pokemonkortID);
    }
}
