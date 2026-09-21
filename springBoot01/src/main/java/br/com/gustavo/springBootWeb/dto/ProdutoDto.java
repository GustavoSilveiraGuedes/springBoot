package br.com.gustavo.springBootWeb.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProdutoDto {

    private String name;
    private BigDecimal preco;
    private Integer quantidade;

}
