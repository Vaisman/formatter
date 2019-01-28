package com.company.project.helpers;

import com.google.maps.GeoApiContext;
import com.google.maps.TimeZoneApi;
import com.google.maps.model.LatLng;

import java.util.Optional;
import java.util.TimeZone;
import java.util.function.Function;

public class LatLngHelper implements Function<LatLng, Optional<TimeZone>> {

    private static final String API_KEY = "AIzaSyC9t8okDgPjsnac_SuAj7gWpH2xFfnZdQA";
    private static final GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);

    @Override
    public Optional<TimeZone> apply(LatLng latLng) {
        Optional<TimeZone> timezone = Optional.empty();

        try {
            timezone = Optional.of(TimeZoneApi.getTimeZone(context, latLng).await());
        } catch (Exception e) {
            System.err.println("LatLngHelper error: " + e.getMessage());
        }

        return timezone;
    }
}
