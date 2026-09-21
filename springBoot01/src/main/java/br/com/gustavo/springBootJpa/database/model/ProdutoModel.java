package br.com.gustavo.springBootJpa.database.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProdutoModel {

    private Integer id;
    private String name;
    private BigDecimal preco;
    private Integer quantidade;

}
