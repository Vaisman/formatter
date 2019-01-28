package com.company.project;

import com.company.project.helpers.DateTimeHelper;
import com.company.project.helpers.LatLngHelper;
import com.google.maps.model.LatLng;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;

import java.util.Optional;
import java.util.TimeZone;
import java.util.function.Function;

class FormatterEngine {
    private static final String DELIMITER = ",";
    private static final String END_OF_LINE = "\n";

    private static Function<LatLng, Optional<TimeZone>> latLngHelper = new LatLngHelper();

    void formatFile(InputStream inputStream, OutputStream outputStream) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream))) {

            String line = null;
            while((line = bufferedReader.readLine()) != null) {
                String result = format(line, latLngHelper);
                bufferedWriter.write(result);
            }

        } catch (IOException e) {
            System.out.println("Stream error:" + e.getMessage());
        }
    }

    String format(String inputLine, Function<LatLng, Optional<TimeZone>> latLngToTimezone) {
        String[] split = inputLine.split(DELIMITER);

        String dateTime = split[0];
        Double latitude = Double.valueOf(split[1]);
        Double longitude = Double.valueOf(split[2]);
        LatLng latLng = new LatLng(latitude, longitude);

        Optional<TimeZone> timeZone = latLngToTimezone.apply(latLng);

        if (!timeZone.isPresent()) {
            return "Invalid input data: ".concat(latLng.toString());
        }

        LocalDateTime localDateTime = DateTimeHelper.getLocalDateFromUtc(dateTime);
        return inputLine
                .concat(DELIMITER)
                .concat(timeZone.get().getID())
                .concat(DELIMITER)
                .concat(DateTimeHelper.toFormattedString(localDateTime))
                .concat(END_OF_LINE);
    }
}
