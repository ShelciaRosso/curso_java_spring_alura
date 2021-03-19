package br.com.bytebank.banco.teste.util;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

import java.util.ArrayList;
import java.util.LinkedList;

public class TesteArrayListEquals {

    public static void main(String[] args) {
        //ArrayList<Conta> lista = new ArrayList<Conta>();
        LinkedList<Conta> lista = new LinkedList<Conta>();

        Conta cc = new ContaCorrente(22, 11);
        lista.add(cc);

        Conta cc2 = new ContaCorrente(22, 22);
        lista.add(cc2);

        Conta cc3 = new ContaCorrente(22, 22);

        boolean existe  = lista.contains(cc2);
        System.out.println(existe);

        for (Object oRef: lista) {
            System.out.println(oRef);
        }

        System.out.println(cc2.equals(cc3));
    }
}
