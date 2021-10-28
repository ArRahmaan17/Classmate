package com.maaan.classmate.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
<<<<<<< HEAD
import android.widget.EditText;
import android.widget.Toast;

import com.maaan.classmate.Api.ApiRequestData;
import com.maaan.classmate.Api.RetroServer;
=======
import android.util.Log;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.maaan.classmate.Api.ApiRequestData;
import com.maaan.classmate.Api.RetroServer;
import com.maaan.classmate.Model.DataModel;
>>>>>>> 8271c302726697bc6dcddf53ebc26c6c312b03e7
import com.maaan.classmate.Model.DataResponse;
import com.maaan.classmate.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
<<<<<<< HEAD
=======
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
>>>>>>> 8271c302726697bc6dcddf53ebc26c6c312b03e7

public class RegisterActivity extends AppCompatActivity {
    String nama, password, foto, email, nama_ibu, no_telp;
    Integer kelas;
    private ProgressDialog progress;
    @BindView(R.id.etr_nama) EditText etrnama;
    @BindView(R.id.etr_pass) EditText etrpass;
    @BindView(R.id.etr_kelas) EditText etrkelas;
    @BindView(R.id.etr_namaibu) EditText etrnamaIbu;
    @BindView(R.id.etr_telepone) EditText etrtelepone;
    @BindView(R.id.etr_email) EditText etremail;

    @OnClick(R.id.btn_register)void daftar(){
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
<<<<<<< HEAD
        progress.setIcon(R.drawable.loading);
=======
>>>>>>> 8271c302726697bc6dcddf53ebc26c6c312b03e7
        progress.setMessage("Loading, Please Wait");
        progress.show();

        nama = etrnama.getText().toString();
        password = etrpass.getText().toString();
        kelas = Integer.parseInt(etrkelas.getText().toString());
        nama_ibu = etrnamaIbu.getText().toString();
        no_telp = etrtelepone.getText().toString();
        email = etremail.getText().toString();
        foto = "";

        ApiRequestData ard = RetroServer.konekRetrofit().create(ApiRequestData.class);
        Call<DataResponse> call = ard.Register(nama, password, kelas, foto, nama_ibu, no_telp, email);

        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                progress.dismiss();

                String pesan = response.body().getPesan();

                Toast.makeText(RegisterActivity.this, " pesan "+pesan, Toast.LENGTH_LONG).show();
                finish();
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(RegisterActivity.this, "Error "+t, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }
}