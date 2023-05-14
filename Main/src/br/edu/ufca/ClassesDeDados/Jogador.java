package br.edu.ufca.ClassesDeDados;

//public class Jogador extends Pessoas implements Comparable<Jogador>{//para usar o método sort do
    //arraylist é necessário usar uma interface comparable

public class Jogador extends Pessoas{
    
    public int personalidade;
    private double score;
    private int ranking;        //o id so que do array de ranking
    private int vip = 0;


    public void transacao(double montante){     
        this.saldo += montante;
    }

    public boolean tem_suficiente(double aposta){

        if(this.getSaldo() < aposta) return false;
        else return true;
    }
   
    public double getScore(){
        return this.score;
    }

    private void setScore(double score){
        this.score = score;
    }

    //metodos gets e sets para pegar e dar valores a variaveis "private"
    

    public int compareTo(Jogador pJogador){//pJogador é o jogador que foi passado como parâmetro
        if(this.score < pJogador.getScore()){
            return -1;
        }else if(this.score > pJogador.getScore()){
            return 1;
        }else{
            return 0;
        }
    
        
    }
}
