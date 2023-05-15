package br.edu.ufca.ClassesDeDados;
import java.util.Random;

public abstract class Pessoas implements Comparable<Jogador> {
    
    public String nome;    //nome da pessoa
    public int id;         //seu identificador entre a populacao
    public int funcao;
 
    protected int conta;      //a conta da pessoa
    protected double saldo = 0.0;   //o dinheiro disponivel na conta

    public int data_criacao;

    public void setId(int id){
        this.id = id;
    }

    public int getFuncao(){
        return this.funcao;
    }

    public void setFuncao(int funcao){
        this.funcao = funcao;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public void setConta(int conta){
        this.conta = conta;

        Random gerador = new Random(); 
        double saldo = gerador.nextInt(conta);      //melhorar isso.. como fazer pra decidir o dinheiro na conta da pessoa?
        setSaldo(saldo);
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }





    public void depositar(double valor){

    }

}
