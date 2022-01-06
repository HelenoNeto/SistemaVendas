package Utilitarios;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/*
 * Para compilar este programa: javac Test126.java Para rodar este programa
 * (Windows): chcp 1252 java -cp . Test126 Para rodar este programa (Linux):
 * java -cp . Test126
 */
class Presidente {

    String nome;
    int inicio;
    int fim;

    public Presidente(String n, int i, int f) {
        nome = n;
        inicio = i;
        fim = f;
    }

    public String toString() {
        return nome + ": de " + inicio + " até " + fim;
    }
}

class ComparatorPresidente implements Comparator {

    boolean crescente = true;

    public ComparatorPresidente(boolean crescente) {
        this.crescente = crescente;
    }

    public int compare(Object o1, Object o2) {
        Presidente p1 = (Presidente) o1;
        Presidente p2 = (Presidente) o2;
        if (crescente) {
            return p1.inicio < p2.inicio ? -1 : (p1.inicio > p2.inicio ? +1 : 0);
        } else {
            return p1.inicio < p2.inicio ? +1 : (p1.inicio > p2.inicio ? -1 : 0);
        }
    }
}

class Test126 {

    public static void main(String[] args) {
        List teste = new ArrayList();
        teste.add(new Presidente("Luis Inacio", 2002, 2005));
        teste.add(new Presidente("Fernando Henrique", 1998, 2001));
        teste.add(new Presidente("Fernando Henrique", 1994, 1997));


        // Em ordem crescente do início do mandato
        Collections.sort(teste, new ComparatorPresidente(true));
        System.out.println(teste);

        // Obviamente se a lista já estiver ordenada, pode-se simplesmente
        // invertê-la:
        Collections.reverse(teste);

        // Em ordem decrescente do fim do mandato
        Collections.sort(teste, new ComparatorPresidente(false));
        System.out.println(teste);
    }
}