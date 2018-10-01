package com.example.gogos.testtask;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DataRvAdapter extends RecyclerView.Adapter<DataRvAdapter.myDataViewHolder> {

    private Context context;
    private List<data> dataList;

    public DataRvAdapter(Context context, List<data> list) {
        this.context = context;
        this.dataList = list;
    }

    public void setDataList(List<data> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }


    @Override
    public myDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R
                .layout.activity_rv__adapter, parent, false);
        return new myDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(myDataViewHolder holder, int position) {
        holder.userId.setText("User ID:  " + Integer.toString(dataList.get(position).getUserId()));
        holder.tittle.setText("Tittle:  " + dataList.get(position).getTittle());
        holder.body.setText("Body:  " + dataList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        if (dataList != null) {
            return dataList.size();
        }
        return 0;
    }

    public class myDataViewHolder extends RecyclerView.ViewHolder {
        TextView userId;
        TextView tittle;
        TextView body;

        public myDataViewHolder(final View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.user_id_text_view);
            tittle = itemView.findViewById(R.id.tittle_text_view);
            body = itemView.findViewById(R.id.body_text_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Snackbar.make(view, "Item clicked:  " + position + "  Item id form API  " +
                            dataList.get(position).getId(), Snackbar.LENGTH_LONG).show();
                }
            });
        }

    }
}
