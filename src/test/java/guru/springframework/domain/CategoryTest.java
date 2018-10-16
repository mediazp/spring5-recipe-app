/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.domain;

import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vlad
 */
public class CategoryTest {
    
    Category category;
    
    public CategoryTest() {
        category = new Category();
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        Long expResult = 41L;
        category.setId(expResult);
        Long result = category.getId();
        assertEquals(expResult, result);
    }

//    @Test
//    public void testGetDescription() {
//        System.out.println("getDescription");
//        Category instance = new Category();
//        String expResult = "";
//        String result = instance.getDescription();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetRecipes() {
//        System.out.println("getRecipes");
//        Category instance = new Category();
//        Set<Recipe> expResult = null;
//        Set<Recipe> result = instance.getRecipes();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

 
}
