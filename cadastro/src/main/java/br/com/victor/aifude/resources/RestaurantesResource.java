package br.com.victor.aifude.resources;

import br.com.victor.aifude.dtos.AdicionaRestauranteDTO;
import br.com.victor.aifude.mappers.RestauranteMapper;
import br.com.victor.aifude.models.Restaurante;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/restaurantes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestaurantesResource {

    @Inject
    RestauranteMapper restauranteMapper;

    @GET
    public List<Restaurante> obtemTodosRestaurantes(){
        return Restaurante.listAll();
    }

    @POST
    @Transactional
    public void adicionaRestaurante(@Valid AdicionaRestauranteDTO restauranteDTO){
        Restaurante restauranteNovo = restauranteMapper.toRestaurante(restauranteDTO);
        Restaurante.persist(restauranteNovo);
    }

    @PUT
    @Transactional
    @Path("{id}")
    public Response atualizaRestaurante(@PathParam("id") Long id, @Valid  AdicionaRestauranteDTO restauranteDTO){
        Restaurante restauranteOriginal = (Restaurante) Restaurante.findByIdOptional(id).orElseThrow(NotFoundException::new);
        restauranteOriginal.nome = restauranteDTO.nome;
        Restaurante.persist(restauranteOriginal);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Transactional
    @Path("{id}")
    public void deletaRestaurante(@PathParam("id") Long id){
        Restaurante.findByIdOptional(id).ifPresentOrElse(Restaurante::deleteById, () -> {throw new NotFoundException();});
    }
}
