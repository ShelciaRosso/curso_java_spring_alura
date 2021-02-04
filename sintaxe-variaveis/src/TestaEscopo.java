public class TestaEscopo {

    public static void main(String[] args) {
        int idade = 20;
        int quantidadePessoas = 2;

        //boolean acompanhado = (quantidadePessoas >= 2);

        boolean acompanhado;

        //variável vazia, não compila
        //System.out.println(acompanhado);

        if (quantidadePessoas >= 2) {
            acompanhado = true;
        } else {
            acompanhado = false;
        }

        // (idade >= 18 || quantidadePessoas >= 2) comparação com "or"
        // (idade >= 18 && quantidadePessoas >= 2) comparação com "and"

        if (idade >= 18 && acompanhado) {
            System.out.println("Seja bem vindo");
        } else {
            System.out.println("Infelizmente você não pode entrar");
        }
    }
}
