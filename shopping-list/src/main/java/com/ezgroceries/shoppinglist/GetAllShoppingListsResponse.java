package com.ezgroceries.shoppinglist;

import java.util.ArrayList;
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
public class GetAllShoppingListsResponse {

    private List<ShoppingList> shoppingListArray;

    public GetAllShoppingListsResponse() {
        this.shoppingListArray = new ArrayList<>();
    }

    public List<ShoppingList> getShoppingList() {
        return this.shoppingListArray;
    }

    public void setShoppingList(List<ShoppingList> shoppingList) {
        this.shoppingListArray = shoppingList;
    }

    public List<ShoppingList> addShoppingList (ShoppingList shoppingList) {
        this.shoppingListArray.add(shoppingList);
        return this.shoppingListArray;
    }
}

