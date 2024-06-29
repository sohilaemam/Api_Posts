package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.api.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    AdapterPosts adapterPosts=new AdapterPosts();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        RetroConnection.getIncs().getposts()
                .enqueue(new Callback<List<ModelPosts>>() {
                    @Override
                    public void onResponse(Call<List<ModelPosts>> call, Response<List<ModelPosts>> response) {
                        adapterPosts.setList((ArrayList<ModelPosts>) response.body());
                        binding.recyclerPosts.setAdapter(adapterPosts);
                    }
                    @Override
                    public void onFailure(Call<List<ModelPosts>> call, Throwable t) {
                        Log.e("TAG","onFailure: ");

                    }
                });

    }
}