package com.example.no_disturbance;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class allEventAdapter extends RecyclerView.Adapter<allEventAdapter.myViewHolder> {
    ArrayList<EventDetails> data;
    Context context;


    public allEventAdapter(ArrayList<EventDetails> data,Context context) {
        this.data=data;this.context=context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.each_event,viewGroup,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder myViewHolder, int i) {
        EventDetails event=data.get(i);
        myViewHolder.EventName.setText(event.getEventName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        TextView EventName,fbText,instaText,callText,messageText,whatsappText;
        ImageView fbImage,instaImage,callImage,messageImage,whatsappImage;
        Switch fbSwitch,instaSwitch,callSwitch,messageSwitch,whatsappSwitch;
        CardView fbCard,instaCard,callCard,messageCard,whatsappCard;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            EventName=itemView.findViewById(R.id.eventName);
            fbText=itemView.findViewById(R.id.fbText);
            fbImage=itemView.findViewById(R.id.fbImage);
            fbSwitch=itemView.findViewById(R.id.fbSwitch);
            fbCard=itemView.findViewById(R.id.fbCard);

            instaText=itemView.findViewById(R.id.instaText);
            instaImage=itemView.findViewById(R.id.instaImage);
            instaSwitch=itemView.findViewById(R.id.instaSwitch);
            instaCard=itemView.findViewById(R.id.instaCard);


            callText=itemView.findViewById(R.id.callText);
            callImage=itemView.findViewById(R.id.callImage);
            callSwitch=itemView.findViewById(R.id.callSwitch);
            callCard=itemView.findViewById(R.id.callCard);

            messageText=itemView.findViewById(R.id.messageText);
            messageImage=itemView.findViewById(R.id.messageImage);
            messageSwitch=itemView.findViewById(R.id.messageSwitch);
            messageCard=itemView.findViewById(R.id.messageCard);

            whatsappText=itemView.findViewById(R.id.whatsappText);
            whatsappImage=itemView.findViewById(R.id.whatsappImage);
            whatsappSwitch=itemView.findViewById(R.id.whatsappSwitch);
            whatsappCard=itemView.findViewById(R.id.whatsappCard);

            fbCard.setOnClickListener(this);
            instaCard.setOnClickListener(this);
            callCard.setOnClickListener(this);
            messageCard.setOnClickListener(this);
            whatsappCard.setOnClickListener(this);

            fbSwitch.setOnClickListener(this);
            instaSwitch.setOnClickListener(this);
            callSwitch.setOnClickListener(this);
            messageSwitch.setOnClickListener(this);
            whatsappSwitch.setOnClickListener(this);




        }

        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.fbCard:
                {

                }
                case R.id.instaCard:
                {

                }
                case R.id.callCard:
                {

                }
                case R.id.messageCard:
                {

                }
                case R.id.whatsappCard:
                {

                }
                case R.id.fbSwitch:
                {

                }
                case R.id.instaSwitch:
                {

                }
                case R.id.callSwitch:
                {

                }
                case R.id.messageSwitch:
                {

                }
                case R.id.whatsappSwitch:
                {

                }
            }
        }
    }
    public interface onSwitchChangeListener
    {
        public void onFbSwitchChange();
        public void onInstaSwitchChange();
        public void onCallSwitchChange();
        public void onMessageSwitchChange();
        public void onWhatsappSwitchChange();

    }
}
