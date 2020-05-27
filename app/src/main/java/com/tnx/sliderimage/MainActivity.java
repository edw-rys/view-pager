package com.tnx.sliderimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.tnx.sliderimage.IO.Models.TravelLocation;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager2 locationsViewPager = findViewById(R.id.locationsViewPager2);
        List<TravelLocation> travelLocations = new ArrayList<>();

        TravelLocation travelLocationEiffelTower = new TravelLocation();
        travelLocationEiffelTower.imageUrl = "https://images.unsplash.com/photo-1511739001486-6bfe10ce785f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80" ;
        travelLocationEiffelTower.title = "France";
        travelLocationEiffelTower.location = "Eiffel Tower";
        travelLocationEiffelTower.startRating = 4.8f;
        travelLocations.add(travelLocationEiffelTower);

        TravelLocation travelLocationObject = new TravelLocation();
        travelLocationEiffelTower.imageUrl = "https://images.unsplash.com/photo-1442335388112-284b13da338f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=600&q=80" ;
        travelLocationEiffelTower.title = "Mountains";
        travelLocationEiffelTower.location = "Mountain";
        travelLocationEiffelTower.startRating = 4.5f;
        travelLocations.add(travelLocationEiffelTower);


        travelLocationObject = new TravelLocation();
        travelLocationObject.imageUrl = "https://images.unsplash.com/photo-1457269449834-928af64c684d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=967&q=80" ;
        travelLocationObject.title = "Nieve";
        travelLocationObject.location = "Copo de nieve";
        travelLocationObject.startRating = 4.3f;
        travelLocations.add(travelLocationObject);



        travelLocationObject = new TravelLocation();
        travelLocationObject.imageUrl = "https://images.unsplash.com/photo-1504164996022-09080787b6b3?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=650&q=80" ;
        travelLocationObject.title = "Phone";
        travelLocationObject.location = "Phone";
        travelLocationObject.startRating = 4.2f;
        travelLocations.add(travelLocationObject);


        travelLocationObject = new TravelLocation();
        travelLocationObject.imageUrl = "https://images.unsplash.com/photo-1504164996022-09080787b6b3?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=650&q=80" ;
        travelLocationObject.title = "Code";
        travelLocationObject.location = "code";
        travelLocationObject.startRating = 4.8f;
        travelLocations.add(travelLocationObject);


        locationsViewPager.setAdapter(new TravelLocationsAdapter(travelLocations));
    }
}
