package com.example.Meuble.service;

import com.example.Meuble.entity.Furniture;
import com.example.Meuble.repository.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureService implements IFurnitureService {

    private FurnitureRepository furnitureRepository;

    @Autowired
    public FurnitureService(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    @Override
    public List<Furniture> getAllFurniture() {
        return furnitureRepository.findAll();
    }

    @Override
    public Furniture saveFurniture(Furniture furniture) {
        return furnitureRepository.save(furniture);
    }

    @Override
    public Furniture getFurnitureById(int id) {
        return furnitureRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteFurniture(Furniture furniture) {
        furnitureRepository.delete(furniture);
    }
}
