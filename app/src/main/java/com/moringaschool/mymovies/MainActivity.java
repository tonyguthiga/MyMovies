package com.moringaschool.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.findMoviesButton) Button mFindMoviesButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFindMoviesButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mFindMoviesButton) {
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, MoviesActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
    }
}
