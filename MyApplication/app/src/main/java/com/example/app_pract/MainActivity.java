package com.example.app_pract;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.app_pract.adapter.MainListAdapter;
import com.example.app_pract.pojo.Example;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    TextView textView;
    private static final String TAG = "MainActivity";
    Adapter adapter;
    private RecyclerView rcyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        textView = (TextView)findViewById(R.id.tv1);
        rcyclerView = findViewById(R.id.lv1);
//        listView = (ListView)findViewById(R.id.lv1);
    }

    public void getTodoUsingRouteParameter(View view){
        Call<ArrayList<String>> call = apiInterface.getTodoUsingRouteParameter();
        call.enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                ArrayList<String> body = response.body();

                createList(body);
//                String[] heroName = new String[heroes.size()];
//
//                for(int i=0;i<heroes.size();i++){
//                    heroName[i] = String.valueOf(heroes.get(i).getId()+"\n");
//                }

                Log.d(TAG, "onResponse: "+body);
            }

            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
    }



    private void createList(ArrayList<String> ids) {

        rcyclerView.setAdapter(new MainListAdapter(ids, this));

        rcyclerView.setLayoutManager( new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
    }
}