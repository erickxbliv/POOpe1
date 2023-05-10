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

        //int data de hj
        RepositorioUsuarios lista = new RepositorioUsuarios();
        lista.InicializarMeusUsuarios();
        
        
        Scanner myObj = new Scanner(System.in);
        boolean sucesso = false;
        Pessoas teste = null;
        String NomeDeUsuario;

        while(!sucesso){

            System.out.println("Olá, parece que você não se identificou! O que você deseja? \n1- login \n2- cadastrar novo \n3 - fechar");
            String escolha = myObj.nextLine();

            if(escolha.equals("1")){

                System.out.print("\nDigite seu nome: ");
                NomeDeUsuario = myObj.nextLine();
                teste = lista.BuscarEstaPessoa(NomeDeUsuario);
                if(teste != null) sucesso = true;
                
            }else if(escolha.equals("2")){

                System.out.print("\nPara criar sua conta, e necessario possuir uma conta bancaria. Informe a seguir: ");
                int conta =  myObj.nextInt();
                String lixo = myObj.nextLine();
                System.out.print("Certo! Voce veio para a entrevista de emprego? Caso tenha, digite 'sim': ");
                String resposta = myObj.nextLine();

                System.out.print("Vamos criar sua conta! Qual vai ser o seu apelido aqui no Cassino? "); 
                do{ NomeDeUsuario = myObj.nextLine();
                }while(lista.criar_usuario(NomeDeUsuario,conta,resposta));

                //sucesso = true;           //n da pra encerrar tem q fazer o login
            }else if(escolha.equals("3")) return;


            System.out.print("\n");
        }

        System.out.println("Bem vindo!");

        myObj.close();




        //receber dados de um usuario totalmente novo
        //dependendo do seu tipo salvar ele em um local diferente (grupos de dados)
        //dependendo da sua funcao mostrar opcoes diferentes de tarefas a executar
        //todas as funcoes sao automaticas e de apenas impressao da tela, retornando pras opcoes ou sair da conta
        //todas as funcoes lidam com indices aleatorios dos grupos de dados para serem os outros "humanos" das interacoes
        //esses outros humanos tambem sofrem as consequencias que foram mostradas para o usuario
        //salvar os dados no final para guardar o estado atual de cada execucao
        

    }





    private void config_conta(){

        return;
    }




    
}