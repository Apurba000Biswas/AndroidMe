package com.daktardekhao.androidme.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.daktardekhao.androidme.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BodyPartFragment extends Fragment {

    private List<Integer> listOfImage;
    private int index;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
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
}
