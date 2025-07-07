package br.com.jota.entidade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Carrinho {
    private Usuario usuario;
    private final List<Produto> produtos;

    public Carrinho(Usuario usuario) {
        this.usuario = usuario;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void deletarProduto(UUID uuidProduto) {
        produtos.removeIf(u -> Objects.equals(u.getId(), uuidProduto));
    }

    public void limparCarrinho() {
        produtos.clear();
    }

    public void finalizarCompra() {
        BigDecimal valorTotal = produtos.stream()
                .map(Produto::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Boa noite, " + this.usuario.getNome());
        System.out.println("Esses são todos os seus produtos: ");
        produtos.forEach(System.out::println);
        System.out.println("O valor total dos produtos é: R$ " + valorTotal);
    }
}
