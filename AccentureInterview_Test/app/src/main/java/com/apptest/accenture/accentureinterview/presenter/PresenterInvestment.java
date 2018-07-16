package com.apptest.accenture.accentureinterview.presenter;

import android.content.Context;
import android.os.AsyncTask;

import com.apptest.accenture.accentureinterview.data.api.InvestmentAPI;
import com.apptest.accenture.accentureinterview.model.ModelDownInfo;
import com.apptest.accenture.accentureinterview.model.ModelInfo;
import com.apptest.accenture.accentureinterview.model.ModelMonth;
import com.apptest.accenture.accentureinterview.model.ModelMoreInfo;
import com.apptest.accenture.accentureinterview.model.ModelScreen;
import com.apptest.accenture.accentureinterview.model.ModelTwelveMonths;
import com.apptest.accenture.accentureinterview.model.ModelYear;
import com.apptest.accenture.accentureinterview.utility.NetworkConnectionTest;
import com.apptest.accenture.accentureinterview.view.Investment;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class PresenterInvestment implements Investment.Presenter{

    private Investment.View fragmentInvestment;
    private NetworkConnectionTest networkConnectionTest;
    private ModelScreen modelScreen;
    private ModelMonth modelMonth;
    private ModelYear modelYear;
    private ModelTwelveMonths modelTwelveMonths;
    private ModelMoreInfo modelMoreInfo;
    private ArrayList<ModelInfo> modelInfo;
    private ArrayList<ModelDownInfo> modelDownInfo;
    private InvestmentAPI investmentAPI;
    private Gson gson;
    private String apiResponse;

    public PresenterInvestment(Investment.View fragmentInvestment, Context context){

        this.fragmentInvestment = fragmentInvestment;
        this.investmentAPI = new InvestmentAPI();
    }

    @Override
    public void getInvestment(){

        InitInterface initInterface = new InitInterface();
        initInterface.execute();

    }

    private class InitInterface extends
            AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {

            fragmentInvestment.initLoadProgressBar();
            gson = new Gson();
            modelInfo = new ArrayList<>();
            modelDownInfo = new ArrayList<>();
        }

        @Override
        protected String doInBackground(String... strings) {

            try {

                apiResponse = investmentAPI.getInvestmentData();

                JSONObject jsonObject = new JSONObject(apiResponse.substring(4, apiResponse.length()));
                JSONArray jsonArrayInfo = jsonObject.getJSONObject("screen").getJSONArray("info");
                JSONArray jsonArrayDownInfo = jsonObject.getJSONObject("screen").getJSONArray("downInfo");

                modelScreen = gson.fromJson(jsonObject.getString("screen"), ModelScreen.class);
                modelMonth = gson.fromJson(jsonObject.getJSONObject("screen").getJSONObject("moreInfo").getString("month"), ModelMonth.class);
                modelYear = gson.fromJson(jsonObject.getJSONObject("screen").getJSONObject("moreInfo").getString("year"), ModelYear.class);
                modelTwelveMonths = gson.fromJson(jsonObject.getJSONObject("screen").getJSONObject("moreInfo").getString("12months"), ModelTwelveMonths.class);
                modelMoreInfo = new ModelMoreInfo(modelMonth, modelYear, modelTwelveMonths);

                for(int i = 0; i < jsonArrayInfo.length(); i++){
                    ModelInfo mInfo = gson.fromJson(jsonArrayInfo.getJSONObject(i).toString(), ModelInfo.class);
                    modelInfo.add(mInfo);
                }

                for(int i = 0; i < jsonArrayDownInfo.length(); i++){
                    ModelDownInfo mDownInfo = gson.fromJson(jsonArrayDownInfo.getJSONObject(i).toString(), ModelDownInfo.class);
                    modelDownInfo.add(mDownInfo);
                }


            } catch (IOException e) {
                return e.toString();
            } catch (JSONException e) {
                return e.toString();
            }

            return "OK";
        }

        @Override
        protected void onPostExecute(String result) {

            if (result.equals("OK")) {
                fragmentInvestment.loadScreen(modelScreen);
                fragmentInvestment.loadMoreInfo(modelMoreInfo);
                fragmentInvestment.loadInfo(modelInfo);
                fragmentInvestment.loadDownInfo(modelDownInfo);
            }

            fragmentInvestment.finishLoadProgressBar();
        }
    }
}
