package com.emiliomoscatiello.brief_registrazione_utente.dto;

import com.emiliomoscatiello.brief_registrazione_utente.model.UserRole;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class RegisterResponseDTO {

    private Long id;
    private String username;
    private String email;
    private String telefono;
    private LocalDate dataDiNascita;
    private UserRole ruolo;
    private LocalDateTime createdAt;
}
