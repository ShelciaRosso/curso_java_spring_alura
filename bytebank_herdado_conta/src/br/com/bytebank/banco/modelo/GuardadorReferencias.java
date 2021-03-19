package br.com.bytebank.banco.modelo;

public class GuardadorReferencias {

    private Object referencias[];
    private int posicaoLivre;

    public GuardadorReferencias(){
        this.referencias = new Object[10];
        this.posicaoLivre = 0;
    }

    public void adiciona (Object ref) {
        this.referencias[this.posicaoLivre] = ref;
        this.posicaoLivre ++;
    }

    public int getQuantidadeElementos(){
        return this.posicaoLivre;
    }

    public Object getReferencia(int posicao) {
        return this.referencias[posicao];
    }
}
