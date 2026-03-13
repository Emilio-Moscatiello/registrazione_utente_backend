package com.emiliomoscatiello.brief_registrazione_utente.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhoneNumber {

    String message() default "Numero di telefono non valido. Usa il formato internazionale (es. +393331234567)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
