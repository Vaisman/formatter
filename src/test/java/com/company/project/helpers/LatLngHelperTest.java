package com.company.project.helpers;

import static org.junit.Assert.assertFalse;

import java.util.Optional;
import java.util.TimeZone;

import org.junit.Test;

import com.google.maps.model.LatLng;

public class LatLngHelperTest {

    @Test
    public void applyEmptyTest() {
        LatLng latLng = new LatLng(1, 1);
        LatLngHelper helper = new LatLngHelper();
        Optional<TimeZone> result = helper.apply(latLng);
        assertFalse(result.isPresent());
    }
}
