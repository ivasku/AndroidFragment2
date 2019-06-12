package com.tms.androidfragments2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment_1.OnFragmentInteractionListener, Fragment_2.OnFragmentInteractionListener{

    private Fragment_1 frag_1;
    private Fragment_2 frag_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag_1 = new Fragment_1();
        frag_2 = new Fragment_2();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout1, frag_1)
                .replace(R.id.frameLayout2, frag_2)
                .commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //don`t use this for now
    }

    @Override
    public void onInputFragment_1_sent(CharSequence input) {
        //update fragment1 with data from fragment2
        frag_2.updateEditText(input);

        //we can send data via factory method, onNewInstance, but for this example I used a public method
    }

    @Override
    public void onInputFragment_2_sent(CharSequence input) {
        //update fragment2 with data from fragment1
        frag_1.updateEditText(input);
    }
}
