package com.maaan.classmate.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maaan.classmate.Model.DataModel;
import com.maaan.classmate.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTugas extends RecyclerView.Adapter<AdapterTugas.HolderDataTugas> {

    private Context context;
    private List<DataModel> result;
    private int id;

    public AdapterTugas(Context context, List<DataModel> result) {
        this.context = context;
        this.result = result;
    }


    @Override
    public HolderDataTugas onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlisttugas, parent, false);
        HolderDataTugas holder = new HolderDataTugas(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(HolderDataTugas holder, int position) {
        DataModel dataModel = result.get(position);
        this.id = dataModel.getId();
        holder.judul.setText(dataModel.getJudul());
        holder.detail.setText(dataModel.getDetail());
        holder.deadline.setText("Batas Pengumpulan Tugas "+dataModel.getDeadline());
        holder.diupload.setText("Tugas Di Upload "+dataModel.getDiupload());
        holder.gurupengampu.setText("Tertanda "+dataModel.getGurupengampu());
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class HolderDataTugas extends RecyclerView.ViewHolder implements View.OnClickListener{

            @BindView(R.id.tv_judultugas) TextView judul;
            @BindView(R.id.tv_kettugas) TextView detail;
            @BindView(R.id.tv_tenggatwaktutugas) TextView deadline;
            @BindView(R.id.tv_tanggalupload) TextView diupload;
            @BindView(R.id.tv_guru) TextView gurupengampu;

            public HolderDataTugas(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                itemView.setOnClickListener(this);
            }

            public void onClick(@NonNull View ItemView){

            }
    }
}
