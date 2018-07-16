package com.apptest.accenture.accentureinterview.model;

public class ModelMoreInfo {

    private ModelMonth month;
    private ModelYear year;
    private ModelTwelveMonths twelveMonths;

    public ModelMoreInfo(ModelMonth month, ModelYear year, ModelTwelveMonths twelveMonths){

        this. month = month;
        this.year = year;
        this.twelveMonths = twelveMonths;
    }

    public ModelMonth getMonth() {
        return month;
    }

    public void setMonth(ModelMonth month) {
        this.month = month;
    }

    public ModelYear getYear() {
        return year;
    }

    public void setYear(ModelYear year) {
        this.year = year;
    }

    public ModelTwelveMonths getTwelveMonths() {
        return twelveMonths;
    }

    public void setTwelveMonths(ModelTwelveMonths twelveMonths) {
        this.twelveMonths = twelveMonths;
    }
}