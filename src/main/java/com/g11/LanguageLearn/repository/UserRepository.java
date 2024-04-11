package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.Point;
import com.g11.LanguageLearn.entity.Room;
import com.g11.LanguageLearn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findOneByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
}
