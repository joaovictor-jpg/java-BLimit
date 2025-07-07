package br.com.jota.repositorio;

import br.com.jota.entidade.Carrinho;
import br.com.jota.entidade.Pedido;
import br.com.jota.entidade.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class PedidoRepository {
    private final List<Pedido> pedidos;

    public PedidoRepository() {
        this.pedidos = new ArrayList<>();
    }

    public void listarProdutos(UUID idUsuario) {
        System.out.println("--- Lista de Produtos ----");
        var pedidoOptional = pedidos.stream()
                .filter(p -> Objects.equals(p.getUsuario().getId(), idUsuario)).findFirst();

        var pedido = pedidoOptional.orElse(null);

        if (pedido != null) {
            pedido.listaProdutor();
        }
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void adicionarProduto(UUID idPedido, Produto produto) {
        pedidos.stream().forEach(p -> {
            if (Objects.equals(p.getIdPedido(), idPedido))
                p.adicionarProduto(produto);
        });
    }

    public void adicionarCarrinho(UUID idPedido, Carrinho carrinho) {
        pedidos.stream().forEach(p -> {
            if (Objects.equals(p.getIdPedido(), idPedido))
                p.adicionarCarrinho(carrinho);
        });
    }
}
