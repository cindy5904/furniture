package com.example.Meuble.service;

import com.example.Meuble.entity.Furniture;

import java.util.List;

public interface IFurnitureService {
    List<Furniture> getAllFurniture();
    Furniture saveFurniture(Furniture furniture);
    Furniture getFurnitureById(int id);
    void deleteFurniture(Furniture furniture);
}
