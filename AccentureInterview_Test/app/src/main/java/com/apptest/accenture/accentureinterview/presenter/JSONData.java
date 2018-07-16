package com.apptest.accenture.accentureinterview.presenter;

import com.apptest.accenture.accentureinterview.model.InvestmentModel;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by fcost on 26/06/2018.
 */

public class JSONData {

    String data;

    public InvestmentModel getInvestmentData() throws IOException, JSONException {

        URL url = new URL("https://floating-mountain-50292.herokuapp.com/fund.json");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStrem = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStrem));

        String line = "";

        while(line != null){
            line = bufferedReader.readLine();
            data = data + line;
        }

        return new InvestmentModel(data);
    }

    public InvestmentModel getContactData() throws IOException, JSONException {

        URL url = new URL("https://floating-mountain-50292.herokuapp.com/cells.json");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStrem = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStrem));

        String line = "";

        while(line != null){
            line = bufferedReader.readLine();
            data = data + line;
        }

        return new InvestmentModel(data);
    }
}
