/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

/**
 *
 * @author Vlad
 */
public class IndexControllerTest {
    
    IndexController instance = null;
    @Mock
    private RecipeService recipeService;
    @Mock
    private Model model;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        instance=new IndexController(recipeService);
    }
    
    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(instance).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    public void testGetIndexPage() {
        System.out.println("getIndexPage");
        String expResult = "index";
        //given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipes.add(recipe);
        Mockito.when(recipeService.getRecipes()).thenReturn(recipes);
        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
        //when
        String result = instance.getIndexPage(model);
        
        //then
        assertEquals(expResult, result);
        Mockito.verify(recipeService, Mockito.times(1)).getRecipes();
        Mockito.verify(model, Mockito.times(1)).addAttribute(ArgumentMatchers.eq("recipes"), ArgumentMatchers.anySet());
        Mockito.verify(model, Mockito.times(1)).addAttribute(ArgumentMatchers.anyString(), argumentCaptor.capture());
        Set<Recipe> setInCotroller = argumentCaptor.getValue();
        assertEquals(2, setInCotroller.size());
    }
    
}
