package com.apptest.accenture.accentureinterview.presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;

import com.apptest.accenture.accentureinterview.model.ModelContact;
import com.apptest.accenture.accentureinterview.utility.MaskUtility;
import com.apptest.accenture.accentureinterview.utility.NetworkConnectionTest;
import com.apptest.accenture.accentureinterview.utility.RegexTest;
import com.apptest.accenture.accentureinterview.view.Contact;

public class PresenterContact implements Contact.Presenter {

    private Contact.View fragmentContact;
    private RegexTest regexTest;
    private NetworkConnectionTest networkConnectionTest;
    private ModelContact modelContact;

    public PresenterContact(Contact.View fragmentContact, Context context){
        this.fragmentContact = fragmentContact;
        this.regexTest = new RegexTest();
        this.networkConnectionTest = new NetworkConnectionTest(context);
    }

    @Override
    public void sendContact(ModelContact modelContact) {

        this.modelContact = modelContact;

        SendContact sendContact = new SendContact();
        sendContact.execute();
    }

    @Override
    public void maskTelephoneNumber(EditText txtTelephone) {
        fragmentContact.setTxtTelephoneMask(MaskUtility.insert(txtTelephone));
    }

    private class SendContact extends
            AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            fragmentContact.initLoadProgressBar();
        }

        @Override
        protected String doInBackground(String... strings) {

            if(!networkConnectionTest.isNetworkAvailable())
                return "NO_INTERNET_CONNECTION";
            else if(modelContact.getContactName().isEmpty())
                return "COMPLETE_NAME_EMPTY";
            else if(modelContact.getEmail().isEmpty())
                return "EMAIL_EMPTY";
            else if(modelContact.getTelephone().isEmpty())
                return "TELEPHONE_EMPTY";
            else if(!regexTest.isValidFormat(modelContact.getEmail(), RegexTest.RegexType.EMAIL))
                return "INVALID_EMAIL_FORMAT";
            else if(!regexTest.isValidFormat(modelContact.getTelephone(), RegexTest.RegexType.TELEPHONE))
                return "INVALID_TELEPHONE_FORMAT";

            return "OK";
        }

        @Override
        protected void onPostExecute(String result) {

            if(result.equals("NO_INTERNET_CONNECTION"))
                fragmentContact.noInternetConnection();
            else if(result.equals("COMPLETE_NAME_EMPTY"))
                fragmentContact.txtCompleteNameValueEmpty();
            else if(result.equals("EMAIL_EMPTY"))
                fragmentContact.txtEmailValueEmpty();
            else if(result.equals("TELEPHONE_EMPTY"))
                fragmentContact.txtTelephoneValueEmpty();
            else if(result.equals("INVALID_EMAIL_FORMAT"))
                fragmentContact.txtEmailValueInvalidFormat();
            else if(result.equals("INVALID_TELEPHONE_FORMAT"))
                fragmentContact.txtTelephoneValueInvalidFormat();
            else if(result.equals("OK"))
                fragmentContact.sendSuccess();

            fragmentContact.finishLoadProgressBar();
        }
    }
}
