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
    public List<String> addCocktails(@PathVariable("id") String id, @RequestBody List<AddCocktailsRequest> requestBody) {
        List<AddCocktailsRequest> request = requestBody;
        List<String> cocktailIdList = new ArrayList<String>();
        List<String> response = new ArrayList<String>();

        // for each cocktail in the request, add it to the shoppingList with id "{id}"
        requestBody.forEach((cocktailId)->response.add(cocktailId.getCocktailId()));
     /*   for (String cocktailId : requestBody.getCocktailId()) {
            // TODO: add cocktail to an _existing_ shoppinglist with id = {id}
            // then, add the cocktailId to the response-object
            response.add(cocktailId);
        }*/

        return response;
    }


    // Request: GET http://localhost:8080/shopping-lists/eb18bb7c-61f3-4c9f-981c-55b1b8ee8915
    // Response: 200 OK
    //{
    //    "shoppingListId": "90689338-499a-4c49-af90-f1e73068ad4f",
    //    "name": "Stephanie's birthday",
    //    "ingredients": [
    //        "Tequila",
    //        "Triple sec",
    //        "Lime juice",
    //        "Salt",
    //        "Blue Curacao"
    //    ]
    //}

    @GetMapping(value = "/shopping-lists/{id}", produces = "application/json")
    public ShoppingListResponse getShoppingList(@PathVariable("id") String id) {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("Tequila");
        ingredients.add("Triple sec");
        ingredients.add("Lime juice");
        ingredients.add("Salt");
        ingredients.add("Blue Curacao");
        ShoppingListResponse response = new ShoppingListResponse();
        response.setShoppingListId(id);
        response.setName("Stephanie's birthday");
        response.setIngredients(ingredients);
        return response;
    }

    // GET http://localhost:8080/shopping-lists
    //```
    //Response:
    //```
    //200 OK
    //
    //[
    //    {
    //        "shoppingListId": "4ba92a46-1d1b-4e52-8e38-13cd56c7224c",
    //        "name": "Stephanie's birthday",
    //        "ingredients": [
    //            "Tequila",
    //            "Triple sec",
    //            "Lime juice",
    //            "Salt",
    //            "Blue Curacao"
    //        ]
    //    },
    //    {
    //        "shoppingListId": "6c7d09c2-8a25-4d54-a979-25ae779d2465",
    //        "name": "My Birthday",
    //        "ingredients": [
    //            "Tequila",
    //            "Triple sec",
    //            "Lime juice",
    //            "Salt",
    //            "Blue Curacao"
    //        ]
    //    }
    //]

    @GetMapping(value = "/shopping-lists", produces = "application/json")
    public GetAllShoppingListsResponse getShoppingLists() {
        // First: construct some dummy
        ShoppingList list1 = new ShoppingList();
        list1.setName("Stephanie's birthday");
        list1.setShoppingListId("4ba92a46-1d1b-4e52-8e38-13cd56c7224c");
        List<String> ingredients = new ArrayList<>();
        ingredients.add("Tequila");
        ingredients.add("Triple sec");
        ingredients.add("Lime juice");
        ingredients.add("Salt");
        ingredients.add("Blue Curacao");
        list1.setIngredients(ingredients);

        ShoppingList list2 = new ShoppingList();
        list2.setName("my birthday");
        list2.setShoppingListId("6c7d09c2-8a25-4d54-a979-25ae779d2465");
        ingredients = new ArrayList<>();
        ingredients.add("Tequila");
        ingredients.add("Triple sec");
        ingredients.add("Lime juice");
        ingredients.add("Salt");
        ingredients.add("Blue Curacao");
        list2.setIngredients(ingredients);

        // then: create and return response-object that contains all lists
        GetAllShoppingListsResponse response = new GetAllShoppingListsResponse();
        response.addShoppingList(list1);
        response.addShoppingList(list2);

        return response;
    }
}