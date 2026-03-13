package com.emiliomoscatiello.brief_registrazione_utente.validation;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    private static final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return false;
        }
        try {
            Phonenumber.PhoneNumber number = phoneUtil.parse(value, null);
            return phoneUtil.isValidNumber(number);
        } catch (NumberParseException e) {
            return false;
        }
    }
}
