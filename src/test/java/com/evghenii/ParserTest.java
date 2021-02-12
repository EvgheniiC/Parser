package com.evghenii;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    private Parser parser;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void setUp() {
        parser = new Parser();
    }

    @Test
    public void parseAndDisplayNewTestWhenTomorrow() {

        final LocalDate now = LocalDate.of(2021, Month.FEBRUARY, 12);

        final Parser spy = Mockito.spy(parser);

        Mockito.when(spy.getRightNow()).thenReturn(now);

        spy.parseAndDisplayNew("25/10/10/10");

        assertEquals(systemOutRule.getLog(), "13.02.2021 01:10:10");
    }

    @Test
    public void parseAndDisplayNewTestWhenToday() {

        final LocalDate now = LocalDate.of(2021, Month.FEBRUARY, 12);

        final Parser spy = Mockito.spy(parser);

        Mockito.when(spy.getRightNow()).thenReturn(now);

        spy.parseAndDisplayNew("10/10/10/10");

        assertEquals(systemOutRule.getLog(), "12.02.2021 10:10:10");
    }
}