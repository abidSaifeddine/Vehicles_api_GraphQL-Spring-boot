package com.abidsaifeddin.vehiculesgraphql.Queries;

import com.abidsaifeddin.vehiculesgraphql.Models.Vehicle;
import com.abidsaifeddin.vehiculesgraphql.Services.VehicleService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class VehicleQuery implements GraphQLQueryResolver {
    @Autowired
    private VehicleService vehicleService;

    public List<Vehicle> getVehiclesLimit(final int count){
        return this.vehicleService.findAll(count);
    }

    public Optional<Vehicle> getVehicle(final int id) {
        return this.vehicleService.findById(id);
    }

    public List<Vehicle> getVehicles(){
        return this.vehicleService.findAll();
    }
}
