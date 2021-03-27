package br.com.victor.aifude.resources;

import br.com.victor.aifude.dtos.AdicionaPratoDTO;
import br.com.victor.aifude.dtos.AtualizaPratoDTO;
import br.com.victor.aifude.mappers.PratoMapper;
import br.com.victor.aifude.models.Prato;
import br.com.victor.aifude.models.Restaurante;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Path("restaurantes/{id}/pratos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PratosResources {

    @Inject
    PratoMapper pratoMapper;

    @GET
    public Collection<Prato> obtemTodos(@PathParam("id") Long resturanteId){
        var restaurante = (Restaurante) Restaurante.findByIdOptional(resturanteId).orElseThrow(NotFoundException::new);
        return restaurante.pratos;
    }

    @POST
    public Response salvaPrato(@PathParam("id") Long restauranteId, @Valid AdicionaPratoDTO pratoDTO){
        var restaurante = (Restaurante) Restaurante.findByIdOptional(restauranteId).orElseThrow(NotFoundException::new);
        var prato = pratoMapper.toPrato(pratoDTO);

        if(Objects.isNull(restaurante.pratos)){
            var pratos = new ArrayList<Prato>();
            pratos.add(prato);
            restaurante.pratos = pratos;
        }else {
            restaurante.pratos.add(prato);
        }

        Restaurante.persist(restaurante);
        return Response.status(Response.Status.CREATED).build();
    }

    @PATCH
    public Response atualizaPrato(@PathParam("id") Long pratoId, @Valid AtualizaPratoDTO atualizaPratoDTO){
        var prato = (Prato) Prato.findByIdOptional(pratoId).orElseThrow(NotFoundException::new);
        prato.preco = atualizaPratoDTO.preco;
        Prato.persist(prato);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    public Response deletaPrato(@PathParam("id") Long pratoId){
        if(Prato.count("id", pratoId) == 0){
            throw new NotFoundException();
        }
        Prato.deleteById(pratoId);
        return Response.ok().build();
    }

}
