package com.alerouge.demo.stream.spliterator;

public class Article {
    private int id;
    private String name;
    private int copiesSold = 2;

//    public Article(String name) {
//        this.name = name;
//    }


    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCopiesSold() {
//        for (int a = 0; a < 1000; a++) {
        for (int a = 0; a < 5; a++) {
            int b = (a *2) + a;
            System.out.println("b = " + b);
        }
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }
}
