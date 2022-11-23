package com.alerouge.demo.exercise.algoexpert.meeting;

import java.util.List;

public class SpareTimeCountingBkp {
    final private List<String[]> calendar1;
    final private List<String[]> calendar2;
    final private String[] boundaries1;
    final private String[] boundaries2;
    final private boolean[] spareTimeArray;
    private int biggestLowerBound;
    private int minimumUpperBound;

    public SpareTimeCountingBkp(List<String[]> calendar1, List<String[]> calendar2, String[] boundaries1, String[] boundaries2) {
        this.calendar1 = calendar1;
        this.calendar2 = calendar2;
        this.boundaries1 = boundaries1;
        this.boundaries2 = boundaries2;
        calculateSettingsData();
        this.spareTimeArray = new boolean[this.minimumUpperBound - this.biggestLowerBound];
    }

    private void calculateSettingsData() {
        this.biggestLowerBound = getBoundaries(true);
        this.minimumUpperBound = getBoundaries(false);
    }

    public boolean[] getSpareTimeArray() {
        // elaborate calendar 1
        elaborateBusyTimeFromCalendar(this.calendar1);
        // elaborate calendar 2
        elaborateBusyTimeFromCalendar(this.calendar2);
        return this.spareTimeArray;
    }

    private void elaborateBusyTimeFromCalendar(List<String[]> calendar) {
        for (String[] meetingTime : calendar) {
            markBusyTime(meetingTime);
        }
    }

    private void markBusyTime(String[] meetingTime) {
        int startTime = convertTimeToInt(meetingTime[0]);
        int endTime = convertTimeToInt(meetingTime[1]);
        for (int index = startTime; index < endTime; index++) {
            int arrayIndex = index - biggestLowerBound;
            // check indexes for the external boundary ranges
            if (arrayIndex < 0 || arrayIndex >= spareTimeArray.length) continue;
            spareTimeArray[arrayIndex] = true;
        }
    }

    private int getBoundaries(boolean lower) {
        int boundIndex = lower ? 0 : 1;
        int bound1 = convertTimeToInt(boundaries1[boundIndex]);
        int bound2 = convertTimeToInt(boundaries2[boundIndex]);
        boolean conditionBound1 = lower ? bound1 > bound2 : bound1 < bound2;
        return conditionBound1 ? bound1 : bound2;
    }

    private int convertTimeToInt(String timeStr) {
        return Integer.parseInt(timeStr.split(":")[0]);
    }
}
