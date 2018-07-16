package com.apptest.accenture.accentureinterview.data.api;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class InvestmentAPI {

    String data;

    public InvestmentAPI(){

    }

    public String getInvestmentData() throws IOException {

        URL url = new URL("https://floating-mountain-50292.herokuapp.com/fund.json");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStrem = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStrem));

        String line = "";

        while(line != null){
            line = bufferedReader.readLine();
            data = data + line;
        }

        return data;
    }
}
