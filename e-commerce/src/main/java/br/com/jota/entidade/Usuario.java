package br.com.jota.entidade;

import br.com.jota.entidade.enums.Tipo;

import java.util.Objects;
import java.util.UUID;

public class Usuario {
    private UUID id;
    private String nome;
    private String email;
    private String senha;
    private Endereco endereco;
    private Tipo tipo;

    public Usuario(String nome, String email, String senha, Endereco endereco, Tipo tipo) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
        this.senha = this.validaSenha(senha);
        this.endereco = endereco;
        this.tipo = tipo;
    }

    public void atualizarDadosUsuario(Usuario novosDadosDaUsuario) {
        if (novosDadosDaUsuario.getNome() != null) {
            this.nome = novosDadosDaUsuario.getNome();
        }
        if (novosDadosDaUsuario.getEmail() != null) {
            this.email = novosDadosDaUsuario.getEmail();
        }
        if (novosDadosDaUsuario.getSenha() != null) {
            this.senha = validaSenha(novosDadosDaUsuario.getSenha());
        }
        if (novosDadosDaUsuario.getTipo() != null) {
            this.tipo = novosDadosDaUsuario.getTipo();
        }
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void alterarSenha(String senha) {
        this.senha = validaSenha(senha);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", endereco=" + endereco +
                ", tipo=" + tipo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    private String validaSenha(String senha) {
        if (senha.length() < 6)
            throw new IllegalArgumentException("A senha deve conter pelo menos 6 caracteres.");

        return senha;
    }
}
