package com.daw.cinemadaw.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.daw.cinemadaw.domain.cinema.User.Role;
import com.daw.cinemadaw.domain.cinema.User.User;
import com.daw.cinemadaw.repository.UserRepository;

import jakarta.transaction.Transactional;

@Transactional
@Component
public class Pruebas implements CommandLineRunner {

    private UserRepository userRepository;
    BCryptPasswordEncoder encoder;

    public Pruebas(BCryptPasswordEncoder encoder, UserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(encoder.encode("1234"));
        admin.setRole(Role.ADMIN);
        userRepository.save(admin);

        User client = new User();
        client.setUsername("client");
        client.setPassword(encoder.encode("1234"));
        client.setRole(Role.CLIENT);
        userRepository.save(client);

        User admin2 = new User();
        admin2.setUsername("adminexam");
        admin2.setPassword(encoder.encode("exam"));
        admin2.setRole(Role.ADMIN);
        userRepository.save(admin2);

        User client2 = new User();
        client2.setUsername("clientexam");
        client2.setPassword(encoder.encode("exam"));
        client2.setRole(Role.CLIENT);
        userRepository.save(client2);

    }

}
