package com.apptest.accenture.accentureinterview.model;

public class ModelMonth {

    private String fund;
    private String CDI;

    public ModelMonth(String fund, String cdi){
        this.fund = fund;
        this.CDI = cdi;
    }

    public String getFund() {
        return fund;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    public String getCdi() {
        return CDI;
    }

    public void setCdi(String cdi) {
        this.CDI = cdi;
    }
}
