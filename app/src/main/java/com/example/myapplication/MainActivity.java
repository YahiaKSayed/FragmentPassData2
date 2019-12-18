package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment2.FragmentBListener,Fragment1.FragmentAListener {
private Fragment1 fragment1;
private Fragment2 fragment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1=new Fragment1();
        fragment2=new Fragment2();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.cont1,fragment1)
                 .replace(R.id.cont2,fragment2)
                .commit();
    }

    @Override
    public void onInputASent(CharSequence input) {
        fragment2.updateTextview(input);
    }

    @Override
    public void onInputBSent(CharSequence input) {
fragment1.updateTextview(input);
    }
}
