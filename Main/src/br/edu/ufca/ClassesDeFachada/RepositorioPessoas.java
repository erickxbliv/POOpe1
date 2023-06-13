package br.edu.ufca.ClassesDeFachada;

import br.edu.ufca.ClassesDeDados.Jogador;
import br.edu.ufca.ClassesDeDados.Funcionario;
import br.edu.ufca.ClassesDeDados.JogadorVip;
import br.edu.ufca.ClassesDeTestes.IUJogo;
import br.edu.ufca.ClassesDeDados.Pessoas;
import br.edu.ufca.ClassesDeExceções.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;


public class RepositorioPessoas {

    private ArrayList<Pessoas> clientes;


    public void InicializarMeuRegistro(){

        this.clientes = new ArrayList<Pessoas>();
        preencher_teste(clientes);

    }

    public boolean criar_Jogador(String NomeDeUsuario, int conta){

        Pessoas novo = new Jogador();
        novo = BuscarEstaPessoa(NomeDeUsuario);
        if(novo != null){
            System.out.println("\nPoxa, este apelido já está em uso, tente novamente.");
            return true;
        }

        novo = new Jogador();
        novo.setNome(NomeDeUsuario);
        novo.setId(this.clientes.size());
        novo.setFuncao(1);

        novo.setConta(conta);
        this.clientes.add(novo);


        return false;
    }

    protected void preencher_teste(ArrayList<Pessoas> populacao){

        Pessoas cliente = new Jogador();
        Pessoas cliente2 = new Jogador();
        Pessoas cliente3 = new Jogador();
        Pessoas cliente4 = new Jogador();

        String nome = "erick";
        
        cliente.setNome(nome);
        cliente.setId(1);
        cliente.setFuncao(1);
        cliente.setConta(563826);
        populacao.add(cliente);

        nome = "andre";

        cliente2.setNome(nome);
        cliente2.setId(2);
        cliente2.setFuncao(1);
        cliente2.setConta(519460);
        populacao.add(cliente2);

        nome = "a";

        cliente3.setNome(nome);
        cliente3.setId(3);
        cliente3.setFuncao(1);
        cliente3.setConta(671945);
        cliente3.setSaldo(10000.0);
        populacao.add(cliente3);

        nome = "1";

        cliente4.setNome(nome);
        cliente4.setId(4);
        cliente4.setFuncao(1);
        cliente4.setConta(678145);
        cliente4.setSaldo(100000000.12345);
        populacao.add(cliente4);
    }


    public Pessoas BuscarEstaPessoa(String NomeDeUsuario){

        int tam;
        tam = this.clientes.size();

        for(int i = 0; i < tam; i++){
            if((this.clientes.get(i).getNome()).equals(NomeDeUsuario)) return this.clientes.get(i);
        }
        return null;
    }

    public void XpatrocinarY(String X,String Y, double investimento){

        Pessoas enviar = new Jogador();
        enviar = BuscarEstaPessoa(X);
        enviar.transacao((investimento * -1));

        Pessoas receber = new Jogador();
        receber = BuscarEstaPessoa(Y);
        receber.transacao(investimento);

        return;
    }



    public int PessoaExiste(String NomeDeUsuario){

        int tam;
        tam = this.clientes.size();
        for(int i = 0; i < tam; i++){
            if((this.clientes.get(i).getNome()).equals(NomeDeUsuario)) return this.clientes.get(i).funcao;
        }
        return -1;
    }

    
    public boolean PodeArcar (String NomeDeUsuario, double aposta) throws SaldoInsuficienteException, SemSaldoException, ValorInvalidoException{

        Pessoas usuario = BuscarEstaPessoa(NomeDeUsuario);
        if(usuario.getSaldo() <= 0.0) throw new SemSaldoException();
        if(aposta <= 0.0) throw new ValorInvalidoException();
        boolean pode = usuario.tem_suficiente(aposta);
        if(!pode) throw new SaldoInsuficienteException();
        return pode;
    }

    public void IniciarJogo(String NomeDeUsuario, IUJogo Arcade, int escolha, double aposta){

        Pessoas usuario = new Jogador();
        usuario = BuscarEstaPessoa(NomeDeUsuario);

        double montante = Arcade.Desktop(escolha,aposta);
        usuario.transacao(montante);
        return;
    }

    
    public double ConsultarSaldo(String NomeDeUsuario){

        Pessoas usuario;
        double saldo = 0.0;
        usuario = BuscarEstaPessoa(NomeDeUsuario);
        if(usuario != null) saldo = usuario.getSaldo();
        return saldo;
    }

    public boolean EVip(String NomeDeUsuario){

        Pessoas usuario;
        usuario = BuscarEstaPessoa(NomeDeUsuario);
        return (usuario instanceof JogadorVip);
    }

    public void AtualizarFuncao(String NomeDeUsuario, boolean RH){

        Pessoas usuario;
        Pessoas novo;
        usuario = BuscarEstaPessoa(NomeDeUsuario);
        if(usuario instanceof Jogador){
            if(RH){
                novo = new Funcionario();
                novo.setFuncao(2);
            }else{
                novo = new JogadorVip();
                novo.setFuncao(1);
            }
        }else if(usuario instanceof Funcionario){
            novo = new Jogador();
            novo.setFuncao(1);
        }else return;

        novo.setNome(usuario.getNome());
        novo.setConta(usuario.getConta());
        Deletar(NomeDeUsuario);

        novo.setId(this.clientes.size());
        this.clientes.add(novo);
    }


    public void Deletar(String NomeDeusuario){

        Pessoas usuario = BuscarEstaPessoa(NomeDeusuario);
        int indice = usuario.getId();

        this.clientes.remove(indice-1);
        int tam = this.clientes.size();

        for(int i = indice; i < tam; i++){
            (this.clientes.get(i)).setId(i);
        }

        return;
    }


    public void DarPropina(String NomeDeUsuario, double propina){

        Pessoas usuario = BuscarEstaPessoa(NomeDeUsuario);

        if(!EVip(NomeDeUsuario)) return;
        usuario.propina(propina);
        return;
    }

}