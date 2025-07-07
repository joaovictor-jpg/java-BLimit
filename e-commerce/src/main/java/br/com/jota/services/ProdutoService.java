package br.com.jota.services;

import br.com.jota.repositorio.ProdutoRepository;

public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }


}
