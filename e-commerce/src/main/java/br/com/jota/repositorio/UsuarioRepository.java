package br.com.jota.repositorio;

import br.com.jota.entidade.Usuario;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

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

    private void atualizarLista(Usuario velhoUsuario) {
        int index = usuarios.indexOf(velhoUsuario);
        usuarios.set(index, velhoUsuario);
    }

    private Usuario buscarUsuarioPorId (UUID idUsuario) {
        var usuarioOptional = usuarios.stream().filter(u -> u.getId().equals(idUsuario)).findFirst();
        if (usuarioOptional.isEmpty())
            throw new NullPointerException("Usuário não encontrado.");
        return usuarioOptional.get();
    }

    public void listaUsuarios() {
        System.out.println("Lista de usuário");
        usuarios.forEach(System.out::println);
    }
}
