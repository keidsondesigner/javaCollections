package com.company;

import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {
        //***** HashSet
        System.out.println("Crie um conjuto e adicione as notas: ");
        Set<Double> notas = new HashSet<Double>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas);
        System.out.println(notas.toString());

        // esperado que retorne true
        System.out.println("Confira se a nota 5 contem no conjuto de notas: " + notas.contains(5d));


        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        System.out.println("Exiba a soma de todas notas: ");
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while (iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("A soma de todas a s notas é: " + soma);

        System.out.println("Exiba a média das notas: " + (soma / notas.size()));

        System.out.println("Remova a nota 5.0");
        notas.remove(5d);
        System.out.println(notas);

        System.out.println("Remova as notas menores que 7");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            Double next1 = iterator1.next();
            if (next1 < 7) iterator1.remove();
        }
        System.out.println(notas);


        //***** LinkedHashSet
        System.out.println("Exiba todas as notas na ordem em que foram informadas: ");
        Set<Double> notasEnem = new LinkedHashSet<>();
        //Ou assim Set<Double> notasEnem = new LinkedHashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        notasEnem.add(7d);
        notasEnem.add(8.5);
        notasEnem.add(9.3);
        notasEnem.add(5d);
        notasEnem.add(7.5);
        System.out.println(notasEnem);

        //***** TreeSet
        System.out.println("Exiba todas as notas na ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notasEnem);
        System.out.println(notas3);

        System.out.println("Apague todas as notas do conjunto: ");
        notasEnem.clear();
        System.out.println(notasEnem);

        System.out.println(" COnfirma se o conjunto está vazio: " + notasEnem.isEmpty());



        /*Dadas as seguintes informações sobre minhas séries favoritas,

        crie um conjuntoeordene este conjunto exibindo:
        (nome genero tempo de episódio);


        Série1=Nome:got,genero:fantasia,tempo Episodio:60
        Série2=nome:dark,genero:drama,tempo Episodio:60
        Série3=nome:that'70s show,genero:comédia,tempo Episodio:25
         */


        System.out.println("Exiba as minhas series em ordem aleatória");
        Set<SeriesFavoritas> minhasSeries = new HashSet<>(){{
            add(new SeriesFavoritas( "got", "fantasia", 60 ));
            add(new SeriesFavoritas( "Hora de Aventura", "aventura", 60 ));
            add(new SeriesFavoritas( "Hora do Show", "aventura", 40 ));
            add(new SeriesFavoritas( "flash", "ação", 40 ));
            add(new SeriesFavoritas( "DBZ", "anime", 25 ));
        }};
        for (SeriesFavoritas serie : minhasSeries) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("Exiba as minhas series em ordem como foram inseridas");
        Set<SeriesFavoritas> minhasSeries2 = new LinkedHashSet<>(){{
            add(new SeriesFavoritas( "Got", "fantasia", 60 ));
            add(new SeriesFavoritas( "Hora de Aventura", "aventura", 60 ));
            add(new SeriesFavoritas( "Hora do Show", "aventura", 40 ));
            add(new SeriesFavoritas( "Flash", "ação", 40 ));
            add(new SeriesFavoritas( "DBZ", "anime", 25 ));
        }};
        for (SeriesFavoritas serie : minhasSeries2) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }


        //Comparable com -> implements Comparable
        System.out.println("Exiba as minhas series em ordem natural(por tempo de epsodio) e depois por genero: ");
        Set<SeriesFavoritas> minhasSeries3 = new TreeSet<>(minhasSeries2);
        for (SeriesFavoritas serie : minhasSeries3) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }
        // pode exibir assim tmb =>   System.out.println(minhasSeries3);



        System.out.println("Exiba as minhas series em ordem nome / genero / tempo de eps");
        Set<SeriesFavoritas> minhasSeries4 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhasSeries4.addAll(minhasSeries);
        for (SeriesFavoritas serie : minhasSeries4) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }
    }
}

//Criando um comparable com -> implements Comparable
class SeriesFavoritas implements Comparable<SeriesFavoritas>{
    private  String nome;
    private  String genero;
    private Integer tempoEpisodio;

    //Contrutor da class SeriesFavoritas
    public SeriesFavoritas(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }


    //Getter da class SeriesFavoritas
    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }


    //toString da da class SeriesFavoritas
    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }


    //Sobreescrever equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeriesFavoritas serie = (SeriesFavoritas) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    //Implementação do método Comparable
    @Override
    public int compareTo(SeriesFavoritas serie) {
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        if (tempoEpisodio != 0) {
            return tempoEpisodio;
        }
        return this.getGenero().compareTo(serie.getGenero());

    }
}


class ComparatorNomeGeneroTempoEpisodio implements Comparator<SeriesFavoritas> {

    @Override
    public int compare(SeriesFavoritas s1, SeriesFavoritas s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0){
            return nome;
        }

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) {
            return  genero;
        }
        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}