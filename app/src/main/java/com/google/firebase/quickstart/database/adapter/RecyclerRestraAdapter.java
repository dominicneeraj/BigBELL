package com.google.firebase.quickstart.database.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.firebase.quickstart.database.R;
import com.google.firebase.quickstart.database.interfaces.ItemClickListener;
import com.google.firebase.quickstart.database.models.Restra;

import java.util.List;


public class RecyclerRestraAdapter extends RecyclerView.Adapter<RecyclerRestraAdapter.MyViewHolder> {

    private List<Restra> restras;
    private Context mContext;
    private ItemClickListener clickListener;


    public RecyclerRestraAdapter(Context context, List<Restra> restras) {
        mContext = context;
        this.restras = restras;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.restralist_layout_adapter, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Restra restra = restras.get(position);
        holder.name.setText(restra.getRestra_name());
        Glide.with(mContext).load(restra.getImage())
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.restra_image);

    }



    @Override
    public int getItemCount() {
        return restras.size();
    }




    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView restra_image;
        public TextView name;
        public TextView city_name;
       public int id;

        public MyViewHolder(View view) {
            super(view);
city_name=(TextView) view.findViewById(R.id.city_name);
            restra_image= (ImageView) view.findViewById(R.id.restra_image);
            name = (TextView) view.findViewById(R.id.name);

            view.setTag(view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }












}