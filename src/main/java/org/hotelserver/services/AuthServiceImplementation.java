package org.hotelserver.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hotelserver.entity.User;
import org.hotelserver.enums.UserRole;
import org.hotelserver.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImplementation {
    private final UserRepository userRepository;

    @PostConstruct
    public void createAnAdminAccount(){
        Optional<User>adminAccount = userRepository.findByRole(UserRole.ADMIN);
        if (adminAccount.isEmpty()){
            User user = new User();
            user.setEmail("admin@test.com");
            user.setName("Admin");
            user.setRole(UserRole.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);

            System.out.println("Admin account created successfully");
        }
        else System.out.println("Admin account already exist");
    }
}
