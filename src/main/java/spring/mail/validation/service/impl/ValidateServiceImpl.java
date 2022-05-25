package spring.mail.validation.service.impl;

import spring.mail.validation.service.ValidateService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateServiceImpl implements ValidateService {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public ValidateServiceImpl(){
        pattern=Pattern.compile(EMAIL_REGEX);
    }

    @Override
    public Boolean validate(String mail){
        matcher = pattern.matcher(mail);
        return matcher.matches();
    }
}

