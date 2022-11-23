package com.alerouge.demo.exercise.algoexpert.meeting;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class SpareTimeCountingTest {

    @Test
    void givenTwoCalendars_thenReturnCorrectSpareTimeArray() {
        boolean _09 = false;
        boolean _09_3 = true;
        boolean _10 = false;
        boolean _10_3 = false;
        boolean _11 = true;
        boolean _11_3 = false;
        boolean _12 = false;
        boolean _12_3 = true;
        boolean _13 = true;
        boolean _13_3 = true;
        boolean _14 = true;
        boolean _14_3 = true;
        boolean _15 = true;
        boolean _15_3 = false;
        boolean _16 = false;
        boolean _16_3 = true;
        boolean _17 = true;
        boolean _17_3 = false;

        final boolean[] expected = {
                _09,
                _09_3,
                _10,
                _10_3,
                _11,
                _11_3,
                _12,
                _12_3,
                _13,
                _13_3,
                _14,
                _14_3,
                _15,
                _15_3,
                _16,
                _16_3,
                _17,
                _17_3
        };

        List<String[]> calendar1 = List.of(new String[]{"09:30", "10:00"}, new String[]{"12:30", "15:00"}, new String[]{"16:30", "17:30"});
        List<String[]> calendar2 = List.of(new String[]{"06:30", "08:00"}, new String[]{"11:00", "11:30"}, new String[]{"13:00", "15:30"}, new String[]{"18:00", "19:00"});
        String[] boundaries1 = {"09:00", "18:00"};
        String[] boundaries2 = {"06:00", "19:00"};
        double minimumHoursForMeeting = 0.5;    // half an hour

        SpareTimeCounting spareTimeCounting = new SpareTimeCounting(calendar1, calendar2, boundaries1, boundaries2, minimumHoursForMeeting);
        boolean[] resultBusyTimeArray = spareTimeCounting.getBusyTimeArray();

        spareTimeCounting.printSpareTime();

        assertThat(expected).isEqualTo(resultBusyTimeArray);
    }
}