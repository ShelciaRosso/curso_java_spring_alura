public class TestaCondicional2 {

    public static void main(String[] args) {
        int idade = 20;
        int quantidadePessoas = 2;
        boolean acompanhado = (quantidadePessoas >= 2);

        // (idade >= 18 || quantidadePessoas >= 2) comparação com "or"
        // (idade >= 18 && quantidadePessoas >= 2) comparação com "and"

        if (idade >= 18 && acompanhado) {
            System.out.println("Seja bem vindo");
        } else {
            System.out.println("Infelizmente você não pode entrar");
        }
    }
}
