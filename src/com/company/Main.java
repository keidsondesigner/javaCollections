package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

	    // Métodos interface List
        System.out.println("Crie uma lista e adicione as sete notas: ");
        List<Double> notas = new ArrayList<Double>();
        notas.add(5.5);
        notas.add(3.5);
        notas.add(7.5);
        notas.add(8.5);

        System.out.println("A nota 7.5 tem a posição: " + notas.indexOf(7.5));
        System.out.println(notas);
        System.out.println(notas.toString());

        System.out.println("Adicone na lista a nota 8.0 na posição 4: ");
        notas.add(4, 8d);
        System.out.println(notas);

        System.out.println("Substitua a nota 5.5 pela nota 9.8: ");
        notas.set(0, 9.8);
        System.out.println(notas);

        System.out.println("Nota 7.5 existe em notas? " + notas.contains(7.5));

        System.out.println("Exiba todas as notas na ordem em que foram informados: ");
        for (Double nota : notas){
            System.out.println(nota);
        }

        System.out.println("Exiba a terceira nota: " + notas.get(2));

        System.out.println("Exiba a menor nota da lista: " + Collections.min(notas));

        System.out.println("Exiba a maor nota da lista: " + Collections.max(notas));

        System.out.println("Exiba a soma de todas as notas da lista: " );
        Iterator<Double> iterator = notas.iterator();
        Double somaNotas = 0d;
        while (iterator.hasNext()){
            Double next = iterator.next();
            somaNotas += next;
        }
        System.out.println("A soma de todas as notas é: " + somaNotas);

        System.out.println("Exiba a média das notas: " + (somaNotas/notas.size()));

        System.out.println("Remova a nota 3.5: ");
        notas.remove(3.5d);
        System.out.println(notas);

        System.out.println("Remova a nota da posição zero: ");
        notas.remove(0);
        System.out.println(notas);

        System.out.println("Remova as notas menores que 8.0: ");
        Iterator<Double> nota = notas.iterator();
        while (nota.hasNext()){
            Double next = nota.next();
            if(next < 8.0){
                nota.remove();
            }
        }
        System.out.println(notas);

        System.out.println("Apague toda a lista");
        notas.clear();
        System.out.println(notas);

        System.out.println("Confira se a lista está vazia: " + notas.isEmpty());


        List<String> nomes = new ArrayList<String>();
        nomes.add("Arthur");
        nomes.add("Karol");
        nomes.add("Luan");
        nomes.add("Leon");
        System.out.println(nomes);

    }
}
