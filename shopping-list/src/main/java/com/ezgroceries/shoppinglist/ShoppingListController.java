package com.ezgroceries.shoppinglist;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
public class ShoppingListController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    @RequestMapping(value = "/shopping-lists", produces = "application/json")
    public ShoppingListResource post(@RequestBody ShoppingListCreationRequest requestBody) {

        //ObjectMapper objectMapper = new ObjectMapper();
        //ShoppingListCreationRequest request = objectMapper.readValue(requestBody, ShoppingListCreationRequest.class);
        ShoppingListCreationRequest request = requestBody;

        return new ShoppingListResource(request.getName());
    }

    @PostMapping(value = "/shopping-lists/{id}/cocktails", produces = "application/json")
    public List<String> addCopcktails(@PathVariable("id") String id, @RequestBody List<AddCocktailsRequest> requestBody) {
        List<AddCocktailsRequest> request = requestBody;
        List<String> cocktailIdList = new ArrayList<String>();
        List<String> response = new ArrayList<String>();

        // for each cocktail in the request, add it to the shoppingList with id "{id}"
        requestBody.forEach((cocktailId)->response.add(cocktailId.toString()));
     /*   for (String cocktailId : requestBody.getCocktailId()) {
            // TODO: add cocktail to an _existing_ shoppinglist with id = {id}
            // then, add the cocktailId to the response-object
            response.add(cocktailId);
        }*/

        return response;
    }
}