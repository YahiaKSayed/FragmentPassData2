package com.example.myapplication;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {
private FragmentAListener listener;
    private Button bt1;
    private EditText tv1;
    public Fragment1() {
        // Required empty public constructor
    }
    public interface FragmentAListener{
        void onInputASent(CharSequence input);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        bt1=view.findViewById(R.id.buttonfr1);
        tv1=view.findViewById(R.id.textViewfr1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            CharSequence input=tv1.getText();
            listener.onInputASent(input);
            }
        });
        return view;
    }
    public void updateTextview(CharSequence newText){
        tv1.setText(newText);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentAListener){
            listener=(FragmentAListener)context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
}

