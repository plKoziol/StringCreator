package pl.koziol.rest;

import java.util.List;

import pl.koziol.model.InputData;
import pl.koziol.service.DatabaseRelations;
import pl.koziol.service.impl.DatabaseRelationsImpl;
import pl.koziol.service.impl.UniqueStringServiceImp;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/input")
public class InputDataEndpoint {
    @POST
    @Path("/addnew")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response startProcess(InputData inputData){
        UniqueStringServiceImp process = new UniqueStringServiceImp();
        process.createUniqueWords(
                inputData.getMinLength(),
                inputData.getMaxLength(),
                inputData.getInputCharacter(),
                inputData.getNumberOfString());
        return Response.ok().build();
    }

    @GET
    @Path("/completedprocesses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<InputData> completedProcesses(){
        DatabaseRelations db = new DatabaseRelationsImpl();
        return db.completedProcesses();
    }

}


