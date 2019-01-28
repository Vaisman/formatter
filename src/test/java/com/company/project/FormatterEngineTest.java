package com.company.project;

import static java.util.TimeZone.getTimeZone;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import java.time.ZoneId;
import java.util.Optional;
import java.util.function.Function;

import org.junit.Before;
import org.junit.Test;

public class FormatterEngineTest {
    private FormatterEngine formatterEngine;
    private Function function;

    @Before
    public void setUp() {
        function = mock(Function.class);
        formatterEngine = new FormatterEngine();
    }

    @Test
    public void formatTest() {
        stub(function.apply(any())).toReturn(Optional.of(getTimeZone(ZoneId.of("Pacific/Auckland"))));
        String result = formatterEngine.format("2013-07-10 02:52:49,-44.490947,171.220966", function);
        assertEquals("2013-07-10 02:52:49,-44.490947,171.220966,Pacific/Auckland,2013-07-10 14:52:49\n", result);
    }
}
