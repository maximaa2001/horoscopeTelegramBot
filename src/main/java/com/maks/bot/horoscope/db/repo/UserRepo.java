package com.maks.bot.horoscope.db.repo;

import com.maks.bot.horoscope.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByChatId(Long chatId);
}
