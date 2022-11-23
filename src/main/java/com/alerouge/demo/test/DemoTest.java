package com.alerouge.demo.test;

public class DemoTest {
    public static void main(String[] args) {
        boolean cli = true;
        boolean mat = true;
        boolean cdc = true;


        String query = createWhere(cli, mat, cdc);

    }

    public static String createWhere(boolean cli, boolean mat, boolean cdc) {
        String strWhere = "";
        boolean eseguiControlliTipAut = !((cli && mat && cdc) || (!cli && !mat && !cdc));
        if (eseguiControlliTipAut) {
            if (cli && !mat && !cdc) {
                // solo cliente
                strWhere += "AND A382MA=''AND A382CD=''";
            } else if (cli && mat && !cdc) {
                // solo cliente e matricola
                strWhere += "AND A382CD=''";
            } else if (cli && !mat && cdc) {
                // solo cliente e cdc
                strWhere += "AND A382MA=''";
            } else if (!cli && mat && !cdc) {
                // solo matricola
                strWhere += "AND A382MA<>''";
            } else if (!cli && !mat && cdc) {
                // solo cdc
                strWhere += "AND A382CD<>''";
            }
        }


        return strWhere;
    }
}
