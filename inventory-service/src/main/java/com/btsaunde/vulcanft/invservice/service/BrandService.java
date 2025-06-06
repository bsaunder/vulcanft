package com.btsaunde.vulcanft.invservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btsaunde.vulcanft.invservice.model.Brand;
import com.btsaunde.vulcanft.invservice.repository.BrandRepository;

/**
 * Service layer that provides CRUD operations for {@link Brand} entities.
 */
@Service
public class BrandService {

    @Autowired
    private final BrandRepository brandRepository;

    /**
     * Constructs a new service with the given repository.
     *
     * @param brandRepository repository used to store brands
     */
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    /**
     * Retrieve all brands from the repository.
     *
     * @return list of brands
     */
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    /**
     * Find a brand by id.
     *
     * @param id brand identifier
     * @return optional brand
     */
    public Optional<Brand> getBrandById(Long id) {
        return brandRepository.findById(id);
    }

    /**
     * Persist a new brand.
     *
     * @param brand brand to store
     * @return saved brand
     */
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    /**
     * Update an existing brand.
     *
     * @param id    id of the brand to update
     * @param brand new brand values
     * @return updated brand if found
     */
    public Optional<Brand> updateBrand(Long id, Brand brand) {
        return brandRepository.findById(id).map(existingBrand -> {
            existingBrand.setName(brand.getName());
            // update other fields as needed
            return brandRepository.save(existingBrand);
        });
    }

    /**
     * Delete a brand by id.
     *
     * @param id brand identifier
     * @return {@code true} if deleted
     */
    public boolean deleteBrand(Long id) {
        if (brandRepository.existsById(id)) {
            brandRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
