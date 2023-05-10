package ClassesDeDados;
import java.util.Random;

public class Pessoas {
    
    public String nome;    //nome da pessoa
    public int id;         //seu identificador entre a populacao
    public String tipo;       //sua funcao no sistema
 
    protected int conta;      //a conta da pessoa
    protected double saldo = 0.0;   //o dinheiro disponivel na conta

    public int data_criacao;

    public void biometria_banco(int conta){
        this.conta = conta;

        Random gerador = new Random(); 
        double saldo = gerador.nextInt(conta);      //melhorar isso.. como fazer pra decidir o dinheiro na conta da pessoa?
        this.saldo = saldo;
        
    }

    public void depositar(double valor){

    }

    void creditar(int conta, int valor){
        if(valor>0){
            saldo = saldo + valor;
        }
    }


    public void transacao(double montante){     
        this.saldo += montante;
    }
    

}
