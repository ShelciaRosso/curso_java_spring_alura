public class TesteTributaveis {

    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente(222, 333);
        cc.deposita(100.0);
        System.out.println(cc.getValorImposto());

        SeguroVida sv = new SeguroVida();

        CalculadorImposto calculador = new CalculadorImposto();
        calculador.registra(cc);
        calculador.registra(sv);

        System.out.println(calculador.getTotalImposto());
    }
}
