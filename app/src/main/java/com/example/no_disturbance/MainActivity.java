package com.example.no_disturbance;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,OnEventCreatedListener {


    SharedPreferences sh_pref;

    public static final String sh_pref_name = "all_events";
    FloatingActionButton add_fab;
    JSONObject json_obj;
    ArrayList<EventDetails> dataArr;


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    allEventAdapter adapter;

    FragmentManager frag_manager;
    FragmentTransaction frag_transction;

    boolean frag_open;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_fab=findViewById(R.id.add_fab);



        frag_manager=getSupportFragmentManager();
        frag_open=false;

        sh_pref = getSharedPreferences(sh_pref_name, MODE_PRIVATE);
        loaddata();

        recyclerView=findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,true);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new allEventAdapter(dataArr,this);
        recyclerView.setAdapter(adapter);

        add_fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.add_fab:
            {

                if(frag_open==false){
                    Fragment fragment=new New_Event();
                    frag_transction=frag_manager.beginTransaction();
                    frag_transction.add(R.id.idFramelayout,fragment);
                    frag_transction.addToBackStack("new_event_added");
                    //Log.d("Main_Activity","open_farg");
                    frag_transction.commit();

                    frag_open=true;

                }
                else{
                    frag_transction=frag_manager.beginTransaction();
                    frag_manager.popBackStack();
                    frag_transction.commit();
                   // Log.d("Main_Activity","close_frag");
                    frag_open=false;

                }

            }
        }

    }
    public void loaddata()
    {
        String data=sh_pref.getString("event_data",null);
        Type type=new TypeToken< ArrayList<EventDetails>>(){}.getType();
        Gson json=new Gson();
        dataArr=json.fromJson(data,type);
        if(dataArr==null) {
            dataArr = new ArrayList<EventDetails>();
        }
    }

    @Override
    public void OnEventCreate(String eventName) {
        EventDetails newEvent=new EventDetails();
            newEvent.setEventName(eventName);
            dataArr.add(newEvent);
            recyclerView.scrollToPosition(dataArr.size()-1);
            adapter.notifyDataSetChanged();
            View view=getCurrentFocus();
            if(view!=null)
            {
                frag_transction=frag_manager.beginTransaction();
                frag_manager.popBackStack();
                frag_transction.commit();
                // Log.d("Main_Activity","close_frag");
                frag_open=false;
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

    }

}
