package com.hero.services;

import com.hero.models.HeroResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HeroServiceTest {

    private HeroService subject;
    private List<HeroResponse> expected = new ArrayList<>();

    @Before
    public void setUp() {
        expected.add(new HeroResponse(11, "Mr. Nice"));
        expected.add(new HeroResponse(12, "'Narco"));
        expected.add(new HeroResponse(13, "'Bombasto'"));
        expected.add(new HeroResponse(14, "Celeritas"));
        expected.add(new HeroResponse(15, "'Magneta'"));
        expected.add(new HeroResponse(16, "RubberMan"));
        expected.add(new HeroResponse(17, "Dynama"));
        expected.add(new HeroResponse(18, "Dr IQ"));
        expected.add(new HeroResponse(19, "Magma"));
        expected.add(new HeroResponse(20, "Tornado"));

        subject = new HeroService();
    }

    @Test
    public void getHeroes_returnsHeroes() {
        List<HeroResponse> actual = subject.getHeroes();

        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get(0), actual.get(0));
        assertEquals(expected.get(9), actual.get(9));
    }

    @Test
    public void getHero_whenGivenAnId_returnsHero() {
        HeroResponse expected = new HeroResponse(11, "Mr. Nice");
        HeroResponse actual = subject.getHero(11);

        assertEquals(expected, actual);
    }
}