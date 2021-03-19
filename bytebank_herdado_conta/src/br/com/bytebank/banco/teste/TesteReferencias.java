package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.GuardadorContas;

public class TesteReferencias {

    public static void main(String[] args) {
        GuardadorContas guardador = new GuardadorContas();

        ContaCorrente conta = new ContaCorrente(22, 11);
        guardador.adiciona(conta);

        ContaCorrente conta2 = new ContaCorrente(33, 22);
        guardador.adiciona(conta2);

        int tamanho = guardador.getQuantidadeElementos();

        System.out.println(tamanho);

        Conta ref = guardador.getReferencia(0);
        System.out.println(ref.getNumero());
    }
}
