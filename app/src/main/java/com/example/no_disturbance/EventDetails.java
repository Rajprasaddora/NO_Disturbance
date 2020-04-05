package com.example.no_disturbance;

public class EventDetails {
    private String reply;
    private String EventName;
    private Boolean fb;

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    private Boolean insta;
    private Boolean whatsapp;
    private Boolean phone;
    private Boolean message;


    public EventDetails() {
        reply="hey! i am in "+EventName+" ...";
        EventName="Meeting ";
        fb=false;
        insta=false;
        whatsapp=false;
        phone=false;
        message=false;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Boolean getFb() {
        return fb;
    }

    public void setFb(Boolean fb) {
        this.fb = fb;
    }

    public Boolean getInsta() {
        return insta;
    }

    public void setInsta(Boolean insta) {
        this.insta = insta;
    }

    public Boolean getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(Boolean whatsapp) {
        this.whatsapp = whatsapp;
    }

    public Boolean getPhone() {
        return phone;
    }

    public void setPhone(Boolean phone) {
        this.phone = phone;
    }

    public Boolean getMessage() {
        return message;
    }

    public void setMessage(Boolean message) {
        this.message = message;
    }
}
