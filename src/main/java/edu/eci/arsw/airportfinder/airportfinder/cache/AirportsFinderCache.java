package edu.eci.arsw.airportfinder.airportfinder.cache;


import edu.eci.arsw.airportfinder.airportfinder.cache.impl.Tuple;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AirportsFinderCache {
    private Map<String, Tuple<Timestamp, String>> storedRequests = new HashMap<String, Tuple<Timestamp, String>>();

    /**
     * This function return a stored requests
     * @param locationName the name of the location to get aiports from
     * @return the stored request if it exists (if it is less than 5 minutes old), if not, returns null
     */
    public String getStoredRequest(String locationName){
        clearOldRequest();
        synchronized (storedRequests){
            if(storedRequests.containsKey(locationName)){
                return storedRequests.get(locationName).getElem2();
            }
        }

        return null;
    }


    /**
     * This function stores a request
     * @param locationName the name of the location to get airports from
     * @param response the request to store
     */
    public void storeRequest(String locationName, String response){
        synchronized (storedRequests){
            storedRequests.put(locationName, new Tuple<>(new Timestamp(System.currentTimeMillis()),response));
        }
    }

    /**
     * this function removes every stored request that are more than 5 minutes old
     */
    private void clearOldRequest(){
        synchronized (storedRequests){
            for(Map.Entry<String, Tuple<Timestamp, String>> entry : storedRequests.entrySet()){
                if(entry.getValue().getElem1().getTime() + 1000 * 60 * 5 < new Timestamp(System.currentTimeMillis()).getTime()){
                    storedRequests.remove(entry.getValue());
                }
            }
        }

    }

}
