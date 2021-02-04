public class TestaIR {

    public static void main(String[] args) {

        double salario = 3300.0;
        double impostoRenda = 0.0;
        double deducao = 0.0;

        if (salario <= 2800.00) {
            impostoRenda = 7.50;
            deducao = 142.00;
        } else if (salario >= 2800.01 && salario <= 3751.00) {
            impostoRenda = 15.00;
            deducao = 350.00;
        } else if (salario >= 3751.01 && salario <= 4664.00){
            impostoRenda = 22.5;
            deducao = 636.0;
        }

        System.out.println("Seu percentual de Imposto de Renda é de " + impostoRenda + "% e seu valor a deduzir é de R$" + deducao);
    }
}