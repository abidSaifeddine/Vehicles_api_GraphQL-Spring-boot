package com.abidsaifeddin.vehiculesgraphql.Queries;

import com.abidsaifeddin.vehiculesgraphql.Models.Vehicle;
import com.abidsaifeddin.vehiculesgraphql.Services.VehicleService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleMutation implements GraphQLMutationResolver {
    @Autowired
    private VehicleService vehicleService;

    public Vehicle createVehicle(final String type, final String modelCode, final String brandName, final String launchDate) {
        return this.vehicleService.create(type, modelCode, brandName, launchDate);
    }

    public Vehicle updateVehicle(final int id, final String type, final String modelCode, final String brandName, final String launchDate) {
        return this.vehicleService.update(id, type, modelCode, brandName, launchDate);
    }

    public Vehicle deleteVehicle(final int id){
        return this.vehicleService.deleteVehicle(id).orElse(null);
    }
}
