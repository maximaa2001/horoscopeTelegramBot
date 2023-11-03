package com.maks.bot.horoscope.db.repo;

import com.maks.bot.horoscope.db.entity.ZodiacSign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZodiacSignRepo extends JpaRepository<ZodiacSign, Short> {
}
