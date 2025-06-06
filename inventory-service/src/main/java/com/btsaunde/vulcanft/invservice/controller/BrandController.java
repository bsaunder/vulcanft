package com.btsaunde.vulcanft.invservice.controller;

import com.btsaunde.vulcanft.invservice.model.Brand;
import com.btsaunde.vulcanft.invservice.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for CRUD operations on {@link com.btsaunde.vulcanft.invservice.model.Brand Brand} entities.
 */
@RestController
@RequestMapping("/api/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * Retrieve all known brands.
     *
     * @return list of brands
     */
    @GetMapping
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    /**
     * Retrieve a single brand by its identifier.
     *
     * @param id identifier of the brand
     * @return the brand or 404 if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Long id) {
        return brandService.getBrandById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Create a new brand.
     *
     * @param brand brand data
     * @return persisted brand
     */
    @PostMapping
    public Brand createBrand(@RequestBody Brand brand) {
        return brandService.createBrand(brand);
    }

    /**
     * Update an existing brand.
     *
     * @param id    identifier of the brand to update
     * @param brand new values for the brand
     * @return updated brand or 404 if the brand does not exist
     */
    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @RequestBody Brand brand) {
        return brandService.updateBrand(id, brand)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Delete a brand by identifier.
     *
     * @param id identifier of the brand
     * @return 204 if deleted or 404 otherwise
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
        if (brandService.deleteBrand(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
