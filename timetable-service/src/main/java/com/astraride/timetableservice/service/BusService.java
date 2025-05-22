package com.astraride.timetableservice.service;

import com.astraride.timetableservice.dto.BusDto;
import com.astraride.timetableservice.model.Bus;

import java.util.List;

public interface BusService {
    List<Bus> getAllBusses(String date, String destination);

    Bus getBusById(String id);


    Bus saveBus(BusDto bus);
}
