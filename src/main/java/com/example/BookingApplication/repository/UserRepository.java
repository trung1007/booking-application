package com.example.BookingApplication.repository;

import com.example.BookingApplication.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User save(User user);
}
