package com.maaan.classmate.Activity;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.maaan.classmate.Api.ApiRequestData;
import com.maaan.classmate.Api.RetroServer;
import com.maaan.classmate.Model.DataResponse;
import com.maaan.classmate.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AbsenActivity extends AppCompatActivity {
    String nama;
    private ProgressDialog progress;
    @BindView(R.id.eta_nama)
    EditText etAnama;
    @OnClick(R.id.btn_absen) void Absen(){
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Loading, Please Wait");
        progress.show();
        nama = etAnama.getText().toString();
        ApiRequestData ard = RetroServer.konekRetrofit().create(ApiRequestData.class);
        Call<DataResponse> call = ard.AbsenPelajar(nama);

        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                int kode = response.body().getKode();
                if (kode == 201){
                    Toast.makeText(AbsenActivity.this, "Absen Berhasil", Toast.LENGTH_SHORT).show();
                    progress.dismiss();
                    etAnama.setText("");
                    startActivity(new Intent(AbsenActivity.this, HomeActivity.class));
                }else{
                    Toast.makeText(AbsenActivity.this, "Absen Gagal", Toast.LENGTH_SHORT).show();
                    progress.dismiss();
                    etAnama.setText("");
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Toast.makeText(AbsenActivity.this, "ERROR "+t, Toast.LENGTH_SHORT).show();
                progress.dismiss();
            }
        });
    }

=======
import android.os.Bundle;
import com.maaan.classmate.R;

public class AbsenActivity extends AppCompatActivity {
>>>>>>> 8271c302726697bc6dcddf53ebc26c6c312b03e7


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absen);
<<<<<<< HEAD
        ButterKnife.bind(this);
=======

>>>>>>> 8271c302726697bc6dcddf53ebc26c6c312b03e7
    }
}