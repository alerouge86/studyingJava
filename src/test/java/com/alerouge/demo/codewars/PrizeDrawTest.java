package com.alerouge.demo.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrizeDrawTest {
    @Test
    public void myTest() {

        String st = "William,Willaim,Ale,Vita";
        Integer[] we = new Integer[]{1, 1, 1, 1};
        assertEquals("Willaim", PrizeDraw.nthRank(st, we, 1));

//        String st = "Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin";
//        Integer[] we = new Integer[]{4, 2, 1, 4, 3, 1, 2};
//        assertEquals("Benjamin", PrizeDraw.nthRank(st, we, 4));

//
//        st = "Elijah,Chloe,Elizabeth,Matthew,Natalie,Jayden";
//        we = new Integer[]{1, 3, 5, 5, 3, 6};
//        assertEquals("Matthew", PrizeDraw.nthRank(st, we, 2));

    }


    @Test
    public void test() {
        System.out.println("Fixed Tests");

        String st = "Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin";
        Integer[] we = new Integer[]{4, 2, 1, 4, 3, 1, 2};
        assertEquals("Benjamin", PrizeDraw.nthRank(st, we, 4));

         st = "Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin";
         we = new Integer[]{4, 2, 1, 4, 3, 1, 2};
        assertEquals("Not enough participants", PrizeDraw.nthRank(st, we, 8));


        st = "";
        we = new Integer[]{4, 2, 1, 4, 3, 1, 2};
        assertEquals("No participants", PrizeDraw.nthRank(st, we, 4));


        st = "Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin";
        we = new Integer[]{4, 2, 1, 4, 3, 1, 2};
        assertEquals("Benjamin", PrizeDraw.nthRank(st, we, 4));


        st = "Elijah,Chloe,Elizabeth,Matthew,Natalie,Jayden";
        we = new Integer[]{1, 3, 5, 5, 3, 6};
        assertEquals("Matthew", PrizeDraw.nthRank(st, we, 2));
    }

}