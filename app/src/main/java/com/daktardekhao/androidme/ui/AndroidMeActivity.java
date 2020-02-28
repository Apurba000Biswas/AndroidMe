
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

        if (savedInstanceState == null){
            BodyPartFragment headFragment = new BodyPartFragment();
            headFragment.setListOfImage(AndroidImageAssets.getHeads());

            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setListOfImage(AndroidImageAssets.getBodies());

            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setListOfImage(AndroidImageAssets.getLegs());

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
}
