package Nesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Nesting DB test")
class BirdDaoTest {

    BirdDao birdDao;
    NestDao nestDao;


    @BeforeEach
    void setUp() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
        birdDao = new BirdDao(factory);
        nestDao = new NestDao(factory);

        Nest roundNest1 = new RoundNest(1, 15);
        nestDao.saveNest(roundNest1);
        Bird blackbird1 = new Bird(BirdSpecies.BLACKBIRD, roundNest1);
        Bird blackbird2 = new Bird(BirdSpecies.BLACKBIRD, roundNest1);
        Bird blackbird3 = new Bird(BirdSpecies.BLACKBIRD, roundNest1);
        birdDao.saveBird(blackbird1);
        birdDao.saveBird(blackbird2);
        birdDao.saveBird(blackbird3);

        Nest roundNest2 = new RoundNest(4, 100);
        nestDao.saveNest(roundNest2);
        Bird stork1 = new Bird(BirdSpecies.STORK, roundNest2);
        Bird stork2 = new Bird(BirdSpecies.STORK, roundNest2);
        Bird stork3 = new Bird(BirdSpecies.STORK, roundNest2);
        birdDao.saveBird(stork1);
        birdDao.saveBird(stork2);
        birdDao.saveBird(stork3);

        Nest nestingBox = new NestingBox(1, 20, 25);
        nestDao.saveNest(nestingBox);
        Bird owl1 = new Bird(BirdSpecies.OWL, nestingBox);
        Bird owl2 = new Bird(BirdSpecies.OWL, nestingBox);
        Bird owl3 = new Bird(BirdSpecies.OWL, nestingBox);
        Bird owl4 = new Bird(BirdSpecies.OWL, nestingBox);
        birdDao.saveBird(owl1);
        birdDao.saveBird(owl2);
        birdDao.saveBird(owl3);
        birdDao.saveBird(owl4);

        Nest swallowNest = new SwallowNest(5, 275);
        nestDao.saveNest(swallowNest);
        Bird swallow1 = new Bird(BirdSpecies.SWALLOW, swallowNest);
        Bird swallow2 = new Bird(BirdSpecies.SWALLOW, swallowNest);
        birdDao.saveBird(swallow1);
        birdDao.saveBird(swallow2);
    }


}
