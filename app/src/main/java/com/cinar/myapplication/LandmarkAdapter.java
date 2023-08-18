package com.cinar.myapplication;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cinar.myapplication.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.landmarkHolder> {

    ArrayList <Landmark> landmarkArrayList;
    public  LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    public landmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //xml' binding bağlama
        //ınflate demek layoutu bağlamak demek
        RecyclerRowBinding recyclerRowBinding  = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);


        return new landmarkHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull landmarkHolder holder, int position) {
            //Yardımcı sınıf görünümleri tutar
        holder.binding.recyclerViewTextView.setText(landmarkArrayList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
              //  intent.putExtra("Landmark",landmarkArrayList.get(position));
                Singleton singleton = Singleton.getInstance();
                singleton.setSetLandmark(landmarkArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
            // xml'de görünümlerin kaç kere oluşacağı
        return 4;
    }

    public  class landmarkHolder extends RecyclerView.ViewHolder{

        RecyclerRowBinding binding;
        public landmarkHolder(@NonNull RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
