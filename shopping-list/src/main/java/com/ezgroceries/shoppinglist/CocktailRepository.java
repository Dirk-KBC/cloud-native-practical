package com.ezgroceries.shoppinglist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CocktailRepository extends CrudRepository<CocktailEntity, String> {

}