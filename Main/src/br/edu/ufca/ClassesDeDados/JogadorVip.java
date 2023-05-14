package br.edu.ufca.ClassesDeDados;

public class JogadorVip extends Jogador{

  private double TotalPago = 0;
  private double TaxaBonus;

  public void propina(double pacote){

    this.saldo -= pacote;
    this.TotalPago += pacote;
    setTaxaBonus();         //pode chamar so assim ou precisa do 'this.'?

  }

  public void setTaxaBonus(){
    this.TaxaBonus = (TotalPago / 1000);
	}

  @Override
  public void transacao(double montante){     
    this.saldo += (montante * TaxaBonus);
  }

}
