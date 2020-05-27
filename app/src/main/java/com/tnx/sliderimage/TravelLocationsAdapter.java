package com.tnx.sliderimage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;
import com.tnx.sliderimage.IO.Models.TravelLocation;

import java.util.List;

public class TravelLocationsAdapter extends  RecyclerView.Adapter<TravelLocationsAdapter.TravelLocationViewsHolder>{
    List<TravelLocation>  travelLocations;

    public TravelLocationsAdapter(List<TravelLocation> travelLocations) {
        this.travelLocations = travelLocations;
    }

    @NonNull
    @Override
    public TravelLocationViewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TravelLocationViewsHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_location,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull TravelLocationViewsHolder holder, int position) {
        holder.setLocation(travelLocations.get(position));
    }

    @Override
    public int getItemCount() {
        return travelLocations.size();
    }

    static  class TravelLocationViewsHolder extends RecyclerView.ViewHolder{
        private KenBurnsView kbvLocation;
        private TextView textTitle, textLocation, textStartRating;
        TravelLocationViewsHolder(@NonNull View itemView) {
            super(itemView);
            this.kbvLocation = itemView.findViewById(R.id.kbvLocation);
            this.textTitle = itemView.findViewById(R.id.textTitle);
            this.textLocation = itemView.findViewById(R.id.textLocation);
            this.textStartRating = itemView.findViewById(R.id.textStartRating);
        }
        void setLocation(TravelLocation travelLocation){
            Picasso.get().load(travelLocation.imageUrl).into(kbvLocation);
            this.textTitle.setText(travelLocation.title);
            this.textLocation.setText(travelLocation.location);
            this.textStartRating.setText(String.valueOf(travelLocation.startRating));
        }
    }
}
