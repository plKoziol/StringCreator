package pl.koziol.rest;

import pl.koziol.model.InputData;
import pl.koziol.service.UniqueStringService;
import pl.koziol.service.impl.UniqueStringServiceImp;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/result")
public class ResultEndpoint {
    @GET
    @Path("/sortedbyprocess/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> resultFor1Process(@PathParam("id") int id){
        UniqueStringService unique= new UniqueStringServiceImp();
        List<String> result = unique.getResultById(id);
        return result;
    }
    @GET
    @Path("/activeprocess/")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer resultFor1Process(){
        UniqueStringService unique = new UniqueStringServiceImp();
        return unique.getActiveProcesses();
    }
}
