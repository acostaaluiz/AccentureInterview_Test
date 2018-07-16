package com.apptest.accenture.accentureinterview.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fcost on 26/06/2018.
 */

public class ModelContact {

    private String contactName;
    private String email;
    private String telephone;
    private boolean emailRegister;

    public ModelContact(String contactName, String email, String telephone, boolean emailRegister){
        this.contactName = contactName;
        this.email = email;
        this.telephone = telephone;
        this.emailRegister = emailRegister;
    }

    public String getContactName() {
        return contactName;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public boolean isEmailRegister() {
        return emailRegister;
    }
}
