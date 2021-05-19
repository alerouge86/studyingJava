package com.alerouge.demo.thread;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Example with concurrentSkipListMap
 */
public class EventWindowSort {
    private ConcurrentSkipListMap<ZonedDateTime, String> events;

    public EventWindowSort() {
        this.events = new ConcurrentSkipListMap<>(
                Comparator.comparingLong(v -> v.toInstant().toEpochMilli())
        );
    }

    public void acceptEvent(Event event) {
        events.put(event.getEventTime(), event.getContent());
    }

    public ConcurrentNavigableMap<ZonedDateTime, String> getEventsFromLastMinute() {
        return this.events.tailMap(ZonedDateTime.now().minusMinutes(1));
    }

    public ConcurrentSkipListMap<ZonedDateTime, String> getEvents() {
        return events;
    }

}
