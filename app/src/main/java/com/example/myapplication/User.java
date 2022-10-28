package com.example.myapplication;

public class User {
    private String soru;
    private String a;
    private String b;
    private String c;
    private String d;
    private String cevap;

    public User(String soru, String a, String b, String c, String d, String cevap) {

        this.soru = soru;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.cevap = cevap;
    }

    public User(){

    }

    public String getSoru() {
        return soru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }
}
