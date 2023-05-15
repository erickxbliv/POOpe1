package br.edu.ufca.ClassesDeDados;

//public class Jogador extends Pessoas implements Comparable<Jogador>{//para usar o método sort do
    //arraylist é necessário usar uma interface comparable

public class Jogador extends Pessoas implements Comparable<Jogador>{
    
    public int personalidade;
    private double score;
    private int ranking;        //o id so que do array de ranking
    private int vip = 0;

    public void transacao(double montante){     
        this.saldo += montante;
    }

    public void patrocinar(Jogador recebedor,double montante){ //Passa jogador e valor que vai dar para o jogador
        if(this.saldo > montante){
            recebedor.setSaldo(montante);
        }
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
    
/*
    @Override
    public int compareTo(Jogador pJogador){
        return (pJogador.getScore() - this.score)
    }
        
    } */
    
    public int compareTo(Jogador outroJogador){//pJogador é o jogador que foi passado como parâmetro
        if(this.score < outroJogador.getScore()){
            return -1;
        }else if(this.score > outroJogador.getScore()){
            return 1;
        }else{
            return 0;
        }
      }
}
