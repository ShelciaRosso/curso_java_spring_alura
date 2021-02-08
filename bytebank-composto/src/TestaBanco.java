public class TestaBanco {

    public static void main(String[] args) {
        Cliente shel = new Cliente();

        shel.nome = "Shelcia Rosso";
        shel.cpf = "222.222.222-22";
        shel.profissao = "Programado";

        Conta contaDaShel = new Conta();
        contaDaShel.deposita(100);

        contaDaShel.titular = shel;
        System.out.println(contaDaShel.titular.nome);
    }
}
