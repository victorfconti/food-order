package br.com.victor.aifude.mappers;

import br.com.victor.aifude.dtos.AdicionaRestauranteDTO;
import br.com.victor.aifude.models.Restaurante;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface RestauranteMapper {
    Restaurante toRestaurante(AdicionaRestauranteDTO dto);
}
