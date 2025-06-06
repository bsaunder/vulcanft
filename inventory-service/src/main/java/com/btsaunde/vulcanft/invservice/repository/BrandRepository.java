package com.btsaunde.vulcanft.invservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.btsaunde.vulcanft.invservice.model.Brand;

/**
 * JPA repository for {@link Brand} entities.
 */
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
