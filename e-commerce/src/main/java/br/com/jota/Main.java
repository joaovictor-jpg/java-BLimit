package br.com.jota;

import br.com.jota.entidade.Endereco;
import br.com.jota.entidade.Usuario;
import br.com.jota.repositorio.UsuarioRepository;

import static br.com.jota.entidade.enums.Tipo.USUARIO;

public class Main {
    public static void main(String[] args) {
        Usuario joao = new Usuario("João Victor", "joaovictor@gmail.com",
                "123456", new Endereco("21240470", "Rio de Janeiro", "Rio de Janeiro",
                "Cristiano Machado", "661", "apt - 201"), USUARIO);

        UsuarioRepository repository = new UsuarioRepository();

        repository.cadastrarUsuario(joao);
    }
}