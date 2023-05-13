package ClassesDeDados;             //mas..... Jogo e uma classe de funcoes.. n de dados
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
//import ClassesDeRepositorios.RepositorioJogador;

public class Jogo {
    //não pode ter um score negativo, o mínimo é 0;

    private ArrayList<String> lista = new ArrayList<>();
    //protected int MaxJogadores;
    //protected ArrayList<String> ApostasDisponiveis;
    //protected double TotalApostado;
    

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

        String NomeDoJogo = this.lista.get(escolha - 1);
        int multiplicador;
        double montante;
        if(NomeDoJogo.equals("Caca Niquel")){

            multiplicador = CacaNiquel();
            montante = multiplicador * aposta;
            return montante;
            
        }else if(NomeDoJogo.equals("Roleta")){



        }

        

        return 0.00;
    }
    

    public int CacaNiquel(){

        Random gerador = new Random(); 
        ArrayList<Integer> maquina = new ArrayList<>();
        int tamTela = 3;
        for(int i = 0; i < tamTela; i++){
            maquina.add(gerador.nextInt(3));
        }
        System.out.println("O resultado foi: " + maquina.get(0) + maquina.get(1) + maquina.get(2));
        
        if((maquina.get(0) == maquina.get(1)) && (maquina.get(1) == maquina.get(2))){
            System.out.println("Todos os numeros iguais! Bonus x9!");
            return 9;
        }else if((maquina.get(0) == maquina.get(1)) || (maquina.get(1) == maquina.get(2))
        || maquina.get(0) == maquina.get(2)){
            System.out.println("Dois valores iguais! Bonus x2!");
            return 2;
        }else{
            System.out.println("Infelizmente vc teve azar!");
            return -1;
        } 
        //Collections.sort(rank);
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