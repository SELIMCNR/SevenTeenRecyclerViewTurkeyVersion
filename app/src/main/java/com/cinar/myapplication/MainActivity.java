package com.cinar.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.cinar.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    ArrayList<Landmark> landmarkArrayList;
    //static  Landmark choesnLandmark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        landmarkArrayList = new ArrayList<>();
        Landmark konya = new Landmark("Konya","Turkey",R.drawable.simge);
        Landmark nevşehir = new Landmark("Nevşehir","Turkey",R.drawable.simge2);
        Landmark antalya = new Landmark("Antalya","Turkey",R.drawable.simge3);
        Landmark ankara = new Landmark("Ankara","Turkey",R.drawable.simge4);

        landmarkArrayList.add(konya);
        landmarkArrayList.add(nevşehir);
        landmarkArrayList.add(antalya);
        landmarkArrayList.add(ankara);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);


    }
}