package ClassesDeDados;

public class Pessoas {
    
    public String nome;    //nome da pessoa
    public int id;         //seu identificador entre seu tipo
    public String tipo;       //sua funcao no sistema
 
    protected int conta;      //a conta da pessoa
    protected double saldo = 0.0;   //o dinheiro disponivel na conta

    public int data_criacao;

    public void cadastro(int cpf){      //n sei como funciona isso mas seria como se o cadastro do perfil e da conta bancaria fosse separado
        this.conta = cpf;
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
