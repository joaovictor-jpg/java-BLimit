package br.com.jota.entidade;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Produto {
    private UUID id;
    private BigDecimal preco;
    private String nome;
    private Integer estoque;

    public Produto(UUID id, BigDecimal preco, String nome, Integer estoque) {
        this.id = id;
        this.naoPodeSerUmValorNegativo(preco);
        this.preco = preco;
        this.naoPodePossuirQuantidadeNegativaDeProduto(estoque);
        this.nome = nome;
        this.estoque = estoque;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void adicionarProdutoAoEstoque(Integer estoque) {
        this.naoPodePossuirQuantidadeNegativaDeProduto(estoque);
        this.estoque = estoque;
    }

    public void removeDoEstoque(Integer estoque) {
        if (this.estoque < estoque) {
            System.out.println("Estoque indisponível para a quantidade desejada.");
        }

        this.estoque -= estoque;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", preco=" + preco +
                ", nome='" + nome + '\'' +
                ", estoque=" + estoque +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public void atualizarDados(Produto produto) {
        if (produto.getPreco() != null) {
            this.naoPodeSerUmValorNegativo(produto.preco);
            this.preco = produto.getPreco();
        }

        if (produto.getNome() != null) {
            this.nome = produto.getNome();
        }

        if (produto.getEstoque() != null) {
            this.estoque = produto.getEstoque();
        }
    }

    private void naoPodeSerUmValorNegativo(BigDecimal preco) {
        if (preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Por favor, insira um valor igual ou maior que zero.");
        }
    }

    private void naoPodePossuirQuantidadeNegativaDeProduto(Integer estoque) {
        if (estoque < 0) {
            throw  new IllegalArgumentException("A quantidade de produtos deve ser maior ou igual a zero.");
        }
    }
}
