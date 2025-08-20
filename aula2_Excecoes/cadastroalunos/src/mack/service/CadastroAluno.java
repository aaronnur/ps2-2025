package mack.service;

import java.util.ArrayList;
import java.util.List;

import mack.exceptions.NomeInvalidoException;
import mack.exceptions.NotaInvalidaException;
import mack.model.Aluno;

public class CadastroAluno {
    private List<Aluno> alunos;

    public CadastroAluno(){
        this.alunos = new ArrayList<>();
    }

    public void cadastrar(String nome, double nota)throws NotaInvalidaException, NomeInvalidoException{
        if(nome == null || "".equals(nome)){
            throw new NomeInvalidoException();
        }
        if(nota <0 || nota >10)
            throw new NotaInvalidaException();

        this.cadastrar(new Aluno(nome, nota));
    }

    public void cadastrar(Aluno a){
        this.alunos.add(a);
    }

    public List<Aluno> getAlunos(){
        return this.alunos;
    }

    public double calcularMedia(){
        if (alunos.isEmpty()){
            return 0;
        }
        double soma = 0 ;
        for( Aluno a : alunos){
            soma += a.getNota();
        }
        return soma / alunos.size();
    }
    public double getMaiorNota(){
        if (alunos.isEmpty()){
            return 0;
        }
        double maior = alunos.get(0).getNota();

        for( Aluno a : alunos){
            if(a.getNota() > maior){
                    maior = a.getNota();
            }
        }
        return maior;
    }
    public double getMenorNota(){
        if (alunos.isEmpty()){
            return 0;
        }
        double menor = alunos.get(0).getNota();

        for( Aluno a : alunos){
            if(a.getNota() < menor){
                    menor = a.getNota();
            }
        }
        return menor;
    }

}