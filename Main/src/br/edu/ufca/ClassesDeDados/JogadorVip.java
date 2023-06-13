package br.edu.ufca.ClassesDeDados;
import java.util.Random;

public class JogadorVip extends Jogador{

  private double TotalPago = 0;
  private double TaxaBonus;

  @Override
  public void setConta(int conta){
    this.conta = conta;

    Random gerador = new Random(); 
    double saldo = gerador.nextInt(conta);
    setSaldo(saldo);
}
  
  @Override
  public void propina(double pacote){

    this.saldo -= pacote;
    this.TotalPago += pacote;
    setTaxaBonus();

  }

  public void setTaxaBonus(){
    this.TaxaBonus = (TotalPago / 100000);
	}

  @Override
  public void transacao(double montante){     
    this.saldo += montante + (montante * TaxaBonus);
  }

}
