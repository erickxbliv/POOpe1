package br.edu.ufca.ClassesDeDados;

public class Funcionario extends Pessoas{
    
    public int efetividade;
    public double salario_atual;

    @Override
    public void cheque(){

        this.saldo += this.salario_atual;

    }

}
