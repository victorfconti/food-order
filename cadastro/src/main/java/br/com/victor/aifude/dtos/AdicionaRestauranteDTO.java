package br.com.victor.aifude.dtos;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotNull;

public class AdicionaRestauranteDTO {
    @NotNull
    public String proprietario;
    @CNPJ
    @NotNull
    public String cnpj;
    @NotNull
    public String nome;
    @NotNull
    public LocalizacaoDTO localizacao;
}
