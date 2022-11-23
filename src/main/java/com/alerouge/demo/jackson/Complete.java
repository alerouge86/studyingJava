package com.alerouge.demo.jackson;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Complete {
    private String campo;
    @JsonUnwrapped
    private Model1 model1;

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public Model1 getModel1() {
        return model1;
    }

    public void setModel1(Model1 model1) {
        this.model1 = model1;
    }
}
