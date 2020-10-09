package com.example.app_pract.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.app_pract.ApiClient;
import com.example.app_pract.ApiInterface;
import com.example.app_pract.R;
import com.example.app_pract.constants.KeyConstant;
import com.example.app_pract.pojo.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class DetailActivity extends Activity {
    String id;
    ApiInterface apiInterface;
    private TextView tv_fire_cracker_val;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

        tv_fire_cracker_val = findViewById(R.id.tv_fire_cracker_val);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        id = getIntent().getStringExtra(KeyConstant.KEY_ID);
        getIdData(id);
    }

    public void getIdData(String id){
        id =  id + ".json";
        Call<Example> call = apiInterface.getIdData(id);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example body = response.body();

                updateUi(body);
//                String[] heroName = new String[heroes.size()];
//
//                for(int i=0;i<heroes.size();i++){
//                    heroName[i] = String.valueOf(heroes.get(i).getId()+"\n");
//                }

                Log.d(TAG, "onResponse: "+body);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
    }

    private void updateUi(Example body) {
        tv_fire_cracker_val.setText(body.getTitle());
    }

}
