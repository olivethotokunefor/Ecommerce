package com.example.Ecommerce.Repositories;

import com.example.Ecommerce.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
