package com.apptest.accenture.accentureinterview.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.apptest.accenture.accentureinterview.R;
import com.apptest.accenture.accentureinterview.model.ModelContact;
import com.apptest.accenture.accentureinterview.utility.ProgressDialog;
import com.apptest.accenture.accentureinterview.presenter.PresenterContact;
import com.apptest.accenture.accentureinterview.view.Contact;


/**
 * Created by fcost on 26/06/2018.
 */

public class FragmentContact extends Fragment implements Contact.View {

    private EditText txtCompleteName;
    private EditText txtEmail;
    private EditText txtTelephone;
    private CheckBox checkBoxRegister;
    private Button btnSend;
    private View vw;
    private Contact.Presenter contactPresenter;
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        vw = inflater.inflate(R.layout.fragment_contact, container, false);
        contactPresenter = new PresenterContact(this, getActivity());

        txtCompleteName = vw.findViewById(R.id.txtCompleteNameValue);
        txtEmail = vw.findViewById(R.id.txtEmailValue);
        txtTelephone = vw.findViewById(R.id.txtTelephoneValue);
        checkBoxRegister = vw.findViewById(R.id.checkBoxRegister);
        btnSend = vw.findViewById(R.id.btnSend);
        contactPresenter.maskTelephoneNumber(txtTelephone);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean emailRegister = false;

                if(checkBoxRegister.isChecked())
                    emailRegister = true;
                else
                    emailRegister = false;

                ModelContact modelContact = new ModelContact(
                        txtCompleteName.getText().toString(),
                        txtEmail.getText().toString(),
                        txtTelephone.getText().toString(),
                        emailRegister
                );

                contactPresenter.sendContact(modelContact);

            }
        });



        setTextViewCustomFont(vw);

        return vw;
    }

    public void setTextViewCustomFont(View view){

        TextView txtCompleteName = view.findViewById(R.id.txtCompleteName);
        TextView txtEmail = view.findViewById(R.id.txtEmail);
        TextView txtTelephone = view.findViewById(R.id.txtTelephone);
        CheckBox checkBoxRegister = view.findViewById(R.id.checkBoxRegister);

        Typeface mTypeface = Typeface.createFromAsset(getActivity().getAssets(), "DINNeuzeitGroteskStd-Light.ttf");

        txtCompleteName.setTypeface(mTypeface);
        txtEmail.setTypeface(mTypeface);
        txtTelephone.setTypeface(mTypeface);
        checkBoxRegister.setTypeface(mTypeface);

        txtCompleteName.setTextColor(Color.parseColor("#AFAFAF"));
        txtEmail.setTextColor(Color.parseColor("#AFAFAF"));
        txtTelephone.setTextColor(Color.parseColor("#AFAFAF"));
        checkBoxRegister.setTextColor(Color.parseColor("#AFAFAF"));
    }

    @Override
    public void noInternetConnection() {
        showDialog(getResources().getString(R.string.attention),
                getResources().getString(R.string.no_internet_connection));

    }

    @Override
    public void txtCompleteNameValueEmpty() {
        showDialog(getResources().getString(R.string.error),
                getResources().getString(R.string.empty_complete_name));

    }

    @Override
    public void txtEmailValueEmpty() {
        showDialog(getResources().getString(R.string.error),
                getResources().getString(R.string.empty_email));
    }

    @Override
    public void txtTelephoneValueEmpty() {
        showDialog(getResources().getString(R.string.error),
                getResources().getString(R.string.empty_telephone));
    }

    @Override
    public void txtEmailValueInvalidFormat() {

        showDialog(getResources().getString(R.string.attention),
                getResources().getString(R.string.invalid_email));
    }

    @Override
    public void txtTelephoneValueInvalidFormat() {
        showDialog(getResources().getString(R.string.attention),
                getResources().getString(R.string.invalid_phone_number));
    }

    @Override
    public void setTxtTelephoneMask(TextWatcher textWatcher) {
        this.txtTelephone.addTextChangedListener(textWatcher);
    }

    @Override
    public void sendSuccess() {

        showDialog(getResources().getString(R.string.success),
                getResources().getString(R.string.message_success));
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

    private void showDialog(String title, String msg) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
