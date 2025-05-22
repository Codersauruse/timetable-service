package com.astraride.timetableservice.repository;

import com.astraride.timetableservice.model.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepo extends MongoRepository<Bus,String> {
    List<Bus> findByDestinationIgnoreCase(String destination);
}
