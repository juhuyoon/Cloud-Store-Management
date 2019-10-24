package com.company.levelupservice.circuitbreaker;

import com.company.levelupservice.model.LevelViewModel;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class LevelUpServiceCircuitBreaker {

    private final RestTemplate restTemplate;

    public LevelUpServiceCircuitBreaker(RestTemplate rest){
        this.restTemplate = rest;
    }

    @HystrixCommand(fallbackMethod = "defaultLevelUp")
    //method
    public LevelViewModel getLevelUp(int level_up_id){
        return this.restTemplate.getForObject(
        "/level-up/{level_up_id}",
            LevelViewModel.class,
            level_up_id
        );
    }

    //fallback
    private LevelViewModel defaultLevelUp(int level_up_id){
        LevelViewModel defaultlvm = new LevelViewModel(
                level_up_id,
                0,
                0,
                LocalDate.of(2000,01,01),
                "Sorry, Level Up! is down. Please check back again later to see your rewards points."
        );
        return defaultlvm;
    }
}
