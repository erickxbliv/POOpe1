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
        
        cliente.nome = "Erick de Brito";
        cliente.id = 1;
        cliente.tipo = "Jogador";
        cliente.cadastro(1000);
        cliente.transacao(537.5);

        apostadores.add(cliente);

        cliente.nome = "Andre Castro";
        cliente.id = 2;
        cliente.tipo = "Jogador";
        cliente.cadastro(1001);
        cliente.transacao(1343.25);

        apostadores.add(cliente);

    }


    public boolean BuscarEstaPessoa(String NomeDeUsuario){

        int tam;
        tam = this.apostadores.size();

        for(int i = 0; i < tam; i++){
            System.out.println(this.apostadores.get(i).nome + " =? " + NomeDeUsuario);
            //if(this.apostadores.get(i).nome.equals(NomeDeUsuario)) return true;
        }

        return false;
    }

}