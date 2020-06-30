package com.example.customised_t_shirts_app;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.customised_t_shirts_app.Adapter.EmojiAdapter;
import com.example.customised_t_shirts_app.Interface.EmojiFragmentListener;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import ja.burhanrashid52.photoeditor.PhotoEditor;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmojiFragment extends BottomSheetDialogFragment implements EmojiAdapter.EmojiAdapterListener {

    RecyclerView recyler_emoji;
    static EmojiFragment instance;

    EmojiFragmentListener listener;

    public void setListener(EmojiFragmentListener listener) {
        this.listener = listener;
    }



    public static EmojiFragment getInstance(){
        if(instance==null)
            instance=new EmojiFragment();
        return instance;
    }


    public EmojiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View itemview = inflater.inflate(R.layout.fragment_emoji, container, false);
       recyler_emoji=(RecyclerView)itemview.findViewById(R.id.recycler_emoji);
       recyler_emoji.setHasFixedSize(true);
       recyler_emoji.setLayoutManager(new GridLayoutManager(getActivity(),5));

       EmojiAdapter adapter=new EmojiAdapter(getContext(), PhotoEditor.getEmojis(getContext()),this);
       recyler_emoji.setAdapter(adapter);
       return itemview;
    }

    @Override
    public void onEmojiItemSelected(String emoji) {
        listener.onEmojiSelected(emoji);
    }
}
