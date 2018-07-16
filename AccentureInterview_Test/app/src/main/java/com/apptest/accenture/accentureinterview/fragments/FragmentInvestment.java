package com.apptest.accenture.accentureinterview.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apptest.accenture.accentureinterview.R;

import com.apptest.accenture.accentureinterview.model.ModelDownInfo;
import com.apptest.accenture.accentureinterview.model.ModelInfo;
import com.apptest.accenture.accentureinterview.model.ModelMoreInfo;
import com.apptest.accenture.accentureinterview.model.ModelScreen;
import com.apptest.accenture.accentureinterview.presenter.PresenterInvestment;
import com.apptest.accenture.accentureinterview.utility.ProgressDialog;
import com.apptest.accenture.accentureinterview.view.Investment;

import java.util.ArrayList;

/**
 * Created by fcost on 26/06/2018.
 */

public class FragmentInvestment extends Fragment implements Investment.View {

    private TextView txtTitle;
    private TextView txtFundName;
    private TextView txtWhatIs;
    private TextView txtDefinition;
    private TextView txtRiskTitle;
    private ImageView pointer1;
    private ImageView pointer2;
    private ImageView pointer3;
    private ImageView pointer4;
    private ImageView pointer5;
    private TextView txtInfoTitle;
    private TextView txtValueFundMonth;
    private TextView txtValueCDIMonth;
    private TextView txtValueFundYear;
    private TextView txtValueCDIYear;
    private TextView txtValueFund12Months;
    private TextView txtValueCDI12Months;
    private TextView txtInfo1;
    private TextView txtInfo2;
    private TextView txtInfo3;
    private TextView txtInfo4;
    private TextView txtInfo5;
    private TextView txtInfo6;
    private TextView txtInfo7;
    private TextView txtInfoValue1;
    private TextView txtInfoValue2;
    private TextView txtInfoValue3;
    private TextView txtInfoValue4;
    private TextView txtInfoValue5;
    private TextView txtInfoValue6;
    private TextView txtInfoValue7;
    private TextView txtDownInfo1;
    private TextView txtDownInfo2;
    private TextView txtDownInfo3;
    private TextView txtDownInfo4;
    private TextView txtDownInfo5;
    private Investment.Presenter investmentPresenter;
    private ProgressDialog progressDialog;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View vw = inflater.inflate(R.layout.fragment_investment, container, false);

        initView(vw);

        investmentPresenter = new PresenterInvestment(this, getActivity());
        investmentPresenter.getInvestment();

        return vw;
    }

    @Override
    public void loadScreen(ModelScreen modelScreen) {

        txtTitle.setText(modelScreen.getTitle());
        txtFundName.setText(modelScreen.getFundName());
        txtWhatIs.setText(modelScreen.getWhatIs());
        txtDefinition.setText(modelScreen.getDefinition());
        txtRiskTitle.setText(modelScreen.getRiskTitle());
        txtInfoTitle.setText(modelScreen.getInfoTitle());

        changePointerVisibility(modelScreen.getRisk());
    }

    @Override
    public void loadMoreInfo(ModelMoreInfo modelMoreInfo) {

        txtValueFundMonth.setText(modelMoreInfo.getMonth().getFund());
        txtValueCDIMonth.setText(modelMoreInfo.getMonth().getCdi());
        txtValueFundYear.setText(modelMoreInfo.getYear().getFund());
        txtValueCDIYear.setText(modelMoreInfo.getYear().getCdi());
        txtValueFund12Months.setText(modelMoreInfo.getTwelveMonths().getFund());
        txtValueCDI12Months.setText(modelMoreInfo.getTwelveMonths().getCdi());
    }

    @Override
    public void loadInfo(ArrayList<ModelInfo> infos) {

        for(int i = 0; i < infos.size(); i++){

            ModelInfo modelInfo = infos.get(i);

            if(i == 0) {
                txtInfo1.setText(modelInfo.getName());
                txtInfoValue1.setText(modelInfo.getData());
            } else if(i == 1){
                txtInfo2.setText(modelInfo.getName());
                txtInfoValue2.setText(modelInfo.getData());
            } else if(i == 2){
                txtInfo3.setText(modelInfo.getName());
                txtInfoValue3.setText(modelInfo.getData());
            } else if(i == 3){
                txtInfo4.setText(modelInfo.getName());
                txtInfoValue4.setText(modelInfo.getData());
            } else if(i == 4){
                txtInfo5.setText(modelInfo.getName());
                txtInfoValue5.setText(modelInfo.getData());
            } else if(i == 5){
                txtInfo6.setText(modelInfo.getName());
                txtInfoValue6.setText(modelInfo.getData());
            } else if(i == 6){
                txtInfo7.setText(modelInfo.getName());
                txtInfoValue7.setText(modelInfo.getData());
            }
        }
    }

    @Override
    public void loadDownInfo(ArrayList<ModelDownInfo> downInfos) {

        for(int i = 0; i < downInfos.size(); i++){

            ModelDownInfo modelDownInfo = downInfos.get(i);

            if(i == 0) {
                txtDownInfo1.setText(modelDownInfo.getName());

            } else if(i == 1){
                txtDownInfo2.setText(modelDownInfo.getName());

            } else if(i == 2){
                txtDownInfo3.setText(modelDownInfo.getName());

            } else if(i == 3){
                txtDownInfo4.setText(modelDownInfo.getName());

            } else if(i == 4){
                txtDownInfo5.setText(modelDownInfo.getName());

            }
        }
    }

    @Override
    public void initLoadProgressBar() {
        progressDialog = new ProgressDialog();
        progressDialog.show(getActivity().getSupportFragmentManager(),
                getResources().getString(R.string.loading));
    }

    @Override
    public void finishLoadProgressBar() {
        progressDialog.dismiss();
    }

    public void initView(View vw){

        txtTitle = vw.findViewById(R.id.txtTitle);
        txtFundName = vw.findViewById(R.id.txtFundName);
        txtWhatIs = vw.findViewById(R.id.txtWhatIs);
        txtDefinition = vw.findViewById(R.id.txtDefinition);
        txtRiskTitle = vw.findViewById(R.id.txtRiskTitle);
        //txtRisk = vw.findViewById(R.id.txtRisk);
        txtInfoTitle = vw.findViewById(R.id.txtInfoTitle);
        txtValueFundMonth = vw.findViewById(R.id.txtValueFundMonth);
        txtValueCDIMonth = vw.findViewById(R.id.txtValueCDIMonth);
        txtValueFundYear = vw.findViewById(R.id.txtValueFundYear);
        txtValueCDIYear = vw.findViewById(R.id.txtValueCDIYear);
        txtValueFund12Months = vw.findViewById(R.id.txtValueFund12Months);
        txtValueCDI12Months = vw.findViewById(R.id.txtValueCDI12Months);

        txtInfo1 = vw.findViewById(R.id.txtInfo1);
        txtInfo2 = vw.findViewById(R.id.txtInfo2);
        txtInfo3 = vw.findViewById(R.id.txtInfo3);
        txtInfo4 = vw.findViewById(R.id.txtInfo4);
        txtInfo5 = vw.findViewById(R.id.txtInfo5);
        txtInfo6 = vw.findViewById(R.id.txtInfo6);
        txtInfo7 = vw.findViewById(R.id.txtInfo7);

        txtInfoValue1 = vw.findViewById(R.id.txtInfoValue1);
        txtInfoValue2 = vw.findViewById(R.id.txtInfoValue2);
        txtInfoValue3 = vw.findViewById(R.id.txtInfoValue3);
        txtInfoValue4 = vw.findViewById(R.id.txtInfoValue4);
        txtInfoValue5 = vw.findViewById(R.id.txtInfoValue5);
        txtInfoValue6 = vw.findViewById(R.id.txtInfoValue6);
        txtInfoValue7 = vw.findViewById(R.id.txtInfoValue7);

        txtDownInfo1 = vw.findViewById(R.id.txtDownInfo1);
        txtDownInfo2 = vw.findViewById(R.id.txtDownInfo2);
        txtDownInfo3 = vw.findViewById(R.id.txtDownInfo3);
        txtDownInfo4 = vw.findViewById(R.id.txtDownInfo4);
        txtDownInfo5 = vw.findViewById(R.id.txtDownInfo5);

        pointer1 = vw.findViewById(R.id.imv_pointer_lvl1);
        pointer2 = vw.findViewById(R.id.imv_pointer_lvl2);
        pointer3 = vw.findViewById(R.id.imv_pointer_lvl3);
        pointer4 = vw.findViewById(R.id.imv_pointer_lvl4);
        pointer5 = vw.findViewById(R.id.imv_pointer_lvl5);
    }

    private void changePointerVisibility(String pos){

        pointer1.setVisibility(pos.equals("1") ? View.VISIBLE : View.INVISIBLE);
        pointer2.setVisibility(pos.equals("2") ? View.VISIBLE : View.INVISIBLE);
        pointer3.setVisibility(pos.equals("3") ? View.VISIBLE : View.INVISIBLE);
        pointer4.setVisibility(pos.equals("4") ? View.VISIBLE : View.INVISIBLE);
        pointer5.setVisibility(pos.equals("5") ? View.VISIBLE : View.INVISIBLE);
    }
}
