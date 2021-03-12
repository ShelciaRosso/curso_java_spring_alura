package br.com.bytebank.banco.modelo;

public class SeguroVida implements Tributavel{

    CalculadorImposto calculador;



    @Override
    public double getValorImposto() {
        return 42;
    }
}
