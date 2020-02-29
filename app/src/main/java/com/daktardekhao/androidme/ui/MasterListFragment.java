package com.daktardekhao.androidme.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.daktardekhao.androidme.R;
import com.daktardekhao.androidme.data.AndroidImageAssets;

public class MasterListFragment extends Fragment {

    private MasterListClickListener callBack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);
        GridView masterListGrid = rootView.findViewById(R.id.grid_master_list);
        MasterListAdapter adapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        masterListGrid.setAdapter(adapter);

        masterListGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                callBack.onGridItemClicked(position);
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            callBack = (MasterListClickListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(e.getMessage() + " Must implement Click Listener");
        }
    }

    public interface MasterListClickListener{
        void onGridItemClicked(int position);
    }
}
