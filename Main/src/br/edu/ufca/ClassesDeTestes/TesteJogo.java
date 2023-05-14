package br.edu.ufca.ClassesDeTestes;            //mas..... Jogo e uma classe de funcoes.. n de dados
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
//import ClassesDeRepositorios.RepositorioJogador;

public class TesteJogo {
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
        
        return tam;
    }


    public double Desktop(int escolha, double aposta){

        String NomeDoJogo = this.lista.get(escolha - 1);
        double multiplicador;
        double montante;
        if(NomeDoJogo.equals("Caca Niquel")){

            multiplicador = CacaNiquel();
            montante = multiplicador * aposta;
            return montante;
            
        }else if(NomeDoJogo.equals("Roleta")){



        }

        

        return 0.00;
    }
    

    public double CacaNiquel(){

        Random gerador = new Random(); 
        ArrayList<Integer> maquina = new ArrayList<>();
        int tamTela = 3;
        for(int i = 0; i < tamTela; i++){
            maquina.add(gerador.nextInt(3));
        }
        System.out.println("O resultado foi: " + maquina.get(0) + maquina.get(1) + maquina.get(2));
        
        if((maquina.get(0) == maquina.get(1)) && (maquina.get(1) == maquina.get(2))){
            System.out.println("Todos os numeros iguais! Bonus x9!");
            return 9.0;
        }else if((maquina.get(0) == maquina.get(1)) || (maquina.get(1) == maquina.get(2))
        || maquina.get(0) == maquina.get(2)){
            System.out.println("Dois valores iguais! Lucro de 5%!");
            return 1.05;
        }else{
            System.out.println("Infelizmente vc teve azar, perdeu!");
            return -1.0;
        } 
        //Collections.sort(rank);
    }

}
