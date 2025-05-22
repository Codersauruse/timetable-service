package com.astraride.timetableservice.controller;


import com.astraride.timetableservice.dto.BusDto;
import com.astraride.timetableservice.model.Bus;
import com.astraride.timetableservice.service.BusService;
import com.astraride.timetableservice.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bus")
public class timeTableController {

    @Autowired
    private BusService busService;

    @GetMapping("/getAllBusses")
    public ResponseEntity<StandardResponse> getAllBusses(
            @RequestParam String date,
            @RequestParam(required = false) String destination) {

        List<Bus> busList = busService.getAllBusses(date, destination);
        StandardResponse response = new StandardResponse(200, "Fetched all the available busses", busList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getBus/{id}")
    public ResponseEntity<StandardResponse> getBusById(@PathVariable  String id) {

        Bus bus = busService.getBusById(id);
        StandardResponse response = new StandardResponse(200, "bus fetched successfully", bus);
        return ResponseEntity.status(HttpStatus.OK).body(response);  // Use HttpStatus.OK (200)
    }

    @PostMapping("/saveBus")

    public ResponseEntity<StandardResponse> saveBus(@RequestBody  BusDto bus) {

        Bus savedBus = busService.saveBus(bus);
        StandardResponse response = new StandardResponse(200, "bus saved successfully", savedBus);
        return ResponseEntity.status(HttpStatus.OK).body(response);  // Use HttpStatus.OK (200)
    }



}
