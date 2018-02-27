package net.minecraft.api.controller;

import net.minecraft.api.entity.StatisticEntity;
import net.minecraft.api.entity.type.StatisticType;
import net.minecraft.api.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@RestController("minecraft-api-controller")
@RequestMapping(path = "/api")
public class StatisticController {

    private final StatisticRepository statisticRepository;

    @Autowired
    public StatisticController(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    @GetMapping(path = "/withers/killed")
    public StatisticEntity getWitherKillAmount() {
        StatisticEntity statistic = statisticRepository.findByType(StatisticType.WITHERS_KILLED);
        if (statistic == null) {
            statistic = new StatisticEntity(StatisticType.WITHERS_KILLED, 0);
            return statisticRepository.save(statistic);
        }
        return statistic;
    }

    @PostMapping(path = "/withers/killed", params = "amount")
    public StatisticEntity addWitherKillAmount(@RequestParam(name = "amount") int amount) {
        StatisticEntity statistic = statisticRepository.findByType(StatisticType.WITHERS_KILLED);
        if (statistic == null) {
            statistic = new StatisticEntity(StatisticType.WITHERS_KILLED, 0);
        }
        int kills = statistic.getIntValue() + amount;
        statistic.setIntValue(kills);
        return statisticRepository.save(statistic);
    }

    @PostMapping(path = "/withers/killed/reset", params = "amount")
    public StatisticEntity addWitherKillAmount() {
        StatisticEntity statistic = statisticRepository.findByType(StatisticType.WITHERS_KILLED);
        statistic.setIntValue(0);
        return statisticRepository.save(statistic);
    }
}
