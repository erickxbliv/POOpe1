package br.edu.ufca.ClassesDeDados;

public class JogadorVip extends Jogador{

  private double TotalPago;
  private double taxaBonus;

  public void setTaxaBonus(){
    this.taxaBonus = (TotalPago / 1000);
	}

  @Override
  public void transacao(double montante){     
    this.saldo += (montante * taxaBonus);
  }

}
