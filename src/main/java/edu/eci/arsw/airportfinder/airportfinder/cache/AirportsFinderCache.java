package edu.eci.arsw.airportfinder.airportfinder.cache;

import edu.eci.arsw.airportfinder.airportfinder.blueprints.persistence.impl.Tuple;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AirportsFinderCache {
    private Map<String, Tuple<Timestamp, String>> storedRequests = new HashMap<String, Tuple<Timestamp, String>>();

    public String getStoredRequest(String locationName){
        clearOldRequest();
        if(storedRequests.containsKey(locationName)){
            return storedRequests.get(locationName).getElem2();
        }

        return null;
    }

    public void storeRequest(String locationName, String response){
        storedRequests.put(locationName, new Tuple<>(new Timestamp(System.currentTimeMillis()),response));
    }

    private void clearOldRequest(){
        for(Map.Entry<String, Tuple<Timestamp, String>> entry : storedRequests.entrySet()){
            if(entry.getValue().getElem1().getTime() + 1000 * 60 * 5 < new Timestamp(System.currentTimeMillis()).getTime()){
                storedRequests.remove(entry.getValue());
            }
        }
    }

}
