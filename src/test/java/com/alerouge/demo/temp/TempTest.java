package com.alerouge.demo.temp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TempTest {

    public String[] ricavaCognomeNome(String clientePax) {
        String[] cognomeNome = new String[2];
        if (clientePax.contains("/") && clientePax.split("/").length > 1){
            cognomeNome[0] = clientePax.split("/")[0];
            cognomeNome[1] = clientePax.split("/")[1];
        } else if (clientePax.contains(" ") && clientePax.split(" ").length > 1){
            int indexOf = clientePax.lastIndexOf(" ");
            cognomeNome[0] = clientePax.substring(0, indexOf);
            cognomeNome[1] = clientePax.substring(indexOf + 1);
        } else {
            cognomeNome[0] = clientePax;
            cognomeNome[1] = "";
        }
        return cognomeNome;
    }

    @Test
    void ricavaCognomeNome_conUnoSpazio() {
        final String clientePax = "Verdi Giuseppe";
        String[] cognomeNome = ricavaCognomeNome(clientePax);
        String cognome = cognomeNome[0];
        System.out.println("cognome = " + cognome);
        String nome = cognomeNome[1];
        System.out.println("nome = " + nome);
        assertEquals("Verdi", cognome);
        assertEquals("Giuseppe", nome);
    }

    @Test
    void ricavaCognomeNome_conUnoSlash() {
        final String clientePax = "DA RIN ZANCO/GIANNA";
        String[] cognomeNome = ricavaCognomeNome(clientePax);
        String cognome = cognomeNome[0];
        System.out.println("cognome = " + cognome);
        String nome = cognomeNome[1];
        System.out.println("nome = " + nome);

        assertEquals("DA RIN ZANCO", cognome);
        assertEquals("GIANNA", nome);
    }

    @Test
    void ricavaCognomeNome_conPiuSpazi() {
        final String clientePax = "DE ANGELIS ROBERTO";
        String[] cognomeNome = ricavaCognomeNome(clientePax);
        String cognome = cognomeNome[0];
        System.out.println("cognome = " + cognome);
        String nome = cognomeNome[1];
        System.out.println("nome = " + nome);

        assertEquals("DE ANGELIS", cognome);
        assertEquals("ROBERTO", nome);
    }

    @Test
    void ricavaCognomeNome_senzaSpaziSenzaSlash() {
        final String clientePax = "rossi";
        String[] cognomeNome = ricavaCognomeNome(clientePax);
        String cognome = cognomeNome[0];
        System.out.println("cognome = " + cognome);
        String nome = cognomeNome[1];
        System.out.println("nome = " + nome);

        assertEquals("rossi", cognome);
        assertEquals("", nome);
    }

}

