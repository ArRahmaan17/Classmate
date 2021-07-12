package com.maaan.classmate.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.transition.platform.Hold;
import com.maaan.classmate.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maaan.classmate.Model.DataModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterJadwal extends RecyclerView.Adapter<AdapterJadwal.HolderDataJadwal> {

    private Context context;
    private List<DataModel> result;
    private int id;

    public AdapterJadwal(Context context, List<DataModel> result){
        this.context = context;
        this.result = result;
    }

    @Override
    public HolderDataJadwal onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlistjadwal, parent, false);
        HolderDataJadwal holderDataJadwal = new HolderDataJadwal(v);
        return holderDataJadwal;
    }

    @Override
    public void onBindViewHolder(HolderDataJadwal holderDataJadwal, int position) {
        DataModel dataModel = result.get(position);
        this.id = dataModel.getId();
        holderDataJadwal.jam.setText(dataModel.getJam());
        holderDataJadwal.guru.setText(dataModel.getGurupengampu());
        holderDataJadwal.pelajaran.setText(dataModel.getNama());
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class HolderDataJadwal extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.tv_gurujadwal) TextView guru;
        @BindView(R.id.tv_jam) TextView jam;
        @BindView(R.id.tv_matapelajaran) TextView pelajaran;

        public HolderDataJadwal(@NonNull View v) {
            super(v);
            ButterKnife.bind(this, v);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
