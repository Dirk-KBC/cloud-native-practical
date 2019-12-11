package com.ezgroceries.shoppinglist;

import java.util.List;

// {
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
public class ShoppingList {


    private String shoppingListId;
    private String name;
    private List<String> ingredients;

    public ShoppingList() {
    }

    public String getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(String shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}

