package br.com.jota.repositorio;

import br.com.jota.entidade.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ProdutoRepository {
    private final List<Produto> produtos;

    public ProdutoRepository() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void adicionarAoEstoque(UUID idProduto, Integer quantidadeProdutos) {
        this.produtos.stream().forEach((u) -> {
            if (Objects.equals(u.getId(), idProduto))
                try {
                    u.adicionarProdutoAoEstoque(quantidadeProdutos);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
        });
    }

    public void removeProduto(UUID idProduto) {
        this.produtos.removeIf(u -> Objects.equals(u.getId(), idProduto));
    }

    public void listaProdutor() {
        this.produtos.forEach(System.out::println);
    }

    public void atualizarProdutoPorId(UUID idProduto, Produto produto) {
        this.produtos.stream().forEach((u) -> {
            if (Objects.equals(u.getId(), idProduto)) {
                try {
                    u.atualizarDados(produto);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }
}
