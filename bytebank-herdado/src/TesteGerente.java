public class TesteGerente {

    public static void main(String[] args) {
        Gerente gerente = new Gerente();
        gerente.setNome("Shelcia");
        gerente.setCpf("333.333.333-33");
        gerente.setSalario(5000.0);
        gerente.setSenha(2222);

        System.out.println(gerente.getNome());
        System.out.println(gerente.autentica(2222));
        System.out.println(gerente.getBonificacaco());
    }
}
