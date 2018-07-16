package com.apptest.accenture.accentureinterview;

import com.apptest.accenture.accentureinterview.model.ModelContact;
import com.apptest.accenture.accentureinterview.utility.RegexTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTest {

    @Test
    public void completeNameLessThanZero(){

        boolean testResult;
        ModelContact contactModel = new ModelContact("", "email@email.com", "(11) 3761-5212", true);

        if(contactModel.getContactName().length() > 0)
            testResult = true;
        else
            testResult = false;

        assertEquals(false, testResult);
    }

    @Test
    public void invalidEmail(){

        ModelContact contactModel = new ModelContact("FLA", "email.email.com", "(11) 3761-5212", true);
        RegexTest regexTest = new RegexTest();
        boolean testResult = regexTest.isValidFormat(contactModel.getEmail(), RegexTest.RegexType.EMAIL);

        assertEquals(false, testResult);
    }

    @Test
    public void invalidTelephoneNumber(){

        ModelContact contactModel = new ModelContact("FLA", "email@email.com", "(11) 371-5212", true);
        RegexTest regexTest = new RegexTest();
        boolean testResult = regexTest.isValidFormat(contactModel.getTelephone(), RegexTest.RegexType.TELEPHONE);

        assertEquals(false, testResult);
    }

    @Test
    public void invalidCellphoneNumber(){

        ModelContact contactModel = new ModelContact("FLA", "email@email.com", "(11) 94761-512", true);
        RegexTest regexTest = new RegexTest();
        boolean testResult = regexTest.isValidFormat(contactModel.getTelephone(), RegexTest.RegexType.TELEPHONE);

        assertEquals(false, testResult);
    }
}