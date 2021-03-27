package br.com.victor.aifude.dtos;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AtualizaPratoDTO {
    @NotNull
    public BigDecimal preco;
}
