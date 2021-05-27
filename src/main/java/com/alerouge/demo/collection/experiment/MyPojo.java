package com.alerouge.demo.collection.experiment;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class MyPojo {
    private String name;
    private int age;
    private String randomString;

    public MyPojo() {
        this.name = UUID.randomUUID().toString();
        this.age = ThreadLocalRandom.current().nextInt(18, 100);
    }

    @Override
    public String toString() {
        return "MyPojo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", randomString='" + randomString + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRandomString() {
        return randomString;
    }

    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }
}
