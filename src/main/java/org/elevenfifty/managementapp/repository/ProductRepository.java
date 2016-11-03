package org.elevenfifty.managementapp.repository;

import org.elevenfifty.managementapp.beans.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Products, Integer> {

}


