package com.andrewexe.userExam.repositories;

import com.andrewexe.userExam.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM users u WHERE u.age >= :age ORDER BY u.firstName")
    List<User> getUsersByAge(@Param("age") int age);
}
