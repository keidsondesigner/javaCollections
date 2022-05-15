package com.company;

import java.util.*;

public class OrdenacaoList {
    public static void main(String[] args) {

        List<Gato> meusGatos = new ArrayList<Gato>(){{
            add(new Gato("Goku", 7, "preto"));
            add(new Gato("Logan", 6, "amarelo"));
            add(new Gato("Vegetto", 8, "branco"));
        }};
        System.out.println("Mostre os gatos na ordem de inserção");
        System.out.println(meusGatos);

        System.out.println("Mostre os gatos na ordem aleatória");
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);

        System.out.println("Mostre a ordem natural dos (nome) ");
        Collections.sort(meusGatos);
        System.out.println(meusGatos);

        System.out.println("Mostre a ordem dos nomes por idade");
        meusGatos.sort(new ComparatorIdade());
        System.out.println(meusGatos);

        System.out.println("Mostre a ordem por cor");
        meusGatos.sort(new ComparatorCor());
        System.out.println(meusGatos);

        System.out.println("Mostre a ordem dos gatos por nome, cor & idade");
        meusGatos.sort(new ComparatorNomeCorIdade());
        System.out.println(meusGatos);

    }
}

class  Gato implements Comparable<Gato>{
    private  String nome;
    private Integer idade;
    private String cor;

    //Esse é o Construtor da Class Gato
    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    //Covertendo para string com toString()
    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    // Comparable com método compareTo
    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

// comparaddo idade do tipo number
class  ComparatorIdade implements Comparator<Gato>{
    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

//comparando cores do tipo string
class  ComparatorCor implements Comparator<Gato>{

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

// comparando nome, cor & idade dos gatos
class  ComparatorNomeCorIdade implements  Comparator<Gato>{

    @Override
    public int compare(Gato g1, Gato g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) {
            return  nome;
        }

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (cor != 0) {
            return cor;
        }

        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}