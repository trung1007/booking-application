package com.example.BookingApplication.repository;

import com.example.BookingApplication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User save(User user);
    List<User> findByEmail(String email);
    User findById(long id);
    void deleteById(long id);
}
