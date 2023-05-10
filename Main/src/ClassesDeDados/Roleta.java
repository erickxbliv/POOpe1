package ClassesDeDados;
import java.util.Random;
import java.util.ArrayList;

//APAGUEI O CODIGO ANTIGO COM VETOR MAS ERICK PODE PEGAR NOS CÓDIGOS ANTIGOS
public class Roleta extends Jogo { //mudar pra CacaNiquel

   
    void roleta(int conta,double aposta){
        Random gerador = new Random(); 
        ArrayList<Integer> tela = new ArrayList<>();
        int tamTela = 3;
        for(int i=0; i < tamTela; i++){
            tela.add(gerador.nextInt(10));
        //tela.add(7);
      }
      
      int a = tela.get(0);
      int b = tela.get(1);
      int c = tela.get(2);
      if((a == b) && (b== c)){ // PRECISA DESSES PARENTESES
          System.out.println("PARABENS, VOCÊ GANHOU");
          
        }//PODEMOS COLOCAR PARA SE CONSEGUIR ALGUMA OUTRA SEQUENCIA GANHA OUTRO VALOR MENOR, TIPO SE CAIR SÓ NUMEROS PARES
        
    }
    
}
