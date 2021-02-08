public class TestaMetodo {

    public static void main(String[] args) {
        Conta conta = new Conta();

        conta.saldo = 100;
        conta.deposita(50);

        System.out.println(conta.saldo);

        boolean conseguiuRetirar = conta.saca(20);
        System.out.println(conta.saldo);
        System.out.println(conseguiuRetirar);

        Conta contaShel = new Conta();
        contaShel.deposita(1000);

        if(contaShel.transfere(300, conta)) {
            System.out.println("Transferido com sucesso!");
        } else{
            System.out.println("Saldo insuficiente!");
        }

    }
}
