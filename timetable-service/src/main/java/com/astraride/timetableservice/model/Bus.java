package com.astraride.timetableservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("Bus")
public class Bus {
    @Id
    private String id;
    private String busName;
    private String arrivalTime;
    private String departureTime;
    private String destination;
    private double price;
    private String message;
    private List<String> notWorkingDays = new ArrayList<>();

}
