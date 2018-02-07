package com.myrep.rals.tehcnicianapps.Utility;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myrep.rals.tehcnicianapps.R;
import com.myrep.rals.tehcnicianapps.model.recyleview;

import java.util.List;

/**
 * Created by Rals-PC on 10/26/2016.
 */

public class recycleviewAdapter extends RecyclerView.Adapter<recycleviewAdapter.MyViewHolder> {

    private List<recyleview> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView username, mobile,status;
        public ImageView imageView;
        public CardView cv;

        public MyViewHolder(View view) {
            super(view);
            cv = (CardView) itemView.findViewById(R.id.cv);
            username = (TextView) view.findViewById(R.id.tvName);
            mobile = (TextView) view.findViewById(R.id.tvMobile);
            status = (TextView)view.findViewById(R.id.tvstatus);
            imageView = (ImageView) view.findViewById(R.id.ivProfile);
        }
    }


    public recycleviewAdapter(List<recyleview> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycleview_adapter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        recyleview blackList = moviesList.get(position);
        holder.username.setText(blackList.userName);
        holder.mobile.setText(blackList.userMobile);
        holder.status.setText(blackList.userstatus);
        holder.imageView.setImageResource(blackList.imageResourceId);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
