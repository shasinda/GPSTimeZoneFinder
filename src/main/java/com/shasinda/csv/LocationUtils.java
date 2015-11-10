package com.shasinda.csv;

import com.google.maps.GeoApiContext;
import com.google.maps.PendingResult;
import com.google.maps.TimeZoneApi;
import com.google.maps.model.LatLng;

import java.util.TimeZone;

/**
 * Created by Shasinda on 11/08/2015.
 */
public class LocationUtils {

    private static final String APIKEY = "Use your own key here";
    private static GeoApiContext context = new GeoApiContext().setApiKey(APIKEY);

    /**
     * finds the timezone based on latitude and longitude
     */
    public static TimeZone findTimeZone(double latitude, double longitude) throws Exception {
        LatLng latLng = new LatLng(latitude, longitude);
        return TimeZoneApi.getTimeZone(context, latLng).await();
    }
}
