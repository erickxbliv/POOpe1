package br.edu.ufca.ClassesDeTestes;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;


import java.util.Collections;       //?


public class IUJogo {
    //não pode ter um score negativo, o mínimo é 0;

    private ArrayList<String> lista = new ArrayList<>();
    
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
            return montante;                     //FAZER O SCORE RECEBER O RETURN * 500PTS2
            
            
        }else if(NomeDoJogo.equals("Roleta")){

            Scanner myObj = new Scanner(System.in);
            int selecao;

            do{
                System.out.println("Em que cor vc vai apostar? \n1 - vermelho \n2 - preto \n3 - branco \n4 - cancelar");
                selecao = myObj.nextInt();
            }while(selecao < 1 || selecao > 4);

            if(selecao == 4) return 0.0;
            multiplicador = Roleta(selecao);
            montante = multiplicador * aposta;
            return montante;

        }

        return 0.00;
    }

    public void Escritorio(int escolha){

        String NomeDoJogo = this.lista.get(escolha - 1);
        Scanner myObj = new Scanner(System.in);
        String resultado;

        if(NomeDoJogo.equals("Caca Niquel")){

            System.out.println("Digite 3 numeros entre 0 e 2: ");
            resultado = myObj.nextLine();
        }else if(NomeDoJogo.equals("Roleta")){

        }
    }


    public double Roleta(int selecao){

        ArrayList<String> cores = new ArrayList<>();
        cores.add("Vermelho");
        cores.add("Preto");
        cores.add("Branco");

        Random gerador = new Random();
        int resultado = gerador.nextInt(101);
        int cor;

        if(resultado == 50) cor = 3;
        else if((resultado % 2) == 0) cor = 1;
        else cor = 2;

        System.out.println("O resultado foi " + resultado + " " + cores.get(cor-1));

        if(selecao == cor){

            if(cor == 3){
                System.out.println("Parabens! sua chance era de 1%, entao Bonus x10!");
                return 10.0;
            }else{
                System.out.println("A probabilidade era de 1/2, e voce ganhou! lucro de 80%");
                return 0.80;
            }
        }

        System.out.println("Voce perdeu.. mais sorte na proxima!");
        return -1.0;
    }
    

    public double CacaNiquel(){

        Random gerador = new Random(); 
        ArrayList<Integer> maquina = new ArrayList<>();
        int tamTela = 3;
        for(int i = 0; i < tamTela; i++){
            maquina.add((gerador.nextInt(3) + 1));
        }
        System.out.println("O resultado foi: " + maquina.get(0) + maquina.get(1) + maquina.get(2));
        
        if((maquina.get(0) == maquina.get(1)) && (maquina.get(1) == maquina.get(2))){
            System.out.println("Todos os numeros iguais! Bonus x9!");
            return 9.0;
        }else if((maquina.get(0) == maquina.get(1)) || (maquina.get(1) == maquina.get(2))
        || maquina.get(0) == maquina.get(2)){
            System.out.println("Dois valores iguais! Lucro de 5%!");
            return 0.05;
        }else{
            System.out.println("Infelizmente vc teve azar, perdeu!");
            return -1.0;
        } 
    }



    public double minas(){

        return 0.0;
    }

    

}
