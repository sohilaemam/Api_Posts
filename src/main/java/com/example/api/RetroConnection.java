package com.example.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroConnection {
    private static Retrofit retrofit;
    private static Retrofit getRetrofit()
    {
        if(retrofit==null)
        {
            retrofit=new  Retrofit.Builder().
                    baseUrl("https://jsonplaceholder.typicode.com/").
                    addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }
    public static ApiCalls getIncs()
    {
        return getRetrofit().create(ApiCalls.class);
    }
}