package com.alerouge.demo.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
    public static void main(String[] args) {

        try {
            Model1 model1 = new Model1();
            model1.setCampo1("campo1");
            model1.setCampo2("campo2");

            Complete complete = new Complete();
            complete.setModel1(model1);
            complete.setCampo("campo");

            String result = new ObjectMapper().writeValueAsString(complete);
            System.out.println("result = " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
