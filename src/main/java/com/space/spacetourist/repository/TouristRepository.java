package com.space.spacetourist.repository;




import com.space.spacetourist.entity.TouristEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TouristRepository extends JpaRepository<TouristEntity, Long> {


    TouristEntity findByTouristId(String touristId);

    List<TouristEntity> findAllByTouristId(TouristEntity touristEntity);



}
