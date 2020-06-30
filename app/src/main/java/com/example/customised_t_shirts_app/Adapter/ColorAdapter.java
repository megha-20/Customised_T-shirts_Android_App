package com.example.customised_t_shirts_app.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customised_t_shirts_app.R;

import java.util.ArrayList;
import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewHolder>{

    Context context;
    List<Integer> colorList;
    ColorAdapterListener listener;

    public ColorAdapter(Context context, ColorAdapterListener listener) {
        this.context=context;
        this.colorList=genColorList();
        this.listener=listener;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.color_item,parent,false);
        return new ColorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        holder.color_section.setCardBackgroundColor(colorList.get(position));
       // holder.imageButton5.setBackgroundColor(colorList.get(position));
    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }


    public class ColorViewHolder extends RecyclerView.ViewHolder{

        public CardView color_section;

        //public ImageButton imageButton5;

        public ColorViewHolder(@NonNull View itemView) {
            super(itemView);

            //imageButton5=(ImageButton)itemView.findViewById(R.id.imageButton5);

            color_section=(CardView)itemView.findViewById(R.id.color_section);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onColorSelected(colorList.get(getAdapterPosition()));
                }
            });
        }
    }

    private List<Integer> genColorList() {
        List<Integer> colorList=new ArrayList<>();

        colorList.add(Color.parseColor("#f44336"));
        colorList.add(Color.parseColor("#ffcdd2"));
        colorList.add(Color.parseColor("#ef9a9a"));
        colorList.add(Color.parseColor("#e57373"));
        colorList.add(Color.parseColor("#ef5350"));
        colorList.add(Color.parseColor("#f44336"));

        colorList.add(Color.parseColor("#E91E63"));
        colorList.add(Color.parseColor("#F8BBD0"));
        colorList.add(Color.parseColor("#F48FB1"));
        colorList.add(Color.parseColor("#F06292"));
        colorList.add(Color.parseColor("#EC407A"));
        colorList.add(Color.parseColor("#E91E63"));

        colorList.add(Color.parseColor("#9C27B0"));
        colorList.add(Color.parseColor("#E1BEE7"));
        colorList.add(Color.parseColor("#CE93D8"));
        colorList.add(Color.parseColor("#BA68C8"));
        colorList.add(Color.parseColor("#AB47BC"));
        colorList.add(Color.parseColor("#9C27B0"));

        colorList.add(Color.parseColor("#673AB7"));
        colorList.add(Color.parseColor("#D1C4E9"));
        colorList.add(Color.parseColor("#B39DDB"));
        colorList.add(Color.parseColor("#9575CD"));
        colorList.add(Color.parseColor("#7E57C2"));
        colorList.add(Color.parseColor("#673AB7"));

        colorList.add(Color.parseColor("#3F51B5"));
        colorList.add(Color.parseColor("#C5CAE9"));
        colorList.add(Color.parseColor("#9FA8DA"));
        colorList.add(Color.parseColor("#7986CB"));
        colorList.add(Color.parseColor("#5C6BC0"));
        colorList.add(Color.parseColor("#3F51B5"));

        colorList.add(Color.parseColor("#2196F3"));
        colorList.add(Color.parseColor("#BBDEFB"));
        colorList.add(Color.parseColor("#90CAF9"));
        colorList.add(Color.parseColor("#64B5F6"));
        colorList.add(Color.parseColor("#42A5F5"));
        colorList.add(Color.parseColor("#2196F3"));

        colorList.add(Color.parseColor("#4CAF50"));
        colorList.add(Color.parseColor("#C8E6C9"));
        colorList.add(Color.parseColor("#A5D6A7"));
        colorList.add(Color.parseColor("#81C784"));
        colorList.add(Color.parseColor("#66BB6A"));
        colorList.add(Color.parseColor("#4CAF50"));

        colorList.add(Color.parseColor("#FFEB3B"));
        colorList.add(Color.parseColor("#FFF9C4"));
        colorList.add(Color.parseColor("#FFF59D"));
        colorList.add(Color.parseColor("#FFF176"));
        colorList.add(Color.parseColor("#FFEE58"));
        colorList.add(Color.parseColor("#FFEB3B"));

        colorList.add(Color.parseColor("#FF5722"));
        colorList.add(Color.parseColor("#FFCCBC"));
        colorList.add(Color.parseColor("#FFAB91"));
        colorList.add(Color.parseColor("#FF8A65"));
        colorList.add(Color.parseColor("#FF7043"));
        colorList.add(Color.parseColor("#FF5722"));

        colorList.add(Color.parseColor("#795548"));
        colorList.add(Color.parseColor("#D7CCC8"));
        colorList.add(Color.parseColor("#BCAAA4"));
        colorList.add(Color.parseColor("#A1887F"));
        colorList.add(Color.parseColor("#8D6E63"));
        colorList.add(Color.parseColor("#795548"));

        colorList.add(Color.parseColor("#9E9E9E"));
        colorList.add(Color.parseColor("#FAFAFA"));
        colorList.add(Color.parseColor("#EEEEEE"));
        colorList.add(Color.parseColor("#E0E0E0"));
        colorList.add(Color.parseColor("#BDBDBD"));
        colorList.add(Color.parseColor("#9E9E9E"));

        colorList.add(Color.parseColor("#607D8B"));
        colorList.add(Color.parseColor("#CFD8DC"));
        colorList.add(Color.parseColor("#90A4AE"));
        colorList.add(Color.parseColor("#78909C"));
        colorList.add(Color.parseColor("#607D8B"));
        colorList.add(Color.parseColor("#546E7A"));

        return colorList;
    }

    public interface ColorAdapterListener{
        void onColorSelected(int color);
    }
}
