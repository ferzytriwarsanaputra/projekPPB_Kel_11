package com.example.projek;

public class AntonimModel {
    String key,kata,antonim;

    public AntonimModel() {
        // dibutuhkan oleh Firebase
    }

    public AntonimModel(String key, String kata, String antonim) {
        this.key = key;
        this.kata = kata;
        this.antonim = antonim;
    }

    public void setKey(String key){
        this.key = key;
    }

    public String getkey() {
        return key;
    }

    public String getKata() { return kata; }

    public String getAntonim() {
        return antonim;
    }
}
