package com.example.dannyapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;


public class PokemonListActivity extends BaseActivity {

    MainactivityViewModel viewModel;
    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        viewModel = new ViewModelProvider(this).get(MainactivityViewModel.class);
        viewModel.getMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String message) {
                textView.setText(message);

            }
        });

        viewModel.isLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLoading) {
                int visibility = isLoading ? View.VISIBLE : View.INVISIBLE;
                progressBar.setVisibility(visibility);
            }
        });
    }

    public void retrieveDataFrominternet(View view) {
            viewModel.retrieveData();
    }
}