package com.astraride.timetableservice.service.impl;

import com.astraride.timetableservice.dto.BusDto;
import com.astraride.timetableservice.model.Bus;
import com.astraride.timetableservice.repository.BusRepo;
import com.astraride.timetableservice.service.BusService;
import com.astraride.timetableservice.util.exceptions.NoDataFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusServiceIMPL implements BusService {

    @Autowired
    private BusRepo busRepo;
    @Override
    public List<Bus> getAllBusses(String date, String destination) {
        List<Bus> buses = (destination != null)? busRepo.findByDestinationIgnoreCase(destination):busRepo.findAll();
        List<Bus> availableBuses = buses.stream()
                .filter(bus -> !bus.getNotWorkingDays().contains(date))
                .collect(Collectors.toList());
        return availableBuses;
    }

    @Override
    public Bus getBusById(String id) {
        Optional<Bus> optionalBus = busRepo.findById(id);
        if(optionalBus.isEmpty()){
            throw new NoDataFoundException("invalid bus id. busses can't find");
        }
        return optionalBus.get();
    }

    @Override
    public Bus saveBus(BusDto bus) {
        Bus newBus = new Bus();
        newBus.setBusName(bus.getBusName());
        newBus.setArrivalTime(bus.getArrivalTime());
        newBus.setDepartureTime(bus.getDepartureTime());
        newBus.setDestination(bus.getDestination());
        newBus.setPrice(bus.getPrice());
        busRepo.save(newBus);
        return newBus;
    }


}
