package br.com.jota.repositorio;

import br.com.jota.entidade.Usuario;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public class UsuarioRepository {
    private List<Usuario> usuarios;

    public UsuarioRepository() {
        this.usuarios = new LinkedList<>();
    }

    public void cadastrarUsuario(Usuario usuario) {
        if (usuarios.contains(usuario))
            throw new IllegalArgumentException("Usuário já cadastrado");
        usuarios.add(usuario);
    }

    public void atualizarUsuario(UUID idUsuario, Usuario novoUsuario) {
        var velhoUsuario = buscarUsuarioPorId(idUsuario);
        velhoUsuario.atualizarDadosUsuario(novoUsuario);
        atualizarLista(velhoUsuario);
    }

    public void deletarUsuario(UUID idUsuario) {
        this.usuarios.removeIf(u -> u.getId().equals(idUsuario));
    }

    public void listaUsuarios() {
        System.out.println("Lista de usuário");
        usuarios.forEach(System.out::println);
    }

    public Optional<Usuario> login(String email, String senha) {
        var usuarioOptionalPorEmail = buscarPorEmail(email);

        if (usuarioOptionalPorEmail.isEmpty())
            return Optional.empty();

        if (!usuarioOptionalPorEmail.get().getSenha().equals(senha))
            return Optional.empty();

        return usuarioOptionalPorEmail;
    }

    private void atualizarLista(Usuario velhoUsuario) {
        int index = usuarios.indexOf(velhoUsuario);
        usuarios.set(index, velhoUsuario);
    }

    private Usuario buscarUsuarioPorId (UUID idUsuario) {
        var usuarioOptional = encontrarPrimeiroUsuarioPorCondicao(u -> u.getId().equals(idUsuario));
        if (usuarioOptional.isEmpty())
            throw new NullPointerException("Usuário não encontrado.");
        return usuarioOptional.get();
    }

    private Optional<Usuario> buscarPorEmail(String email) {
        return encontrarPrimeiroUsuarioPorCondicao(u -> u.getEmail().equals(email));
    }

    private Optional<Usuario> encontrarPrimeiroUsuarioPorCondicao(Predicate<Usuario> condicao) {
        return usuarios.stream().filter(condicao).findFirst();
    }
}
