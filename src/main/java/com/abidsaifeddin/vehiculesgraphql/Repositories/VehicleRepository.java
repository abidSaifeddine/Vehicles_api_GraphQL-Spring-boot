package com.abidsaifeddin.vehiculesgraphql.Repositories;

import com.abidsaifeddin.vehiculesgraphql.Models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    Optional<Vehicle> deleteById(int id);
}
