package com.ezgroceries.shoppinglist;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "shopping_list")
public class ShoppingListEntity {

    private UUID id;
    private String name;

}