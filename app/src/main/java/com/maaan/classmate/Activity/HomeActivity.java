package com.maaan.classmate.Activity;

<<<<<<< HEAD
import androidx.annotation.RequiresApi;
=======
>>>>>>> 8271c302726697bc6dcddf53ebc26c6c312b03e7
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.AlertDialog;
import android.content.Intent;
<<<<<<< HEAD
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
=======
import android.os.Bundle;
>>>>>>> 8271c302726697bc6dcddf53ebc26c6c312b03e7
import android.widget.TextView;
import android.widget.Toast;

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
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    private List<DataModel> result = new ArrayList<>();
    private AdapterTugas viewAdapterTugas;

    @BindView(R.id.rv_tugas) RecyclerView rvtugas;
    @BindView(R.id.srl_data) SwipeRefreshLayout srldata;

    @OnClick (R.id.iv_materi) void materi(){
        startActivity(new Intent(HomeActivity.this, MateriActivity.class));
    }
    @OnClick (R.id.iv_absen) void absen(){
        startActivity(new Intent(HomeActivity.this, AbsenActivity.class));
    }
    @OnClick (R.id.iv_jadwal) void jadwal(){
        startActivity(new Intent(HomeActivity.this, JadwalActivity.class));
    }
    @OnClick (R.id.iv_tugas) void tugas(){
        startActivity(new Intent(HomeActivity.this, TugasActivity.class));
    }

<<<<<<< HEAD
    @RequiresApi(api = Build.VERSION_CODES.O)
=======
>>>>>>> 8271c302726697bc6dcddf53ebc26c6c312b03e7
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        viewAdapterTugas = new AdapterTugas(this, result);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvtugas.setLayoutManager(mLayoutManager);
        rvtugas.setItemAnimator(new DefaultItemAnimator());
        rvtugas.setAdapter(viewAdapterTugas);

        srldata.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srldata.setRefreshing(true);
                loadTugasSiswa();
                srldata.setRefreshing(false);
                succes();
            }
        });
    }

    protected void onResume() {
        super.onResume();
        loadTugasSiswa();
    }

    private void succes(){
<<<<<<< HEAD
        if (result.isEmpty()){
            Toast.makeText(this, "Load data tugas gagal", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Load data tugas berhasil", Toast.LENGTH_SHORT).show();
        }


=======
        Toast.makeText(this, "Success Load Data Tugas", Toast.LENGTH_SHORT).show();
>>>>>>> 8271c302726697bc6dcddf53ebc26c6c312b03e7
    }

    private void loadTugasSiswa(){

        ApiRequestData ard = RetroServer.konekRetrofit().create(ApiRequestData.class);
        Call<DataResponse> call = ard.LoadTugas();

        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                result = response.body().getData();
                viewAdapterTugas = new AdapterTugas(HomeActivity.this, result);
                rvtugas.setAdapter(viewAdapterTugas);
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(HomeActivity.this);
                alertDialog.setTitle(" Error ");
                alertDialog.setMessage(t+"");
                alertDialog.setCancelable(true);
                alertDialog.show();
            }
        });
    }
}