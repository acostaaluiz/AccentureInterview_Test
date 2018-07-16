package com.apptest.accenture.accentureinterview.view;

import android.text.TextWatcher;
import android.widget.EditText;

import com.apptest.accenture.accentureinterview.model.ModelContact;

public interface Contact {

    interface View{

        void noInternetConnection();
        void txtCompleteNameValueEmpty();
        void txtEmailValueEmpty();
        void txtTelephoneValueEmpty();
        void txtEmailValueInvalidFormat();
        void txtTelephoneValueInvalidFormat();
        void setTxtTelephoneMask(TextWatcher textWatcher);
        void sendSuccess();
        void initLoadProgressBar();
        void finishLoadProgressBar();

    }

    interface Presenter{

        void sendContact(ModelContact modelContact);
        void maskTelephoneNumber(EditText txtTelephone);
    }
}
