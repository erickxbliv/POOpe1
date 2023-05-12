package ClassesDeDados;
import java.util.Random;
import java.util.ArrayList;

public class Jogo {
    //não pode ter um score negativo, o mínimo é 0;

    private ArrayList<String> lista = new ArrayList<>();
    protected int MaxJogadores;
    protected ArrayList<String> ApostasDisponiveis;
    protected double TotalApostado;
    

    public void inicializar(){

        this.lista.add("Caca Niquel");
        this.lista.add("Roleta");

        return;
    }



    public int mostrar_biblioteca(){

        int tam;
        tam = this.lista.size();
        for(int i = 0; i < tam; i++){
            System.out.println((i+1) + " - " + this.lista.get(i));
        }
        
        return tam + 1;
    }


    public double Desktop(int escolha, double aposta){

        

        return 0.00;
    }
    

    public void CacaNiquel(){

        Random gerador = new Random(); 
        ArrayList<Integer> maquina = new ArrayList<>();
        int tamTela = 3;
        for(int i = 0; i < tamTela; i++){
            maquina.add(gerador.nextInt(3));
        }
        
        if((maquina.get(0) == maquina.get(1)) && (maquina.get(1) == maquina.get(2))){


        }
        



        return;
    }

   
   

  
    
}


/*

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

 */