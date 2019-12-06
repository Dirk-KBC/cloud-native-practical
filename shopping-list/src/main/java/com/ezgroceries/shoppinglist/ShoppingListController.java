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
    public ShoppingListResource post(@RequestBody ShoppingListCreationRequest requestBody) throws JsonProcessingException {

        //ObjectMapper objectMapper = new ObjectMapper();
        //ShoppingListCreationRequest request = objectMapper.readValue(requestBody, ShoppingListCreationRequest.class);
        ShoppingListCreationRequest request = requestBody;

        return new ShoppingListResource(request.getName());
    }

/*    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping// (value = "/shopping-lists/{id}/cocktails", produces = "application/json")
    public ShoppingListResource addCocktails(@RequestBody String requestBody) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        AddCocktailsRequest request = objectMapper.readValue(requestBody, AddCocktailsRequest.class);

        return new ShoppingListResource(request.getName());
    }*/
}