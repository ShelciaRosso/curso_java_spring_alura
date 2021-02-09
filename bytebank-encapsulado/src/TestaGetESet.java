public class TestaGetESet {

    public static void main(String[] args) {
        Conta conta = new Conta(1,2);

        //conta.numero = 1337;
        //conta.setNumero(1337);

        System.out.println(conta.getNumero());

        Cliente shel = new Cliente();

        shel.setNome("Shelcia Rosso");

        //conta.titular = shel;
        conta.setTitular(shel);
        conta.getTitular().setProfissao("Programador");

        System.out.println(conta.getTitular().getNome());
    }
}
