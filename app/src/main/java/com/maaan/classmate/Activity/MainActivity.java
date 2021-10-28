package com.maaan.classmate.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class MainActivity extends AppCompatActivity {
    String user,pass;
    private ProgressDialog progress;
    @BindView(R.id.et_password) EditText etpass;
    @BindView(R.id.et_username) EditText etuser;

    @OnClick(R.id.btn_login) void login(){
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setIcon(R.drawable.loading);
        progress.setMessage("Loading, Please Wait");
        progress.show();
        user = etuser.getText().toString();
        pass = etpass.getText().toString();

        ApiRequestData ard = RetroServer.konekRetrofit().create(ApiRequestData.class);
        Call<DataResponse> call = ard.Login(user,pass);

        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                int kode = response.body().getKode();
                if(kode == 201){
                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    progress.dismiss();
                    etuser.setText("");
                    etpass.setText("");
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                }else{
                    progress.dismiss();
                    Toast.makeText(MainActivity.this, "Login Gagal, User tidak di temukan", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(MainActivity.this, "Login Gagal "+t, Toast.LENGTH_SHORT).show();
                etuser.setText("");
            }
        });

    }
    @OnClick(R.id.tv_register) void toRegister(){
        startActivity(new Intent(MainActivity.this, RegisterActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

}