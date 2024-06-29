package com.example.api;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.api.databinding.ActivityItemPostBinding;
import com.example.api.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class AdapterPosts extends RecyclerView.Adapter<AdapterPosts.Holder> {
    ActivityItemPostBinding binding;
    private ArrayList<ModelPosts> postslist;
    public void setList(ArrayList<ModelPosts> list) {
        this.postslist = list;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ActivityItemPostBinding binding = ActivityItemPostBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new Holder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(postslist.get(position));
    }
    @Override
    public int getItemCount() {
        return postslist == null ? 0 : postslist.size();
    }



    class Holder extends RecyclerView.ViewHolder {
        ActivityItemPostBinding binding;

        public Holder(ActivityItemPostBinding binding) {
            super(binding.getRoot());
            this.binding =binding;
        }

        public void bind(ModelPosts user) {
            binding.textBody.setText(user.getBody());
            binding.textTitle.setText(user.getTitle());



        }

    }


}