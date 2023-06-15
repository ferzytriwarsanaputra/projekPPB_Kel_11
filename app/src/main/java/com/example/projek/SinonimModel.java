package com.example.projek;

public class SinonimModel {
    String key,kata,sinonim;

    public SinonimModel() {
        // dibutuhkan oleh Firebase
    }

    public SinonimModel(String key, String kata, String sinonim) {
        this.key = key;
        this.kata = kata;
        this.sinonim = sinonim;
    }

    public void setKey(String key){
        this.key = key;
    }

    public String getkey() {
        return key;
    }
    public String getKata() { return kata; }

    public String getSinonim() {
        return sinonim;
    }
}
