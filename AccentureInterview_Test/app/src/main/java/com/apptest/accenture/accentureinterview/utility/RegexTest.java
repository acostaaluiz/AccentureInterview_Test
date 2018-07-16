package com.apptest.accenture.accentureinterview.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fcost on 29/06/2018.
 */

public class RegexTest {

    public enum RegexType {
        EMAIL, TELEPHONE;
    }

    public RegexTest(){

    }

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String TEL_PATTERN = "^(\\([0-9]{2}\\))\\s([9]{1})?([0-9]{4})-([0-9]{4})$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

    public boolean isValidFormat(String individualTest, RegexType regexType) {

        boolean check = false;
        Matcher matcher = pattern.matcher(individualTest);

        if(regexType == RegexType.TELEPHONE)
            check = individualTest.matches(TEL_PATTERN);
        else if(regexType == RegexType.EMAIL)
            check = matcher.matches();

        return check;
    }
}
