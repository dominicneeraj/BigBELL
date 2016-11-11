package com.google.firebase.quickstart.database.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.quickstart.database.R;
import com.google.firebase.quickstart.database.interfaces.ItemClickListener;
import com.google.firebase.quickstart.database.models.Deal;

import java.util.List;


public class RecyclerDealsAdapter extends RecyclerView.Adapter<RecyclerDealsAdapter.MyViewHolder> {

    private List<Deal> deals;
    private Context mContext;
    private ItemClickListener clickListener;


    public RecyclerDealsAdapter(Context context, List<Deal> deals) {
        mContext = context;
        this.deals = deals;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.deal_adapter_layout, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Deal deal = deals.get(position);
        holder.name.setText(deal.getRestra_Name());
        holder.content.setText(deal.getcontent());

    }



    @Override
    public int getItemCount() {
        return deals.size();
    }




    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView content;
        public TextView name;

       public int id;

        public MyViewHolder(View view) {
            super(view);

            content = (TextView) view.findViewById(R.id.content);
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