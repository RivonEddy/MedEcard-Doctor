package com.medecard.user.medecard_doctor.models;

public class Patient {

    private int pt_img;
    private String pt_name;
    private String pt_addrs;

    public Patient() {
    }

    public Patient(int pt_img, String pt_name, String pt_addrs) {
        this.pt_img = pt_img;
        this.pt_name = pt_name;
        this.pt_addrs = pt_addrs;
    }

    public int getPt_img() {
        return pt_img;
    }

    public void setPt_img(int pt_img) {
        this.pt_img = pt_img;
    }

    public String getPt_name() {
        return pt_name;
    }

    public void setPt_name(String pt_name) {
        this.pt_name = pt_name;
    }

    public String getPt_addrs() {
        return pt_addrs;
    }

    public void setPt_addrs(String pt_addrs) {
        this.pt_addrs = pt_addrs;
    }
}
