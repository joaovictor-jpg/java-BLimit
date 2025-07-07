package br.com.jota.repositorio;

import br.com.jota.entidade.Carrinho;
import br.com.jota.entidade.Pedido;
import br.com.jota.entidade.Produto;
import br.com.jota.entidade.Usuario;

import java.math.BigDecimal;
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

    public void removerProduto(UUID idProduto, UUID idUsuario) {
        pedidos.stream().forEach(p -> {
            var idUsuarioPedido = p.getUsuario().getId();
            if (Objects.equals(idUsuarioPedido, idUsuario)) {
                p.removeProduto(idProduto);
            }
        });
    }

    public void adicionarCarrinho(UUID idPedido, Carrinho carrinho) {
        pedidos.stream().forEach(p -> {
            if (Objects.equals(p.getIdPedido(), idPedido))
                p.adicionarCarrinho(carrinho);
        });
    }

    public void removerProdutoCarrinho(UUID idProduto, UUID idUsuario) {
        pedidos.stream().forEach(p -> {
            var idUsuarioPedido = p.getUsuario().getId();
            if (Objects.equals(idUsuarioPedido, idUsuario)) {
                p.removerProdutoDoCarrinho(idProduto);
            }
        });
    }

    public void pagar(UUID idUsuario) {
        List<Pedido> pedidosDoUsuario = pedidos.stream()
                .filter(p -> Objects.equals(p.getUsuario().getId(), idUsuario))
                .toList();

        if (pedidosDoUsuario.isEmpty()) {
            System.out.println("Nenhum pedido encontrado para o usuário com ID: " + idUsuario);
            return;
        }

        BigDecimal total = pedidosDoUsuario.stream()
                .map(Pedido::CalcularTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Usuario usuario = pedidosDoUsuario.get(0).getUsuario();

        System.out.println("Agradecemos sinceramente por confiar em nossos serviços: " + usuario.getNome());
        System.out.println("O valor total dos produtos é: R$ " + total);
    }
}
