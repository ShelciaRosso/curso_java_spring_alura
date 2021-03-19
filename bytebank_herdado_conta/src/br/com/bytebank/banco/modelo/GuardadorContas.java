package br.com.bytebank.banco.modelo;

public class GuardadorContas {

    private Conta[] referencias;
    private int posicaoLivre;

    public GuardadorContas() {
        this.referencias = new Conta[10];
        this.posicaoLivre = 0;
    }

    public void adiciona(Conta ref) {
        this.referencias[this.posicaoLivre] = ref;
        this.posicaoLivre ++;
    }

    public int getQuantidadeElementos(){
        return this.posicaoLivre;
    }

    public Conta getReferencia(int posicao) {
        return this.referencias[posicao];
    }
}
