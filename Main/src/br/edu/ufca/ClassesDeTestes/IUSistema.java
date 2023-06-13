package br.edu.ufca.ClassesDeTestes;
import br.edu.ufca.ClassesDeDados.Jogador;
import br.edu.ufca.ClassesDeFachada.RepositorioPessoas;
import br.edu.ufca.ClassesDeExceções.*;

import java.util.Scanner;
import java.util.ArrayList;

public class IUSistema{
    public static void main(String[] args){

        double data;
        RepositorioPessoas publico = new RepositorioPessoas();
        publico.InicializarMeuRegistro();

        IUJogo Arcade = new IUJogo();
        Arcade.inicializar();
 

        
        Scanner myObj = new Scanner(System.in);
        boolean sucesso = false;
        
        String NomeDeUsuario = null;
        int conta;
        int funcao;
        String papel = null;

        while(!sucesso){

            System.out.println("Olá, parece que você não se identificou! O que você deseja? \n1 - login \n2 - cadastrar novo \n3 - fechar");
            String escolha = myObj.nextLine();
            
            if(escolha.equals("1")){

                System.out.print("\nDigite seu nome: ");
                NomeDeUsuario = myObj.nextLine();
                funcao = ContaExisteQualFuncao(NomeDeUsuario,publico);

            }else if(escolha.equals("2")){

                System.out.print("\nPara criar sua conta, e necessario possuir uma conta bancaria. Informe seus 6 digitos a seguir: ");
                do{ conta =  myObj.nextInt();
                }while(conta < 100000 || conta > 999999);
                String lixo = myObj.nextLine();

                System.out.print("Vamos criar sua conta! Qual vai ser o seu apelido aqui no Cassino? "); 
                do{ NomeDeUsuario = myObj.nextLine();
                }while(ContaExisteQualFuncao(NomeDeUsuario,publico) != -1);

                publico.criar_Jogador(NomeDeUsuario,conta);
                
                System.out.print("Voce veio para a entrevista de emprego? Se sim, digite '1': "); 
                do{ papel = myObj.nextLine();
                }while(papel == null);

                if(papel.equals("1")) funcao = 2;
                else funcao = 1;
            }else if(escolha.equals("3")) return;

            System.out.print("\n");
        }

        System.out.println("Bem vindo!");


        

        


        boolean sair = false;

        while(!sair){
            funcao = ContaExisteQualFuncao(NomeDeUsuario,publico);

            if(funcao == 1) sair = ElevadorClientes(NomeDeUsuario,publico,Arcade);
            else if(funcao == 2) sair = ElevadorFuncionarios(NomeDeUsuario,publico,Arcade);
            else if(funcao == 4) sair = ElevadorDeLuxo(NomeDeUsuario);
            else return;
        }

        return;
    }


    
    private static int ContaExisteQualFuncao(String NomeDeUsuario, RepositorioPessoas publico){

        int funcao = -1;
        funcao = publico.PessoaExiste(NomeDeUsuario);
        return funcao;
    }






    private static boolean ElevadorClientes(String NomeDeUsuario, RepositorioPessoas publico, IUJogo Arcade){

        boolean sair = false;
        String escolha;
        Scanner myObj = new Scanner(System.in);

        while(!sair){

            System.out.println("\nO que voce deseja " + NomeDeUsuario + "? \n1 - Jogar \n2 - configuracoes \n3 - fechar");
            escolha = myObj.nextLine();

            if(escolha.equals("1")){
                Jogar(NomeDeUsuario,publico,Arcade);


            }else if(escolha.equals("2")){
                sair = config_conta(NomeDeUsuario,publico);
                if(sair) return false;

            }else if(escolha.equals("3")) sair = true;
        }
        return true;
    }


    

    private static boolean ElevadorFuncionarios(String NomeDeUsuario, RepositorioPessoas publico, IUJogo Arcade){
        return true;
    }

    

    private static boolean ElevadorDeLuxo(String NomeDeUsuario){
        return true;
    }

    private static void Jogar(String NomeDeUsuario, RepositorioPessoas publico, IUJogo Arcade){

        Scanner myObj = new Scanner(System.in);
        IUJogo arcade = new IUJogo();

        int escolha;
        boolean sucesso = false;
        int total = 0;
        double aposta;

        while(!sucesso){

            System.out.println("\nDe qual jogo voce deseja participar?");
            total = Arcade.mostrar_biblioteca();
            System.out.println((total+1) + " - Voltar\n");
            escolha = myObj.nextInt();

            if(escolha == (total+1)) return;
            else{
                
                do{
                    aposta = 0.0;
                    System.out.print("\nQuanto vc deseja apostar em Reais? Utilize ',' para centavos, ok? R$ ");
                    try{
                        aposta = myObj.nextDouble();
                        publico.PodeArcar(NomeDeUsuario,aposta);
                    }catch(SaldoInsuficienteException ex){
                        System.out.println("Saldo Insuficiente pra esse valor!");
                    }catch(SemSaldoException ex){
                        System.out.println("Voce nao possui nenhum saldo disponivel!");
                    }catch(ValorInvalidoException ex){
                        System.out.println("Valor inserido e invalido, tente novamente.\n");
                    }
                }while(aposta == 0.0);
                publico.IniciarJogo(NomeDeUsuario,Arcade,escolha,aposta);
                sucesso = true;
            }
        }

        //myObj.close();
        return;
    }


    private static boolean config_conta(String NomeDeUsuario, RepositorioPessoas publico){

        int escolha;
        Scanner myObj = new Scanner(System.in);
        boolean sempre = true;
        double saldo_atual;
        int funcao = ContaExisteQualFuncao(NomeDeUsuario, publico);

        while(sempre){

            System.out.println("\nO que vc deseja fazer? \n1 - consultar saldo \n2 - matricula vip \n3 - Patrocinar um jogador");
            System.out.println("4 - apagar conta");
            if(funcao == 1) System.out.println("5 - Fazer entrevista de emprego");
            else if(funcao == 2) System.out.println("5 - Pedir demissão");
            System.out.println("6 - voltar");
            
            escolha = myObj.nextInt();

            if(escolha == 1){

                saldo_atual = publico.ConsultarSaldo(NomeDeUsuario);
                System.out.println("Seu saldo atual e: R$ " + saldo_atual);

            }else if(escolha == 2){

                boolean vip = publico.EVip(NomeDeUsuario);
                double matricula;
                if(!vip) publico.AtualizarFuncao(NomeDeUsuario,false);

                do{
                    System.out.print("\nVoce lucra 1% a mais a cada 1000 Reais pagos, quanto deseja pagar? Utilize ',' para centavos, ok? R$ ");
                   
                    matricula = 0.0;
                    try{
                        matricula = myObj.nextDouble();
                        publico.PodeArcar(NomeDeUsuario,matricula);
                    }catch(SaldoInsuficienteException ex){
                        System.out.println("Saldo Insuficiente pra esse valor!");
                    }catch(SemSaldoException ex){
                        System.out.println("Voce nao possui nenhum saldo disponivel!");
                        return true;
                    }catch(ValorInvalidoException ex){
                        System.out.println("Valor inserido e invalido, tente novamente.\n");
                        return true;
                    }
                }while(matricula == 0.0);
                
                publico.DarPropina(NomeDeUsuario,matricula);
                return true;
            }else if(escolha == 3){
                
                String destinatario;
                double investimento;

                do{
                    System.out.print("Qual o nome da pessoa que vai receber seu patrocinio? ");
                    destinatario = myObj.nextLine();
                }while(ContaExisteQualFuncao(destinatario,publico) == -1);

                do{
                    System.out.print("\nQuanto vc deseja investir em " + destinatario + "? Utilize ',' para centavos, ok? R$ ");
                    investimento = 0.0;
                    try{
                        investimento = myObj.nextDouble();
                        publico.PodeArcar(NomeDeUsuario,investimento);
                    }catch(SaldoInsuficienteException ex){
                        System.out.println("Saldo Insuficiente pra esse valor!");
                    }catch(SemSaldoException ex){
                        System.out.println("Voce nao possui nenhum saldo disponivel!");
                        return true;
                    }catch(ValorInvalidoException ex){
                        System.out.println("Valor inserido e invalido, tente novamente.\n");
                        return true;
                    }
                }while(investimento == 0.0);
                publico.XpatrocinarY(NomeDeUsuario,destinatario,investimento);
            
            }else if(escolha == 4){

                publico.Deletar(NomeDeUsuario);
                return true;
            }else if(escolha == 5){

                publico.AtualizarFuncao(NomeDeUsuario,true);
                return true;
            }else if(escolha == 6) return false;

        }

        return false;
    }

}