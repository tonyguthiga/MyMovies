package com.moringaschool.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesActivity extends AppCompatActivity {
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;

    private String[] movies = new String[] {"The Avengers", "The Big Bang Theory",
            "Life of Pie", "The Bourne Identity", "The Martian", "The Originals",
            "Sleepy Hollow", "Revolution", "The Rookie", "The Blacklist",
            "The Vampire Diary", " Merlin", "Blackish",
            "Game of Thrones", "Vikings"};
    private String[] genres = new String[] {"Superhero Drama", "Comedy",
            "Drama", "Action", "Science Fiction", "Supernatural Drama",
            "Supernatural Drama", "Post Apocalyptic", "Police Procedural Drama", "Crime Thriller",
            "Supernatural Teen Drama", "Fantasy Adventure Drama", "Sitcom Comedy",
            "Fantasy Drama", "Historical Fantasy Drama"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        ButterKnife.bind(this);

        MyMoviesArrayAdapter adapter = new MyMoviesArrayAdapter(this, android.R.layout.simple_list_item_1, movies, genres);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(MoviesActivity.this, restaurant, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the movies with the title: " + location);
    }
}