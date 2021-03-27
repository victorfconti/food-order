package br.com.victor.aifude.dtos;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AdicionaPratoDTO {
    @NotNull
    public String nome;
    @NotNull
    public String descricao;
    @NotNull
    public BigDecimal preco;
}
