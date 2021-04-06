package br.com.alura;

import java.util.Iterator;
import java.util.Set;

public class TestaCursoComAluno {

    public static void main(String[] args) {
        Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

        javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com coleções", 22));

        Aluno a1 = new Aluno("Rodrigo Turini", 34672);
        Aluno a2 = new Aluno("Guilherme Silveira", 5617);
        Aluno a3 = new Aluno("Maurício Aninche", 17645);

        javaColecoes.matricula(a1);
        javaColecoes.matricula(a2);
        javaColecoes.matricula(a3);

        System.out.println("Todos os alunos matriculados: ");

        javaColecoes.getAlunos().forEach(a -> {
            System.out.println(a);
        });

        System.out.println(javaColecoes.estaMatriculado(a1)); //True

        Aluno turini = new Aluno("Rodrigo Turini", 34672);
        System.out.println(javaColecoes.estaMatriculado(turini)); //Retorna True por causa do HashCode

        System.out.println(a1.equals(turini)); //Retorna True por reescrever método equals


        Set<Aluno> alunos = javaColecoes.getAlunos();
        Iterator<Aluno> iterador = alunos.iterator();

        while ((iterador.hasNext())){
            Aluno proximo = iterador.next();
            System.out.println(proximo);
        }
    }
}
