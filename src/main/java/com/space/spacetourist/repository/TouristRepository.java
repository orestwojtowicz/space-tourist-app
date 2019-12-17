package com.space.spacetourist.repository;

import com.space.spacetourist.entities.TouristEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TouristRepository extends JpaRepository<TouristEntity, Long> {
}
