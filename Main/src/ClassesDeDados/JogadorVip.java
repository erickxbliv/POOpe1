package ClassesDeDados;

public class JogadorVip extends Jogador{

    private double taxaBonus = 0.3;


    public void getTaxaBonus(){
      this.saldo = saldo + (saldo * taxaBonus);
	  }

    
    
}
