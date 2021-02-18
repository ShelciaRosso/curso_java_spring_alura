public class Administrador extends Funcionario implements Autenticavel{

    private AutenticacaoUtil util;

    public Administrador(){
        this.util = new AutenticacaoUtil();
    }

    public double getBonificacaco() {
        return 50;
    }

    @Override
    public void setSenha(int senha) {
        this.util.setSenha(senha);
    }

    @Override
    public boolean autentica(int senha) {
        return this.util.autentica(senha);
    }
}
