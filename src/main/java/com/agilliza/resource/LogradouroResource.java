package com.agilliza.resource;

import com.agilliza.model.Logradouro;
import com.agilliza.service.LogradouroService;

import javax.inject.Inject;
import javax.json.Json;
import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Path("/logradouro")
public class LogradouroResource {

    @Inject
    private LogradouroService service;

    @GET
    @Path("/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Logradouro> get(@PathParam("nome") String nome) {
        return service.findByNome(nome);
    }

    @Provider
    public static class ErrorMapper implements ExceptionMapper<Exception> {

        @Override
        public Response toResponse(Exception exception) {
            int code = 500;

            if (exception instanceof NoResultException) {
                code = 404;
            }

            if (exception instanceof WebApplicationException) {
                code = ((WebApplicationException) exception).getResponse().getStatus();
            }
            return Response.status(code)
                    .entity(Json.createObjectBuilder()
                            .add("error", exception.getMessage())
                            .add("code", code).build())
                    .build();
        }

    }

}
