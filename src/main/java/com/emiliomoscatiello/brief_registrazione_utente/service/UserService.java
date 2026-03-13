package com.emiliomoscatiello.brief_registrazione_utente.service;

import com.emiliomoscatiello.brief_registrazione_utente.dto.RegisterRequestDTO;
import com.emiliomoscatiello.brief_registrazione_utente.model.User;

public interface UserService {

    User registraUtente(RegisterRequestDTO dto);
}
