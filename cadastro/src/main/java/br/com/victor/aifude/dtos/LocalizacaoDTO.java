package br.com.victor.aifude.dtos;

import javax.validation.constraints.NotNull;

public class LocalizacaoDTO {
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
}
