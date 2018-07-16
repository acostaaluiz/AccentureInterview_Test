package com.apptest.accenture.accentureinterview.model;

public class ModelScreen {

    private String title;
    private String fundName;
    private String whatIs;
    private String definition;
    private String riskTitle;
    private String risk;
    private String infoTitle;

    public ModelScreen(String title, String fundName, String whatIs, String definition, String riskTitle, String risk){

        this.title = title;
        this.fundName = fundName;
        this.whatIs = whatIs;
        this.definition = definition;
        this.riskTitle = riskTitle;
        this.risk = risk;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getWhatIs() {
        return whatIs;
    }

    public void setWhatIs(String whatIs) {
        this.whatIs = whatIs;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getRiskTitle() {
        return riskTitle;
    }

    public void setRiskTitle(String riskTitle) {
        this.riskTitle = riskTitle;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }
}
