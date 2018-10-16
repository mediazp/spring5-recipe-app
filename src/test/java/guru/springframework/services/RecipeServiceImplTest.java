/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Vlad
 */
public class RecipeServiceImplTest {
    
    RecipeServiceImpl recipeService;
    
    @Mock
    RecipeRepository recipeRepository;
    
    public RecipeServiceImplTest() {
    }
    
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void testGetRecipes() {
        System.out.println("getRecipes");
        Recipe recipe = new Recipe();
        Set<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);
        Mockito.when(recipeService.getRecipes()).thenReturn(recipeData);
//        Set<Recipe> expResult = null;
        Set<Recipe> result = recipeService.getRecipes();
        assertEquals(1, result.size());
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll();
    }
    
}
