package com.banking.app.Repository;

import com.banking.app.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //custom query methods
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail (String email);

    void deleteByUsername(String Username);

    boolean exitsByUsername(String username);
    boolean exitsByEmail(String email);
}
