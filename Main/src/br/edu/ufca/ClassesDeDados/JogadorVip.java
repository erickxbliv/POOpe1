package br.edu.ufca.ClassesDeDados;
import java.util.Random;

public class JogadorVip extends Jogador{

  private double TotalPago = 0;
  private double TaxaBonus;

  @Override
  public void setConta(int conta){

    this.vip = true;
    this.conta = conta;

    Random gerador = new Random(); 
    double saldo = gerador.nextInt(conta);
    setSaldo(saldo);
}
  
  @Override
  public void propina(double pacote){

    this.saldo -= pacote;
    this.TotalPago += pacote;
    setTaxaBonus();         //pode chamar so assim ou precisa do 'this.'?

  }

  public void setTaxaBonus(){
    this.TaxaBonus = (TotalPago / 100000);    //a cada 1000 reais, 1% de bonus
	}

  @Override
  public void transacao(double montante){     
    this.saldo += montante + (montante * TaxaBonus);
  }

  private void setScore(double score){
    this.score = score;
  }

}
