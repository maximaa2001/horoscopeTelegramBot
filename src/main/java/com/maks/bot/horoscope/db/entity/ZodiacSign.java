package com.maks.bot.horoscope.db.entity;

import com.maks.bot.horoscope.constant.define.ZodiacSignDefine;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "zodiac_signs")
public class ZodiacSign {

    @Id
    @Column(name = "id", nullable = false)
    private Short id;

    @NotNull
    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    @Enumerated(EnumType.STRING)
    private ZodiacSignDefine name;

    public ZodiacSign(ZodiacSignDefine zodiacSignDefine) {
        this.id = zodiacSignDefine.getId();
        this.name = zodiacSignDefine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZodiacSign that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
