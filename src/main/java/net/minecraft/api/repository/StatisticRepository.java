package net.minecraft.api.repository;

import net.minecraft.api.entity.StatisticEntity;
import net.minecraft.api.entity.type.StatisticType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticRepository extends JpaRepository<StatisticEntity, Long> {

    StatisticEntity findByType(StatisticType name);
}
