package com.example.customised_t_shirts_app;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.customised_t_shirts_app.Adapter.ColorAdapter;
import com.example.customised_t_shirts_app.Interface.AddTextFragmentListener;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddTextFragment extends BottomSheetDialogFragment implements ColorAdapter.ColorAdapterListener {

    int colorSelected = Color.parseColor("#000000");//default color text is black

    AddTextFragmentListener listener;

    EditText edt_add_text;
    RecyclerView recycler_color;
    Button btn_done;

    public void setListener(AddTextFragmentListener listener) {
        this.listener = listener;
    }

    static AddTextFragment instance;

    public static AddTextFragment getInstance(){
        if(instance==null)
            instance=new AddTextFragment();

            return instance;
    }




    public AddTextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_add_text, container, false);
        edt_add_text=(EditText)itemView.findViewById(R.id.edit_add_text);
        btn_done=(Button) itemView.findViewById(R.id.btn_done);
        recycler_color=(RecyclerView) itemView.findViewById(R.id.recycler_color);
        recycler_color.setHasFixedSize(true);
        recycler_color.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        ColorAdapter colorAdapter=new ColorAdapter(getContext(),this);
        recycler_color.setAdapter(colorAdapter);

        //event
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onAddTextButtonClick(edt_add_text.getText().toString(),colorSelected);
            }
        });

        return itemView;
    }

    @Override
    public void onColorSelected(int color) {
        colorSelected=color;//set color when user select
    }
}
