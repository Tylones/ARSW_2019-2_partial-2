package edu.eci.arsw.airportfinder.airportfinder.services;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import edu.eci.arsw.airportfinder.airportfinder.cache.AirportsFinderCache;
import edu.eci.arsw.airportfinder.airportfinder.exceptions.BadLocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AirportsFinderServices {

    @Autowired
    AirportsFinderCache cache;

    public String getAirports(String locationName) throws IOException, BadLocationException {
        String response = null;
        response = cache.getStoredRequest(locationName);
        if(response == null){
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text="+locationName)
                    .get()
                    .addHeader("x-rapidapi-host", "cometari-airportsfinder-v1.p.rapidapi.com")
                    .addHeader("x-rapidapi-key", "7985e66558msh4284297b171966dp10ddd9jsn2db136bdfb7b")
                    .build();

            Response res = client.newCall(request).execute();
            if(res.isSuccessful()){
                cache.storeRequest(locationName, res.body().string());
                return res.body().string();
            }else {
                throw new BadLocationException("Bad location");
            }
        }
        return response;
    }

}
