package com.example.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCalls {

    @GET("posts")
    Call<List<ModelPosts>> getposts();

}
