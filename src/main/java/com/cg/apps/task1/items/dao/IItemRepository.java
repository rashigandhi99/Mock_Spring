package com.cg.apps.task1.items.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.apps.task1.items.entities.*;

public interface IItemRepository extends JpaRepository<Item, String>{

}