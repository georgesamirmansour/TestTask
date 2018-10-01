package com.example.gogos.testtask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AfterLogin extends AppCompatActivity {

    List<data> dataList;
    RecyclerView recyclerView;
    DataRvAdapter dataRvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        dataList = new ArrayList<>();
        recyclerView = findViewById(R.id.rv_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        dataRvAdapter = new DataRvAdapter(getApplicationContext(), dataList);
        recyclerView.setAdapter(dataRvAdapter);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<data>> call = apiService.getData();
        call.enqueue(new Callback<List<data>>() {
            @Override
            public void onResponse(Call<List<data>> call, Response<List<data>> response) {
                dataList = response.body();
                Log.d("TAG", "onResponse: " + dataList);
                dataRvAdapter.setDataList(dataList);
            }

            @Override
            public void onFailure(Call<List<data>> call, Throwable t) {
                Log.d("TAG", "onFailure: " + t.toString());
            }
        });
    }

    public void apiData() {

    }
}
