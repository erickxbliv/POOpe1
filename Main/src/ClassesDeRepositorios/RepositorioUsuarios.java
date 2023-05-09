package ClassesDeRepositorios;
import ClassesDeDados.Jogador;
import ClassesDeDados.Funcionario;
import java.util.ArrayList;

//import java.util.;

public class RepositorioUsuarios {

    private ArrayList<Jogador> apostadores;
    //private ArrayList<Funcionario> trabalhadores;


    public ArrayList<Jogador> InicializarMeusUsuarios(){

        this.apostadores = new ArrayList<Jogador>();
        preencher_teste(apostadores);

        return apostadores;
    }




    public void criar_usuario(){
    }



    protected void preencher_teste(ArrayList<Jogador> apostadores){

        Jogador cliente = new Jogador();
        Jogador cliente2 = new Jogador();
        
        cliente.nome = "Erick de Brito";
        cliente.id = 1;
        cliente.tipo = "Jogador";
        cliente.cadastro(1000);
        cliente.transacao(537.5);

        apostadores.add(cliente);

        cliente2.nome = "Andre Castro";
        cliente2.id = 2;
        cliente2.tipo = "Jogador";
        cliente2.cadastro(1001);
        cliente2.transacao(1343.25);

        apostadores.add(cliente2);

    }


    public Jogador BuscarEstaPessoa(String NomeDeUsuario){

        int tam;
        tam = this.apostadores.size();

        for(int i = 0; i < tam; i++){
            if(this.apostadores.get(i).nome.equals(NomeDeUsuario)) return this.apostadores.get(i);
        }

        return null;
    }

}