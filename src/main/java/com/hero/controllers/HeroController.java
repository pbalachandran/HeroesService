package com.hero.controllers;

import com.hero.models.HeroResponse;
import com.hero.models.HeroViewModel;
import com.hero.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class HeroController {

    @Autowired
    private HeroService heroService;

    @GetMapping("/heroes")
    public ResponseEntity<List<HeroViewModel>> getHeroes() {
        List<HeroResponse> responses = heroService.getHeroes();
        List<HeroViewModel> viewModels =
                responses.stream()
                        .map(heroResponse -> new HeroViewModel(heroResponse.getId(),
                                heroResponse.getName())).collect(Collectors.toList());
        return new ResponseEntity<>(viewModels, HttpStatus.OK);
    }


    @GetMapping("/hero/{id}")
    public ResponseEntity<HeroViewModel> getHero(@PathVariable("id") int id) {
        HeroResponse response = heroService.getHero(id);
        HeroViewModel viewModel = new HeroViewModel(response.getId(), response.getName());
        return new ResponseEntity<>(viewModel, HttpStatus.OK);
    }
}
