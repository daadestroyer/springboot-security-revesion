package com.springbootsecurityrevesion.Repo;

import com.springbootsecurityrevesion.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    public Optional<User> findByUserEmail(String email);
}
