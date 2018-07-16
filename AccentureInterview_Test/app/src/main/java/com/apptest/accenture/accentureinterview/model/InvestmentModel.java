package com.apptest.accenture.accentureinterview.model;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by fcost on 26/06/2018.;
 */

public class InvestmentModel {

    private String title;
    private String fundName;
    private String whatIs;
    private String definition;
    private String riskTitle;
    private String risk;
    private String infoTitle;
    private String fundMonth;
    private String fundYear;
    private String cdiMonth;
    private String cdiYear;
    private String fundMonthyear;
    private String cdiMonthyear;
    private String infoValue1;
    private String infoValue1Name;
    private String infoValue2;
    private String infoValue2Name;
    private String infoValue3;
    private String infoValue3Name;
    private String infoValue4;
    private String infoValue4Name;
    private String infoValue5;
    private String infoValue5Name;
    private String infoValue6;
    private String infoValue6Name;
    private String infoValue7;
    private String infoValue7Name;
    private String downInfoValue1;
    private String downInfoValue1Name;
    private String downInfoValue2;
    private String downInfoValue2Name;
    private String downInfoValue3;
    private String downInfoValue3Name;
    private String downInfoValue4;
    private String downInfoValue4Name;
    private String downInfoValue5;
    private String downInfoValue5Name;

    public InvestmentModel(String jsonData) throws JSONException {

        jsonData = jsonData.substring(4, jsonData.length());

        JSONObject jsonObject = new JSONObject(jsonData).getJSONObject("screen");
        JSONObject jsonObjectMoreInfo = new JSONObject(jsonData).getJSONObject("screen").getJSONObject("moreInfo");
        JSONArray jsonInfoArray = jsonObject.getJSONArray("info");
        JSONArray jsonDownInfoArray = jsonObject.getJSONArray("downInfo");

        this.title = jsonObject.get("title").toString();
        this.fundName = jsonObject.get("fundName").toString();
        this.whatIs = jsonObject.get("whatIs").toString();
        this.definition = jsonObject.get("definition").toString();
        this.riskTitle = jsonObject.get("riskTitle").toString();
        this.risk = jsonObject.get("risk").toString();
        this.infoTitle = jsonObject.get("infoTitle").toString();
        this.cdiMonth = jsonObjectMoreInfo.getJSONObject("month").get("CDI").toString();
        this.fundMonth = jsonObjectMoreInfo.getJSONObject("month").get("fund").toString();
        this.cdiYear = jsonObjectMoreInfo.getJSONObject("year").get("CDI").toString();
        this.fundYear = jsonObjectMoreInfo.getJSONObject("year").get("fund").toString();
        this.cdiMonthyear = jsonObjectMoreInfo.getJSONObject("12months").get("CDI").toString();
        this.fundMonthyear = jsonObjectMoreInfo.getJSONObject("12months").get("fund").toString();

        int count = jsonInfoArray.length();

        for (int i = 0; i <= count; i++) {

            if (i <= (jsonInfoArray.length() - 1)) {

                JSONObject obj = jsonInfoArray.getJSONObject(i);

                if ((i + 1) == 1) {

                    this.infoValue1 = obj.getString("data");
                    this.infoValue1Name = obj.getString("name");
                }
                if ((i + 1) == 2) {

                    this.infoValue2 = obj.getString("data");
                    this.infoValue2Name = obj.getString("name");
                }
                if ((i + 1) == 3) {

                    this.infoValue3 = obj.getString("data");
                    this.infoValue3Name = obj.getString("name");
                }

                if ((i + 1) == 4) {

                    this.infoValue4 = obj.getString("data");
                    this.infoValue4Name = obj.getString("name");
                }
                if ((i + 1) == 5) {

                    this.infoValue5 = obj.getString("data");
                    this.infoValue5Name = obj.getString("name");
                }
                if ((i + 1) == 6) {

                    this.infoValue6 = obj.getString("data");
                    this.infoValue6Name = obj.getString("name");
                }
                if ((i + 1) == 7) {

                    this.infoValue7 = obj.getString("data");
                    this.infoValue7Name = obj.getString("name");
                }
            }
        }

        count = jsonDownInfoArray.length();

        for (int i = 0; i <= count; i++) {

            if (i < (jsonDownInfoArray.length() - 1)) {

                JSONObject obj = jsonDownInfoArray.getJSONObject(i);

                if ((i + 1) == 1) {

                    this.downInfoValue1 = obj.getString("data");
                    this.downInfoValue1Name = obj.getString("name");
                }
                if ((i + 1) == 2) {

                    this.downInfoValue2 = obj.getString("data");
                    this.downInfoValue2Name = obj.getString("name");
                }
                if ((i + 1) == 3) {

                    this.downInfoValue3 = obj.getString("data");
                    this.downInfoValue3Name = obj.getString("name");
                }

                if ((i + 1) == 4) {

                    this.downInfoValue4 = obj.getString("data");
                    this.downInfoValue4Name = obj.getString("name");
                }
                if ((i + 1) == 5) {

                    this.downInfoValue5 = obj.getString("data");
                    this.downInfoValue5Name = obj.getString("name");
                }
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public String getFundName() {
        return fundName;
    }

    public String getWhatIs() {
        return whatIs;
    }

    public String getDefinition() {
        return definition;
    }

    public String getRiskTitle() {
        return riskTitle;
    }

    public String getRisk() {
        return risk;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public String getFundMonth() {
        return fundMonth;
    }

    public String getFundYear() {
        return fundYear;
    }

    public String getCdiMonth() {
        return cdiMonth;
    }

    public String getCdiYear() {
        return cdiYear;
    }

    public String getFundMonthyear() {
        return fundMonthyear;
    }

    public String getCdiMonthyear() {
        return cdiMonthyear;
    }

    public String getInfoValue1() {
        return infoValue1;
    }

    public String getInfoValue1Name() {
        return infoValue1Name;
    }

    public String getInfoValue2() {
        return infoValue2;
    }

    public String getInfoValue2Name() {
        return infoValue2Name;
    }

    public String getInfoValue3() {
        return infoValue3;
    }

    public String getInfoValue3Name() {
        return infoValue3Name;
    }

    public String getInfoValue4() {
        return infoValue4;
    }

    public String getInfoValue4Name() {
        return infoValue4Name;
    }

    public String getInfoValue5() {
        return infoValue5;
    }

    public String getInfoValue5Name() {
        return infoValue5Name;
    }

    public String getInfoValue6() {
        return infoValue6;
    }

    public String getInfoValue6Name() {
        return infoValue6Name;
    }

    public String getInfoValue7() {
        return infoValue7;
    }

    public String getInfoValue7Name() {
        return infoValue7Name;
    }

    public String getDownInfoValue1() {
        return downInfoValue1;
    }

    public String getDownInfoValue1Name() {
        return downInfoValue1Name;
    }

    public String getDownInfoValue2() {
        return downInfoValue2;
    }

    public String getDownInfoValue2Name() {
        return downInfoValue2Name;
    }

    public String getDownInfoValue3() {
        return downInfoValue3;
    }

    public String getDownInfoValue3Name() {
        return downInfoValue3Name;
    }

    public String getDownInfoValue4() {
        return downInfoValue4;
    }

    public String getDownInfoValue4Name() {
        return downInfoValue4Name;
    }

    public String getDownInfoValue5() {
        return downInfoValue5;
    }

    public String getDownInfoValue5Name() {
        return downInfoValue5Name;
    }
}
