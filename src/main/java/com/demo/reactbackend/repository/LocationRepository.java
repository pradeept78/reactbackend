package com.demo.reactbackend.repository;

import com.demo.reactbackend.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {


}
