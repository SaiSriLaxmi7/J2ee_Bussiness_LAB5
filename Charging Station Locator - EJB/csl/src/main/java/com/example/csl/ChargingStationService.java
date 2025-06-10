package com.example.csl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.model.ChargingStation;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Stateless;

@Stateless
public class ChargingStationService {

    private List<ChargingStation> stations;

    @PostConstruct
    public void init() {
        stations = new ArrayList<>();

        stations.add(new ChargingStation(1, "Bay Street EV", "Toronto, ON - Bay St & Bloor St", true, 100));
        stations.add(new ChargingStation(2, "Pearson Airport Supercharge", "Mississauga, ON - Airport Rd", true, 250));
        stations.add(new ChargingStation(3, "Downtown Core Plug", "Toronto, ON - University Ave", false, 150));
        stations.add(new ChargingStation(4, "Unionville ChargePoint", "Markham, ON - Main St", true, 120));
        stations.add(new ChargingStation(5, "Square One EV Hub", "Mississauga, ON - City Centre Dr", true, 200));
        stations.add(new ChargingStation(6, "Vaughan Eco Station", "Vaughan, ON - Rutherford Rd", false, 90));
        stations.add(new ChargingStation(7, "St. Lawrence Market Plug", "Toronto, ON - Front St E", true, 80));
        stations.add(new ChargingStation(8, "Ryerson Green Charge", "Toronto, ON - Gould St", false, 110));
        stations.add(new ChargingStation(9, "Humber Lakeshore Station", "Etobicoke, ON - Lake Shore Blvd W", true, 180));
        stations.add(new ChargingStation(10, "Leslieville Charge Spot", "Toronto, ON - Queen St E", true, 60));
        
    }

    public List<ChargingStation> getAllStations() {
        return stations;
    }

    public List<ChargingStation> getAvailableStations() {
        return stations.stream()
                .filter(ChargingStation::getAvailability)
                .collect(Collectors.toList());
    }

    public List<ChargingStation> getUnavailableStations() {
        return stations.stream()
                .filter(station -> !station.getAvailability())
                .collect(Collectors.toList());
    }
}
