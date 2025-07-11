package br.com.jota.entidade;

import br.com.jota.entidade.enums.StatusPedido;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Pedido {
    private UUID idPedido;
    private Usuario usuario;
    private List<Produto> produtos;
    private Carrinho carrinho;
    private StatusPedido status;

    public Pedido(Usuario usuario, StatusPedido status) {
        this.idPedido = UUID.randomUUID();
        this.usuario = usuario;
        this.produtos = new ArrayList<>();
        this.status = status;
    }

    public UUID getIdPedido() {
        return idPedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void listaProdutor() {
        this.produtos.forEach(System.out::println);
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removeProduto(UUID idProduto) {
        produtos.removeIf(p -> Objects.equals(p.getId(), idProduto));
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void removerProdutoDoCarrinho(UUID idProduto) {
        carrinho.deletarProduto(idProduto);
    }

    public void adicionarCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public BigDecimal CalcularTotal() {
        BigDecimal total = (carrinho != null) ? carrinho.calcularValorTotal() : BigDecimal.ZERO;
        if (produtos != null) {
            BigDecimal valorProdutos = produtos.stream()
                    .map(Produto::getPreco)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            total = total.add(valorProdutos);
        }
        return total;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", usuario=" + usuario +
                ", produtos=" + produtos +
                ", carrinho=" + carrinho +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(idPedido, pedido.idPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idPedido);
    }
}
