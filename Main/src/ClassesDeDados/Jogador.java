package ClassesDeDados;

public class Jogador extends Pessoas{

    int personalidade;
    private double score;









    void apostar (double aposta){
         if(aposta < this.saldo){
            saldo = saldo - aposta;  //deitar essa valor do saldo; Fazer o jogo receber a aposta
         }else{
            System.out.println("Você não tem esse valor para apostar \n");
         }
    }

   
    public int getScore(){
        int score = 0;
        return score;
    }

    private void setScore(double score){
        this.score = score;
    }

    //metodos gets e sets para pegar e dar valores a variaveis "private"
    void ganhar(double lucro, double aumentoScore){
        saldo = saldo + lucro;
        score = score + aumentoScore;
    };
    void perder(double perda, double perdaScore){
        saldo = saldo - perda;
        score = score - perdaScore;
    };

    public int getConta(){
        return conta;
    }//PARA PEGAR O NÚMERO DA CONTA PARA TRANSFERIR

    
    public void Jogadornentendiqueisso (String nome, int conta){
        //setNome(nome);
        //this.conta = QuantJogadores + 1;
    }



}
