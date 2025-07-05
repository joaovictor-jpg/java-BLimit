package br.com.jota;

import br.com.jota.entidade.Endereco;
import br.com.jota.entidade.Usuario;
import br.com.jota.repositorio.UsuarioRepository;

import static br.com.jota.entidade.enums.Tipo.USUARIO;

public class Main {
    public static void main(String[] args) {
        Usuario maria = new Usuario("Maria Silva", "maria.silva@outlook.com",
                "maria123", new Endereco("30140001", "Belo Horizonte", "Minas Gerais",
                "Avenida Afonso Pena", "1000", "Sala 501"), USUARIO);

        Usuario joao = new Usuario("João Oliveira", "joao.oliveira@yahoo.com",
                "j123456", new Endereco("01311000", "São Paulo", "São Paulo",
                "Avenida Paulista", "1500", "Conjunto 102"), USUARIO);

        Usuario ana = new Usuario("Ana Carolina", "ana.carol@gmail.com",
                "ana987", new Endereco("80060000", "Curitiba", "Paraná",
                "Rua das Flores", "250", "apto 303"), USUARIO);

        Usuario lucas = new Usuario("Lucas Pereira", "lucas.pereira@hotmail.com",
                "lucas2023", new Endereco("90010000", "Porto Alegre", "Rio Grande do Sul",
                "Rua da Praia", "75", "Casa 2"), USUARIO);

        Usuario juliana = new Usuario("Juliana Costa", "juliana.c@empresa.com.br",
                "ju#2024", new Endereco("40010010", "Salvador", "Bahia",
                "Avenida Sete de Setembro", "1200", "Bloco B, apt 401"), USUARIO);

        UsuarioRepository repository = new UsuarioRepository();
        repository.cadastrarUsuario(maria);
        repository.cadastrarUsuario(joao);
        repository.cadastrarUsuario(ana);
        repository.cadastrarUsuario(lucas);
        repository.cadastrarUsuario(juliana);

        repository.listaUsuarios();

        System.out.println();
        repository.deletarUsuario(lucas.getId());

        repository.listaUsuarios();
    }
}