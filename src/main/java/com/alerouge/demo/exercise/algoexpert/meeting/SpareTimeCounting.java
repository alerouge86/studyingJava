package com.alerouge.demo.exercise.algoexpert.meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpareTimeCounting {
    private final List<String[]> calendar1;
    private final List<String[]> calendar2;
    private final String[] boundaries1;
    private final String[] boundaries2;
    private final boolean[] busyTimeArray;
    private final double minimumHoursForMeeting;
    private double biggestLowerBound;
    private double minimumUpperBound;

    public SpareTimeCounting(List<String[]> calendar1, List<String[]> calendar2, String[] boundaries1, String[] boundaries2, double minimumHoursForMeeting) {
        this.calendar1 = calendar1;
        this.calendar2 = calendar2;
        this.boundaries1 = boundaries1;
        this.boundaries2 = boundaries2;
        this.minimumHoursForMeeting = minimumHoursForMeeting;
        calculateSettingsData();
        int arraySize = (int) ((this.minimumUpperBound - this.biggestLowerBound) / minimumHoursForMeeting);
        this.busyTimeArray = new boolean[arraySize];
    }

    private void calculateSettingsData() {
        this.biggestLowerBound = getBoundaries(true);
        this.minimumUpperBound = getBoundaries(false);
    }

    public boolean[] getBusyTimeArray() {
        // elaborate calendar 1
        elaborateBusyTimeFromCalendar(this.calendar1);
        // elaborate calendar 2
        elaborateBusyTimeFromCalendar(this.calendar2);
        return this.busyTimeArray;
    }

    private void elaborateBusyTimeFromCalendar(List<String[]> calendar) {
        for (String[] meetingTime : calendar) {
            markBusyTime(meetingTime);
        }
    }

    private void markBusyTime(String[] meetingTime) {
        double startTime = convertTimeToDbl(meetingTime[0]);
        double endTime = convertTimeToDbl(meetingTime[1]);
        for (double index = startTime; index < endTime; index += 0.5) {

            // check indexes for the external boundary ranges
            if (index < this.biggestLowerBound || index >= this.minimumUpperBound) continue;

            double arrayIndexDbl = index - biggestLowerBound;
            if (arrayIndexDbl % 1 > 0) {
                // multiply only the whole part of number
                arrayIndexDbl = ((int) arrayIndexDbl) * 2;
                // increment to represent the second part of the hour (x:30 till x+1:00)
                arrayIndexDbl++;
            } else {
                arrayIndexDbl *= 2;
            }
            int arrayIndexInt = (int) arrayIndexDbl;
            busyTimeArray[arrayIndexInt] = true;
        }
    }

    private double getBoundaries(boolean lower) {
        int boundIndex = lower ? 0 : 1;
        double bound1 = convertTimeToDbl(boundaries1[boundIndex]);
        double bound2 = convertTimeToDbl(boundaries2[boundIndex]);
        boolean conditionBound1 = lower ? bound1 > bound2 : bound1 < bound2;
        return conditionBound1 ? bound1 : bound2;
    }

    private double convertTimeToDbl(String timeStr) {
        double partial = Integer.parseInt(timeStr.split(":")[0]);
        // if decimal > 0 --> add 0.5 (ex 10:30 -> 10.5)
        if (Integer.parseInt(timeStr.split(":")[1]) > 0) {
            partial += 0.5;
        }
        return partial;
    }

    public void printSpareTime() {
        List<String[]> spareTimeList = new ArrayList<>();
        boolean spareTimeRangeOpen = false;
        for (int index = 0; index < this.busyTimeArray.length; index++) {
            // checking if busy or spare time
            if (!this.busyTimeArray[index]) {
                // spare time here (if it's already open, skip to the next element)
                if (spareTimeRangeOpen) continue;

                // getting the start spare time
                String startSpareTime = getTimeFromIndex(index);
                spareTimeRangeOpen = true;
                spareTimeList.add(new String[]{startSpareTime, null});
            } else {
                if (spareTimeRangeOpen) {
                    // need to close the range spare time
                    String endSpareTime = getTimeFromIndex(index);
                    String[] spareTimeArrayTemp = spareTimeList.get(spareTimeList.size() - 1);
                    spareTimeArrayTemp[1] = endSpareTime;
                    spareTimeList.set(spareTimeList.size() - 1, spareTimeArrayTemp);
                    spareTimeRangeOpen = false;
                }
            }
        }
        if (spareTimeRangeOpen) {
            spareTimeList.remove(spareTimeList.size() - 1);
        }
        if (!spareTimeList.isEmpty()) {
            spareTimeList.forEach(this::printArray);
        }
    }

    private void printArray(String[] array) {
        Arrays.stream(array).forEach(element -> System.out.print(element + " "));
        System.out.println("");
    }

    private String getTimeFromIndex(int index) {
        double hoursDbl = (index * this.minimumHoursForMeeting) + this.biggestLowerBound;
        int hoursInt = (int) hoursDbl;
        String hoursStr = String.valueOf(hoursInt).length() == 2 ? String.valueOf(hoursInt) : "0" + hoursInt;
        String minutes = hoursDbl % 1.0 == 0.0 ? "00" : "30";
        return hoursStr.concat(":").concat(minutes);
    }
}
