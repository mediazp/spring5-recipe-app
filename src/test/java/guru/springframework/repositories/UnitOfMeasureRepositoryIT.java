/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeasure;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Vlad
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureRepositoryIT() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testFindByDescription() {
        System.out.println("findByDescription");
        String description = "Teaspoon";
        String expResult = "Teaspoon";
        Optional<UnitOfMeasure> result = unitOfMeasureRepository.findByDescription(description);
        assertEquals(expResult, result.get().getDescription());
    }

    @Test
    public void testFindByDescriptionCup() {
        System.out.println("findByDescription");
        String description = "Cup";
        String expResult = "Cup";
        Optional<UnitOfMeasure> result = unitOfMeasureRepository.findByDescription(description);
        assertEquals(expResult, result.get().getDescription());
    }

}
