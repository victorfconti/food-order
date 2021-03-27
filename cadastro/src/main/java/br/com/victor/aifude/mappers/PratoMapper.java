package br.com.victor.aifude.mappers;

import br.com.victor.aifude.dtos.AdicionaPratoDTO;
import br.com.victor.aifude.dtos.AtualizaPratoDTO;
import br.com.victor.aifude.models.Prato;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface PratoMapper {
    Prato toPrato (AdicionaPratoDTO adicionaPratoDTO);
    Prato toPrato(AtualizaPratoDTO atualizaPratoDTO);
}
