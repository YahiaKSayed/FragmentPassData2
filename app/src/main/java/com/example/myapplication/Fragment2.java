package com.example.myapplication;


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
public class Fragment2 extends Fragment {

    private FragmentBListener listener;
    private Button bt2;
    private EditText tv2;
    public Fragment2() {
        // Required empty public constructor
    }
    public interface FragmentBListener{
        void onInputBSent(CharSequence input);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        bt2=view.findViewById(R.id.buttonfr2);
        tv2=view.findViewById(R.id.textViewfr2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input=tv2.getText();
                listener.onInputBSent(input);
            }
        });
        return view;
    }
    public void updateTextview(CharSequence newText){
        tv2.setText(newText);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentBListener){
            listener=(FragmentBListener)context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
}

