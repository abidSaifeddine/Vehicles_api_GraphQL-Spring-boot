package com.abidsaifeddin.vehiculesgraphql.Services;

import com.abidsaifeddin.vehiculesgraphql.Models.Vehicle;
import com.abidsaifeddin.vehiculesgraphql.Repositories.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    private final VehicleRepository repository;


    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Vehicle create(final String type, final String modelCode, final String brandName, final String launchDate){
        final Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        vehicle.setBrandName(brandName);
        vehicle.setLaunchDate(LocalDate.parse(launchDate));
        return this.repository.save(vehicle);
    }

    @Transactional(readOnly = true)
    public List<Vehicle> findAll(int count){
        return this.repository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Vehicle> findById(int id){
        return this.repository.findById(id);
    }

    @Transactional
    public Optional<Vehicle> deleteVehicle(int id){
        return this.repository.deleteById(id);
    }

    @Transactional
    public Vehicle update(final int id, final String type, final String modelCode, final String brandName, final String launchDate){
        final Vehicle vehicle =
         this.repository.findById(id).orElse(null);
        assert vehicle != null;
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        vehicle.setBrandName(brandName);
        vehicle.setLaunchDate(LocalDate.parse(launchDate));
        return this.repository.save(vehicle);
    }

    @Transactional(readOnly = true)
    public List<Vehicle> findAll(){
        return this.repository.findAll();
    }



}
