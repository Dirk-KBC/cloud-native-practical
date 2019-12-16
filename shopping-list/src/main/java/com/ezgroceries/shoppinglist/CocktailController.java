package com.ezgroceries.shoppinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/cocktails", produces = "application/json")
public class CocktailController {

    private CocktailDBClient cocktailDBClient;

    @Autowired
    public CocktailController(CocktailDBClient cocktailDBClient) {
        this.cocktailDBClient = cocktailDBClient;
    }

    @GetMapping
    public List<CocktailResource> get(@RequestParam String search) {
        return mapToResponse(this.cocktailDBClient.searchCocktails(search));
    }

    public List<CocktailResource> mapToResponse(CocktailDBResponse response) {
        List<CocktailResource> cocktailResourceList = new ArrayList<>();
        for (CocktailDBResponse.DrinkResource cocktailDBResponse: response.getDrinks()) {
            CocktailResource cocktailResource = new CocktailResource(
                    java.util.UUID.randomUUID(), //uuid
                    cocktailDBResponse.getStrDrink(), //name
                    cocktailDBResponse.getStrGlass(), // glass
                    cocktailDBResponse.getStrInstructions(), //desc
                    cocktailDBResponse.getStrDrinkThumb(), //picture location
                    cocktailDBResponse.getIngredients() // list of ingredients.
            );
            cocktailResourceList.add(cocktailResource);
        }
        return cocktailResourceList;
    }
}