package com.maaan.classmate.Api;


import com.maaan.classmate.Model.DataResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRequestData {
    @FormUrlEncoded
    @POST("register.php")
    Call<DataResponse> Register(
            @Field("nama") String nama,
            @Field("password") String password,
            @Field("kelas") Integer kelas,
            @Field("foto") String foto,
            @Field("namaibu") String nama_ibu,
            @Field("telphone") String no_telp,
            @Field("email") String email
    );

    @FormUrlEncoded
    @POST("login.php")
    Call<DataResponse> Login(
            @Field("nama") String nama,
            @Field("password") String pass
    );

    @GET("selectdatatugas.php")
    Call<DataResponse> LoadTugas();

    @GET("selectdatajadwal.php")
    Call<DataResponse> LoadJadwal();

    @FormUrlEncoded
    @POST("absen.php")
    Call<DataResponse> AbsenPelajar(
            @Field("nama") String nama
    );


}
