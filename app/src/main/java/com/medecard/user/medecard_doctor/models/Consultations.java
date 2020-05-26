package com.medecard.user.medecard_doctor.models;

public class Consultations {

    private String date;
    private String hosp_location;
    private String doctor_name;
    private String cons_type;
    private String cons_status;

    public Consultations() {
    }

    public Consultations(String date, String hosp_location, String doctor_name, String cons_type, String cons_status) {
        this.date = date;
        this.hosp_location = hosp_location;
        this.doctor_name = doctor_name;
        this.cons_type = cons_type;
        this.cons_status = cons_status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHosp_location() {
        return hosp_location;
    }

    public void setHosp_location(String hosp_location) {
        this.hosp_location = hosp_location;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getCons_type() {
        return cons_type;
    }

    public void setCons_type(String cons_type) {
        this.cons_type = cons_type;
    }

    public String getCons_status() {
        return cons_status;
    }

    public void setCons_status(String cons_status) {
        this.cons_status = cons_status;
    }
}
