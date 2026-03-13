package com.emiliomoscatiello.brief_registrazione_utente.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "utente")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Lo username e' obbligatorio")
    @Size(min = 3, max = 50, message = "Lo username deve essere tra 3 e 50 caratteri")
    @Column(name = "username", unique = true, nullable = false, length = 50)
    private String username;

    @NotBlank(message = "Il telefono e' obbligatorio")
    @Size(max = 50, message = "Il telefono deve essere al massimo 50 caratteri")
    @Column(name = "telefono", unique = true, nullable = false, length = 50)
    private String telefono;

    @NotNull(message = "La data di nascita e' obbligatoria")
    @Column(name = "data_di_nascita", nullable = false)
    private LocalDate dataDiNascita;

    @NotBlank(message = "L'email e' obbligatoria")
    @Email(message = "L'email deve essere in formato valido")
    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    @NotBlank(message = "La password e' obbligatoria")
    @Size(min = 6, message = "La password deve avere almeno 6 caratteri")
    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @NotNull(message = "Il ruolo e' obbligatorio")
    @Enumerated(EnumType.STRING)
    @Column(name = "ruolo", nullable = false)
    private UserRole ruolo;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
