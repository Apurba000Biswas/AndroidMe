package com.daktardekhao.androidme.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.daktardekhao.androidme.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BodyPartFragment extends Fragment {
    private static String IMAGE_LIST = "img_list";
    private static String IMAGE_INDEX = "img_index";

    private static String LOG_TAG = "BodyPartFragment";

    private List<Integer> listOfImage;
    private int index;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null){
            listOfImage = savedInstanceState.getIntegerArrayList(IMAGE_LIST);
            index = savedInstanceState.getInt(IMAGE_INDEX);
        }

        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        final ImageView imageView = rootView.findViewById(R.id.body_part_image_view);

        if (listOfImage != null){
            imageView.setImageResource(listOfImage.get(index));
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index < listOfImage.size()-1){
                    index++;
                }else{
                    index = 0;
                }
                imageView.setImageResource(listOfImage.get(index));
            }
        });

        return rootView;
    }

    void setListOfImage(List<Integer> listOfImage){
        this.listOfImage = listOfImage;
    }

    void setIndex(int index){
        this.index = index;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putIntegerArrayList(IMAGE_LIST, (ArrayList<Integer>) listOfImage);
        outState.putInt(IMAGE_INDEX, index);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStop() {
        Log.d(LOG_TAG, "onStop()");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(LOG_TAG, "onDestroyView()");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(LOG_TAG, "onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(LOG_TAG, "onDetach()");
        super.onDetach();
    }
}
