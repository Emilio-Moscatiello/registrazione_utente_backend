package com.emiliomoscatiello.brief_registrazione_utente.service;

import com.emiliomoscatiello.brief_registrazione_utente.dto.RegisterRequestDTO;
import com.emiliomoscatiello.brief_registrazione_utente.model.User;
import com.emiliomoscatiello.brief_registrazione_utente.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User registraUtente(RegisterRequestDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email gia' in uso");
        }
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new IllegalArgumentException("Username gia' in uso");
        }
        if (userRepository.existsByTelefono(dto.getTelefono())) {
            throw new IllegalArgumentException("Numero di telefono gia' in uso");
        }

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setTelefono(dto.getTelefono());
        user.setDataDiNascita(dto.getDataDiNascita());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // TODO: hash con BCrypt quando si aggiunge Spring Security
        user.setRuolo(dto.getRuolo());
        user.setEnabled(true);

        return userRepository.save(user);
    }
}
