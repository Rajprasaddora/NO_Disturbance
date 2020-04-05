package com.example.no_disturbance;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class New_Event extends Fragment implements View.OnClickListener {

    public New_Event() {
        // Required empty public constructor
    }

    TextInputEditText textInputEditText;
    Button btn;
    OnEventCreatedListener context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new__event, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=(OnEventCreatedListener)context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        textInputEditText=view.findViewById(R.id.eventName);
        btn=view.findViewById(R.id.create_event);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.create_event)
        {
            String eventName=textInputEditText.getText().toString();
            if(!eventName.equals("")) {
                //Log.d("raj", eventName);
                context.OnEventCreate(eventName);
            }


        }
    }

}
