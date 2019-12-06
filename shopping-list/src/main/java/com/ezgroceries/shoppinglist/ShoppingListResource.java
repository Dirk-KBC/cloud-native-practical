package com.ezgroceries.shoppinglist;

import java.util.UUID;

public class ShoppingListResource {
    private UUID uuid;
    private String shoppingListName;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getShoppingListName() {
        return shoppingListName;
    }

    public void setShoppingListName(String shoppingListName) {
        this.shoppingListName = shoppingListName;
    }

    public ShoppingListResource(String shoppingListName) {
        this.shoppingListName = shoppingListName;
        this.uuid = UUID.randomUUID();
    }
}
