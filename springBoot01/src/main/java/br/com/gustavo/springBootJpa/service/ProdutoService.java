package br.com.gustavo.springBootJpa.service;

import br.com.gustavo.springBootWeb.database.model.ProdutoModel;
import br.com.gustavo.springBootWeb.dto.ProdutoDto;
import br.com.gustavo.springBootWeb.exception.NotFoundExeption;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private static final List<ProdutoModel> PRODUTOS = new ArrayList<>();

    static {
        PRODUTOS.add(ProdutoModel.builder()
                .id(1)
                .name("Notebook")
                .preco(new BigDecimal(5000))
                .quantidade(10)
                .build());

        PRODUTOS.add(ProdutoModel.builder()
                .id(2)
                .name("Iphone")
                .preco(new BigDecimal(7000))
                .quantidade(10)
                .build());

        PRODUTOS.add(ProdutoModel.builder()
                .id(3)
                .name("Mouse")
                .preco(new BigDecimal(500))
                .quantidade(10)
                .build());
    }

    public List<ProdutoModel> findAll() {
        return new ArrayList<>(PRODUTOS);
    }

    public ProdutoModel addProduto(ProdutoDto produtoDto) {

        Integer id = PRODUTOS
                .stream()
                .mapToInt(ProdutoModel::getId)
                .max()
                .orElse(0) + 1;

        ProdutoModel novoProduto = ProdutoModel.builder()
                .id(id)
                .name(produtoDto.getName())
                .preco(produtoDto.getPreco())
                .quantidade(produtoDto.getQuantidade())
                .build();

        PRODUTOS.add(novoProduto);

        return novoProduto;
    }

    public ProdutoModel updateProduto(ProdutoDto produtoDto, Integer id) throws NotFoundExeption {

        ProdutoModel produto   =    PRODUTOS.stream()
                                    .filter(p -> p.getId().equals(id))
                                    .findAny().orElseThrow(() -> new NotFoundExeption("Produto não encontrado."));

        produto.setName(produtoDto.getName());
        produto.setPreco(produtoDto.getPreco());
        produto.setQuantidade(produtoDto.getQuantidade());

        return produto;
    }

    public void deleteProduto(Integer id){
        PRODUTOS.removeIf(p -> p.getId().equals(id));
    }

}
