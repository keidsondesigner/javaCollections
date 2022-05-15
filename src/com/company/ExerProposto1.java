package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExerProposto1 {
    public static void main(String[] args) {
        System.out.println("Crie uma lista que recebe a temperatuda média dos 6 primeiros meses");
        List<Temperatura> temperaturas = new ArrayList<Temperatura>(){{
            add(new Temperatura("Janeiro", 38.5));
            add(new Temperatura("Fevereiro", 34.5));
            add(new Temperatura("Março", 26.5));
            add(new Temperatura("Abril", 28.5));
            add(new Temperatura("Maio", 31.5));
            add(new Temperatura("Junho", 36.5));
        }};
        System.out.println(temperaturas);


    }
}


class Temperatura {
    private String mes;
    private Double temperatura;

    public Temperatura(String mes, Double temperatura) {
        this.mes = mes;
        this.temperatura = temperatura;
    }

    public String getMes() {
        return mes;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    @Override
    public String toString() {
        return "{" +
                "mes: '" + mes + '\'' +
                ", temperatura: " + temperatura +
                '}';
    }
}