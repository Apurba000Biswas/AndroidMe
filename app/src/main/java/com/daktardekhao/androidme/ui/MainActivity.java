package com.daktardekhao.androidme.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.daktardekhao.androidme.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.MasterListClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onGridItemClicked(int position) {
        Toast.makeText(this, "clicked on " + position, Toast.LENGTH_SHORT).show();
    }
}
