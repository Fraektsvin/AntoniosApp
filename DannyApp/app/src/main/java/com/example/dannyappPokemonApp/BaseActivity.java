package com.example.dannyappPokemonApp;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.dannyapp.R;

public  class BaseActivity extends AppCompatActivity {
    public ProgressBar mProgressbar;



    @Override
    public void setContentView(int layoutResID) {
        ConstraintLayout constraintLayout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_main, null);
        FrameLayout frameLayout = constraintLayout.findViewById(R.id.activity_content);
        mProgressbar = constraintLayout.findViewById(R.id.progress_bar);

        getLayoutInflater().inflate(layoutResID, frameLayout, true);
        super.setContentView(layoutResID);

    }
public void showProgressBar(boolean visibility) {
        mProgressbar.setVisibility(visibility? View.VISIBLE : View.INVISIBLE);
}


}

