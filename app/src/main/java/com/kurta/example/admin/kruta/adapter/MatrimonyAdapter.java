package com.kurta.example.admin.kruta.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.kurta.R;
import com.kurta.example.admin.kruta.Model.MatrimonyItem;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Krutarth on 4/22/2017.
 */

public class MatrimonyAdapter extends RecyclerView.Adapter<MatrimonyAdapter.ViewHolder> {

    public List<MatrimonyItem> MatrimonyItem;

    String TAG = "AllNewsAdapter ::";
    Context ctx;


    public MatrimonyAdapter(Context ctx, List<MatrimonyItem> feedItems)
    {
        this.MatrimonyItem = feedItems;
        this.ctx = ctx;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvFname, date, tvLname;
        TextView content;
        ImageView thumbnail;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tvFname = (TextView) itemView.findViewById(R.id.fName);
            this.tvLname = (TextView) itemView.findViewById(R.id.lName);
            this.date = (TextView) itemView.findViewById(R.id.email);
            this.content = (TextView) itemView.findViewById(R.id.notification);
            this.thumbnail = (ImageView)itemView.findViewById(R.id.thumbnail);

            this.tvFname.setTextColor(Color.WHITE);
            this.tvLname.setTextColor(Color.WHITE);
            this.date.setTextColor(Color.WHITE);
            this.content.setTextColor(Color.WHITE);

        }
    }

    @Override
    public MatrimonyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_listview, parent, false);
        MatrimonyAdapter.ViewHolder viewHolder = new MatrimonyAdapter.ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(MatrimonyAdapter.ViewHolder holder, int position) {
        holder.content.setText(MatrimonyItem.get(position).getRecords().get(position).getGender());
        holder.date.setText(MatrimonyItem.get(position).getRecords().get(position).getMaritalStatus());
        holder.tvFname.setText(MatrimonyItem.get(position).getRecords().get(position).getFname());
        holder.tvLname.setText(MatrimonyItem.get(position).getRecords().get(position).getLname());
        /*holder.title.setText(planetItems.get(position).getTitle());
        holder.date.setText(planetItems.get(position).getDate());
        holder.content.setText(planetItems.get(position).getDescription());*/
       Picasso.with(ctx).load(MatrimonyItem.get(position).getRecords().get(position).getDisplayPicture())//.replace("\\", "").replaceAll(" ", "%20")).fit()
                .placeholder(R.drawable.enter)
                .error(R.drawable.profile).into(holder.thumbnail, new Callback() {
            @Override
            public void onSuccess() {
            }
            @Override
            public void onError() {
            }
        });
    }


    @Override
    public int getItemCount() {

        return MatrimonyItem.size();
    }

    public int getCount() {
        return MatrimonyItem.size();
    }

    public com.kurta.example.admin.kruta.Model.MatrimonyItem getItem(int i) {
        return MatrimonyItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
