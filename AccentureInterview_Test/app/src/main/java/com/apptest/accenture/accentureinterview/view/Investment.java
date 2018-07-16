package com.apptest.accenture.accentureinterview.view;

import com.apptest.accenture.accentureinterview.model.ModelDownInfo;
import com.apptest.accenture.accentureinterview.model.ModelInfo;
import com.apptest.accenture.accentureinterview.model.ModelMoreInfo;
import com.apptest.accenture.accentureinterview.model.ModelScreen;

import java.util.ArrayList;

public interface Investment {

    interface View{

        void loadScreen(ModelScreen modelScreen);
        void loadMoreInfo(ModelMoreInfo modelMoreInfo);
        void loadInfo(ArrayList<ModelInfo> infos);
        void loadDownInfo(ArrayList<ModelDownInfo> downInfos);
        void initLoadProgressBar();
        void finishLoadProgressBar();
    }

    interface Presenter{

        void getInvestment();

    }
}
