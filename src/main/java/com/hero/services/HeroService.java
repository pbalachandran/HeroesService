package com.hero.services;

import com.hero.models.Hero;
import com.hero.models.HeroResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HeroService {

    private Hero[] heroes = {
            new Hero(11, "Mr. Nice"),
            new Hero(12, "Narco"),
            new Hero(13, "Bombasto"),
            new Hero(14, "Celeritas"),
            new Hero(15, "Magneta"),
            new Hero(16, "RubberMan"),
            new Hero(17, "Dynama"),
            new Hero(18, "Dr IQ"),
            new Hero(19, "Magma"),
            new Hero(20, "Tornado")
    };

    public List<HeroResponse> getHeroes() {
        return Arrays.stream(heroes)
                .map(hero -> new HeroResponse(hero.getId(), hero.getName())).collect(Collectors.toList());
    }

    public HeroResponse getHero(int id) {
        Optional<Hero> filtered = Arrays.stream(heroes)
                .filter(hero -> hero.getId() == (id)).findFirst();
        return new HeroResponse(filtered.get().getId(), filtered.get().getName());
    }
}
