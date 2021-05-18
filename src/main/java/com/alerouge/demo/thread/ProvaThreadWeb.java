package com.alerouge.demo.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProvaThreadWeb {

    public static final String SITE1 = "https://www.gazzetta.it";
    public static final String SITE2 = "https://www.ansa.it/";
    public static final String SITE3 = "https://www.google.com/";
    public static final String SITE4 = "https://www.w3schools.com/java/";
    public static final String SITE5 = "https://www.tutorialrepublic.com/";

    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> sites = Arrays.asList(
                SITE1, SITE2, SITE3, SITE4, SITE5,
                SITE1, SITE2, SITE3, SITE4, SITE5,
                SITE1, SITE2, SITE3, SITE4, SITE5,
                SITE1, SITE2, SITE3, SITE4, SITE5
        );
        Instant mainStart = Instant.now();

        List<String> result = Collections.synchronizedList(new LinkedList<>());

// =========================================================================================================

//        sequentialExecution(sites);

        threadExecution(sites, result);

// =========================================================================================================
        Instant mainEnd = Instant.now();
        long mainDuration = Duration.between(mainStart, mainEnd).toMillis();
        System.out.println("mainDuration = " + mainDuration);

        System.out.println("Size List created: " + result.size());
    }

    private static void sequentialExecution(List<String> sites) {
        ProvaThreadWeb demo = new ProvaThreadWeb();
        sites.stream()
                .forEach(site -> demo.getContent(site));
    }

    private static void threadExecution(List<String> sites, List<String> result) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(sites.size());
        int nThreads = 8;
        ExecutorService service = Executors.newFixedThreadPool(nThreads);
        List<Thread> workers = sites.stream()
                .map(site -> new Thread(new WebPageReader(site, countDownLatch, result)))
                .collect(Collectors.toList());
        workers.forEach(Thread::start);
        service.shutdown();
        if (!service.isTerminated()) {
            System.out.println("not shutdown yet..");
            service.awaitTermination(1, TimeUnit.SECONDS);
        }
        countDownLatch.await();
    }

    public String getContent(String url) {
        Instant start = Instant.now();
        String content = null;
        try {
            String parseLine; /* variable definition *//* create objects */
            URL URL = new URL(url);
            BufferedReader br = new BufferedReader(new InputStreamReader(URL.openStream()));
            StringBuilder contentApp = new StringBuilder();
            while ((parseLine = br.readLine()) != null) {
                contentApp.append(parseLine);
            }
            br.close();
            content = contentApp.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Instant end = Instant.now();
            long duration = Duration.between(start, end).toMillis();
            System.out.println("website: " + url + " read in " + duration + " ms");
        }
        return content;
    }
}

class WebPageReader implements Runnable {
    private CountDownLatch countDownLatch;
    private String url;
    private List<String> result;

    public WebPageReader(String url, CountDownLatch countDownLatch, List<String> result) {
        this.countDownLatch = countDownLatch;
        this.url = url;
        this.result = result;
    }

    @Override
    public void run() {
        try {
            ProvaThreadWeb reader = new ProvaThreadWeb();
            String content = reader.getContent(this.url);
            this.result.add(content);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }

}
