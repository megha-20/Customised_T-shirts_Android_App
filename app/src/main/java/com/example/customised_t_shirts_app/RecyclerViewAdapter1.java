package com.example.customised_t_shirts_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter1 extends RecyclerView.Adapter<com.example.customised_t_shirts_app.RecyclerViewAdapter1.MyViewHolder>{

    private Context mContext;
    private List<Product> mData;

    public RecyclerViewAdapter1(Context mContext, List<Product> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }






    @NonNull
    @Override
    public com.example.customised_t_shirts_app.RecyclerViewAdapter1.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview,parent,false);
        return new com.example.customised_t_shirts_app.RecyclerViewAdapter1.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.customised_t_shirts_app.RecyclerViewAdapter1.MyViewHolder holder, final int position) {

        holder.tv_p1_title.setText(mData.get(position).getTitle());
        holder.img_p1_thumbnail.setImageResource(mData.get(position).getThumbnail());





        //set click listener

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent=new Intent(mContext,Tshirt.class);
                //parsing data to shirt activity
                intent.putExtra("Title",mData.get(position).getTitle());
                intent.putExtra("Description",mData.get(position).getDescription());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                //start the activity
                mContext.startActivity(intent);



            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_p1_title;
        ImageView img_p1_thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView){
            super(itemView);

            tv_p1_title=(TextView) itemView.findViewById(R.id.p1);
            img_p1_thumbnail=(ImageView) itemView.findViewById(R.id.img1);
            cardView=(CardView)itemView.findViewById(R.id.cardview_id);



        }
    }
}

