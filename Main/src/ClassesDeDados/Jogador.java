package ClassesDeDados;



//Anotação: FAZER OS CRUDS, Ranking, Score e Login
//PESQUISAR SOBRE UM OBJETO SER DONO DO OUTRO


public class Jogador {
    private String nome;
    private int conta;
    private double saldo;
    private double aposta;

    if(saldo < aposta){
        //apostar
    }

    //metodos gets e sets para pegar e dar valores a variaveis "private"
    void ganhar(double lucro){
        saldo = saldo + lucro;
    };
    void perder(double perda){
        saldo = saldo - perda;
    };

    String pegarNome(){
        return nome;
    }
    
    public String getNome(){
        return nome;
    }

    public String setNome(){
        return this.nome = nome;
    }

    public int getConta(){
        return conta;
    }

    public String setConta(){
        return this.conta = conta;
    } //PARA PEGAR O NÚMERO DA CONTA PARA TRANSFERIR


}