package com.btsaunde.vulcanft.invservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btsaunde.vulcanft.invservice.model.Brand;
import com.btsaunde.vulcanft.invservice.repository.BrandRepository;

@Service
public class BrandService {

    @Autowired
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Optional<Brand> getBrandById(Long id) {
        return brandRepository.findById(id);
    }

    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public Optional<Brand> updateBrand(Long id, Brand brand) {
        return brandRepository.findById(id).map(existingBrand -> {
            existingBrand.setName(brand.getName());
            // update other fields as needed
            return brandRepository.save(existingBrand);
        });
    }

    public boolean deleteBrand(Long id) {
        if (brandRepository.existsById(id)) {
            brandRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
