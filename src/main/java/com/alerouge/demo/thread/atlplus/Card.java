package com.alerouge.demo.thread.atlplus;

public class Card {
    private String token;
    private String blurred;

    public Card(String token, String blurred) {
        this.token = token;
        this.blurred = blurred;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBlurred() {
        return blurred;
    }

    public void setBlurred(String blurred) {
        this.blurred = blurred;
    }
}
