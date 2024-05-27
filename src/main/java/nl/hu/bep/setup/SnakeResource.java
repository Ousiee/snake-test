package nl.hu.bep.setup;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/snake")
public class SnakeResource {

    private static Map<String, Object> snake = new HashMap<>();

    static {
        snake.put("apiversion", "1");
        snake.put("author", "de dapper student");
        snake.put("color", "#ff0000");
        snake.put("head", "default");
        snake.put("tail", "default");
        snake.put("version", "0.1");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSnake() {
        return Response.ok(snake).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSnake(Map<String, Object> updatedSnake) {
        snake.putAll(updatedSnake);
        return Response.ok().build();
    }
}
