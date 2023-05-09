import ClassesDeDados.Jogador;
import ClassesDeDados.Funcionario;
import ClassesDeDados.Pessoas;
import ClassesDeRepositorios.RepositorioUsuarios;

import java.util.Scanner;
import java.util.ArrayList;

public class Teste{         //classe de teste (Main)
    public static void main(String[] args){

        //ArrayList<Jogador> apostadores = new ArrayList<Jogador>();
        //ArrayList<Funcionario> trabalhadores = new ArrayList<Funcionario>();
        //apostadores = RepositorioUsuarios.InicializarMeusUsuarios();
        RepositorioUsuarios lista = new RepositorioUsuarios();
        lista.InicializarMeusUsuarios();
        
        
        Scanner myObj = new Scanner(System.in);

        boolean sucesso = true;
        Pessoas teste;

        while(sucesso){

            System.out.println("Bem vindo! O que você deseja? \n1- login \n2- cadastrar novo");
            String escolha = myObj.nextLine();

            if(escolha.equals("1")){

                System.out.print("Digite seu nome: ");
                String NomeDeUsuario = myObj.nextLine();
                System.out.println(lista.BuscarEstaPessoa(NomeDeUsuario));
                

            }else if(escolha.equals("2")){


            }else if(escolha.equals("3")){

                
            }

        }


        myObj.close();

        //receber dados de um usuario totalmente novo
        //dependendo do seu tipo salvar ele em um local diferente (grupos de dados)
        //dependendo da sua funcao mostrar opcoes diferentes de tarefas a executar
        //todas as funcoes sao automaticas e de apenas impressao da tela, retornando pras opcoes ou sair da conta
        //todas as funcoes lidam com indices aleatorios dos grupos de dados para serem os outros "humanos" das interacoes
        //esses outros humanos tambem sofrem as consequencias que foram mostradas para o usuario
        //salvar os dados no final para guardar o estado atual de cada execucao
        

    }










    
}