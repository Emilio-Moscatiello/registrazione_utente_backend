package com.emiliomoscatiello.brief_registrazione_utente.controller;

import com.emiliomoscatiello.brief_registrazione_utente.dto.RegisterRequestDTO;
import com.emiliomoscatiello.brief_registrazione_utente.dto.RegisterResponseDTO;
import com.emiliomoscatiello.brief_registrazione_utente.model.User;
import com.emiliomoscatiello.brief_registrazione_utente.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/utenti")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/registrazione")
    public ResponseEntity<RegisterResponseDTO> registraUtente(@Valid @RequestBody RegisterRequestDTO dto) {
        User user = userService.registraUtente(dto);

        RegisterResponseDTO response = new RegisterResponseDTO();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setTelefono(user.getTelefono());
        response.setDataDiNascita(user.getDataDiNascita());
        response.setRuolo(user.getRuolo());
        response.setCreatedAt(user.getCreatedAt());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
