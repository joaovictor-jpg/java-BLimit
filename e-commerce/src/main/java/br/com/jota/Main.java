package br.com.jota;

import br.com.jota.entidade.Endereco;
import br.com.jota.entidade.Usuario;

import static br.com.jota.entidade.enums.Tipo.USUARIO;

public class Main {
    public static void main(String[] args) {
        Usuario joao = new Usuario("João Victor", "joaovictor@gmail.com",
                "123456", new Endereco("21240470", "Rio de Janeiro", "Rio de Janeiro",
                "Cristiano Machado", "661", "apt - 201"), USUARIO);

        System.out.println(joao);

        joao.alterarSenha("987654");

        System.out.println(joao);

        try {
            Usuario pedro = new Usuario("pedro", "pedro@gmail.com",
                    "12345", new Endereco("21240470", "Rio de Janeiro", "Rio de Janeiro",
                    "Cristiano Machado", "661", "apt - 201"), USUARIO);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Usuario pedro = new Usuario("Pedro", "pedro@gmail.com",
                "123456", new Endereco("21240470", "Rio de Janeiro", "Rio de Janeiro",
                "Cristiano Machado", "661", "apt - 201"), USUARIO);

        System.out.println(pedro);

        pedro.alterarSenha("98765");

        System.out.println(pedro);
    }
}