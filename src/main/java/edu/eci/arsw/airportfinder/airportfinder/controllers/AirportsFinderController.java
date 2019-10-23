package edu.eci.arsw.airportfinder.airportfinder.controllers;


import edu.eci.arsw.airportfinder.airportfinder.services.AirportsFinderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Airports")
public class AirportsFinderController {

    @Autowired
    AirportsFinderServices airportService;

    /**
     * This function manages all GET requests made to "/Airports/{locationName}
     * @param locationName the location requested
     * @return the response
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{locationName}")
    public ResponseEntity<?> getAirports (@PathVariable String locationName){
        try{
            return new ResponseEntity<>(airportService.getAirports(locationName), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("NOK", HttpStatus.BAD_REQUEST);
        }
    }


}
