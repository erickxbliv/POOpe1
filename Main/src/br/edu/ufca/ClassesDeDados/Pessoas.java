package br.edu.ufca.ClassesDeDados;
import java.util.Random;

public abstract class Pessoas implements IPessoas{
    
    public String nome;
    public int id;
    public int funcao;
 
    protected int conta;
    protected double saldo = 0.0;

    public int data_criacao;

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
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
        double saldo = gerador.nextInt(conta);
        setSaldo(saldo);
    }

    public int getConta(){
        return this.conta;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }





    public void depositar(double valor){

    }













    public void transacao(double montante){
        return;
    }
    public void patrocinar(Jogador recebedor,double montante){
        return;
    }
    public boolean tem_suficiente(double aposta){
        return false;
    }
    public double getScore(){
        return -1.0;
    }
    public void propina(double pacote){
        return;
    }
    public int compareTo(Jogador outroJogador){
        return -1;
    }
    public void setTaxaBonus(){
        return;
    }
    public void cheque(){
        return;
    }
}
