package com.astraride.timetableservice.dto;


import lombok.Data;

@Data
public class BusDto {
    private String busName;
    private String arrivalTime;
    private String departureTime;
    private String destination;
    private double price;

}
