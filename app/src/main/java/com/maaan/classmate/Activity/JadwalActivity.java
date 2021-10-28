package com.maaan.classmate.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.AlertDialog;
import android.os.Bundle;

import com.maaan.classmate.Adapter.AdapterJadwal;
import com.maaan.classmate.Adapter.AdapterTugas;
import com.maaan.classmate.Api.ApiRequestData;
import com.maaan.classmate.Api.RetroServer;
import com.maaan.classmate.Model.DataModel;
import com.maaan.classmate.Model.DataResponse;
import com.maaan.classmate.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalActivity extends AppCompatActivity {

    private List<DataModel> result = new ArrayList<>();
    private AdapterJadwal viewAdapterJadwal;

    @BindView(R.id.rv_jadwal) RecyclerView rvJadwal;
    @BindView(R.id.srl_data)  SwipeRefreshLayout srldata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);
        ButterKnife.bind(this);
        viewAdapterJadwal = new AdapterJadwal(this, result);
        RecyclerView.LayoutManager mLayoutmanager = new LinearLayoutManager(getApplicationContext());
        rvJadwal.setLayoutManager(mLayoutmanager);
        rvJadwal.setItemAnimator(new DefaultItemAnimator());
        rvJadwal.setAdapter(viewAdapterJadwal);

        srldata.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srldata.setRefreshing(true);
                loadJadwal();
                srldata.setRefreshing(false);
            }
        });
    }

    protected void onResume() {
        super.onResume();
        loadJadwal();
    }

    private void loadJadwal(){
        ApiRequestData ard = RetroServer.konekRetrofit().create(ApiRequestData.class);
        Call<DataResponse> call = ard.LoadJadwal();

        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                result = response.body().getData();
                viewAdapterJadwal = new AdapterJadwal(JadwalActivity.this, result);
                rvJadwal.setAdapter(viewAdapterJadwal);
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(JadwalActivity.this);
                alertDialog.setTitle(" "+t+" ");
                alertDialog.setCancelable(true);
                alertDialog.show();
            }
        });
    }
}