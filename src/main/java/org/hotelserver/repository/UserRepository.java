package org.hotelserver.repository;

import org.hotelserver.entity.User;
import org.hotelserver.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    Optional<User>findByRole(UserRole role);
}
