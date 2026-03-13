package com.emiliomoscatiello.brief_registrazione_utente.dto;

import com.emiliomoscatiello.brief_registrazione_utente.model.UserRole;
import com.emiliomoscatiello.brief_registrazione_utente.validation.ValidPhoneNumber;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterRequestDTO {

    @NotBlank(message = "Lo username e' obbligatorio")
    @Size(min = 3, max = 50, message = "Lo username deve essere tra 3 e 50 caratteri")
    private String username;

    @NotBlank(message = "Il telefono e' obbligatorio")
    @ValidPhoneNumber
    private String telefono;

    @NotNull(message = "La data di nascita e' obbligatoria")
    private LocalDate dataDiNascita;

    @NotBlank(message = "L'email e' obbligatoria")
    @Email(message = "L'email deve essere in formato valido")
    private String email;

    @NotBlank(message = "La password e' obbligatoria")
    @Size(min = 6, message = "La password deve avere almeno 6 caratteri")
    private String password;

    @NotNull(message = "Il ruolo e' obbligatorio")
    private UserRole ruolo;
}
