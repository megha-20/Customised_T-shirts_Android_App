package com.example.customised_t_shirts_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customised_t_shirts_app.Cart;
import com.example.customised_t_shirts_app.Product;
import com.example.customised_t_shirts_app.R;
import com.example.customised_t_shirts_app.Tshirt;
import com.example.customised_t_shirts_app.TshirtCartDetails;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {

    private Context mContext;
    private List<Product> mData;

    public CartAdapter(Context mContext, List<Product> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.activity_tshirt_cart_details, parent, false);
        return new CartAdapter.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.tv_p1_title.setText(mData.get(position).getTitle());
        holder.img_p1_thumbnail.setImageResource(mData.get(position).getThumbnail());

        holder.pd_add_to_cart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(mContext, Cart.class);
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

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_p1_title;
        ImageView img_p1_thumbnail;
        ImageButton pd_add_to_cart_button;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_p1_title = (TextView) itemView.findViewById(R.id.txttitle);
            img_p1_thumbnail = (ImageView) itemView.findViewById(R.id.shirtthumbnail);
            pd_add_to_cart_button= (ImageButton) itemView.findViewById(R.id.pd_add_to_cart_button);

        }
    }
}
