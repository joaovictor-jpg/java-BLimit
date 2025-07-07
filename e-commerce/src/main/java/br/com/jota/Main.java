package br.com.jota;

import br.com.jota.entidade.*;
import br.com.jota.repositorio.PedidoRepository;
import br.com.jota.repositorio.ProdutoRepository;
import br.com.jota.repositorio.UsuarioRepository;

import java.math.BigDecimal;

import static br.com.jota.entidade.enums.StatusPedido.CREATED;
import static br.com.jota.entidade.enums.Tipo.GERENDTE;
import static br.com.jota.entidade.enums.Tipo.USUARIO;

public class Main {
    public static void main(String[] args) {
        Endereco endereco1 = new Endereco("Rua A", "123", "Centro", "São Paulo", "SP", "01000-000");
        Endereco endereco2 = new Endereco("Rua B", "456", "Bairro B", "Rio de Janeiro", "RJ", "20000-000");

        Usuario joao = new Usuario("João Silva", "joao@email.com", "senha123", endereco1, GERENDTE);
        Usuario maria = new Usuario("Maria Oliveira", "maria@email.com", "minhaSenha456", endereco2, USUARIO);

        UsuarioRepository usuarioRepository = new UsuarioRepository();
        usuarioRepository.cadastrarUsuario(joao);
        usuarioRepository.cadastrarUsuario(maria);

        Produto produto1 = new Produto(new BigDecimal("89.90"), "Headset Gamer", 15);
        Produto produto2 = new Produto(new BigDecimal("29.50"), "Mousepad XXL", 50);

        ProdutoRepository produtoRepository = new ProdutoRepository();
        produtoRepository.adicionarProduto(produto1);
        produtoRepository.adicionarProduto(produto2);

        Carrinho carrinhoJoao = new Carrinho(joao);
        Carrinho carrinhoMaria = new Carrinho(maria);

        Pedido pedidoJoao = new Pedido(joao, CREATED);
        Pedido pedidoMaria = new Pedido(maria, CREATED);

        PedidoRepository pedidoRepository = new PedidoRepository();
        pedidoRepository.adicionarPedido(pedidoJoao);
        pedidoRepository.adicionarPedido(pedidoMaria);
    }
}