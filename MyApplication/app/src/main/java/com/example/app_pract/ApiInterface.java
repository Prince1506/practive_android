package com.example.app_pract;


import com.example.app_pract.pojo.Example;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiInterface{

    @GET("/v0/topstories.json")
    Call<ArrayList<String>>  getTodoUsingRouteParameter();

    @GET("/v0/item/{id}")
    Call<Example> getIdData(@Path("id") String id);
}


