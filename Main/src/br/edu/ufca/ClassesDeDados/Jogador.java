package br.edu.ufca.ClassesDeDados;

public class Jogador extends Pessoas{
    
    public int personalidade;
    //protected double score;
    //protected int ranking;

    @Override
    public void transacao(double montante){     
        this.saldo += montante;
    }

    @Override
    public void patrocinar(Jogador recebedor,double montante){
        if(this.saldo > montante){
            recebedor.setSaldo(montante);
        }
    }

    @Override
    public boolean tem_suficiente(double aposta){

        if(this.getSaldo() < aposta) return false;
        else return true;
    }
   
    /* 
    @Override
    public double getScore(){
        return this.score;
    }
    private void setScore(double score){
        this.score = score;
    }
    */

    @Override
    public void propina(double pacote){
        return;
    }
    
}
