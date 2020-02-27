
package com.daktardekhao.androidme.ui;

import android.os.Bundle;

import com.daktardekhao.androidme.R;
import com.daktardekhao.androidme.data.AndroidImageAssets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        BodyPartFragment headFragment = new BodyPartFragment();
        headFragment.setListOfImage(AndroidImageAssets.getHeads());
        //headFragment.setIndex(1);

        BodyPartFragment bodyFragment = new BodyPartFragment();
        bodyFragment.setListOfImage(AndroidImageAssets.getBodies());
        //bodyFragment.setIndex(1);

        BodyPartFragment legFragment = new BodyPartFragment();
        legFragment.setListOfImage(AndroidImageAssets.getLegs());
        //legFragment.setIndex(1);

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.head_container, headFragment)
                .commit();

        fragmentManager.beginTransaction()
                .add(R.id.body_container, bodyFragment)
                .commit();

        fragmentManager.beginTransaction()
                .add(R.id.leg_container, legFragment)
                .commit();
    }
}
