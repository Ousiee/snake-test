package nl.hu.bep.setup;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/games")
public class GameResource {

    private static Map<String, Map<String, Object>> games = new HashMap<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGames() {
        return Response.ok(new ArrayList<>(games.keySet())).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGame(@PathParam("id") String id) {
        if (games.containsKey(id)) {
            return Response.ok(games.get(id)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteGame(@PathParam("id") String id) {
        if (games.containsKey(id)) {
            games.remove(id);
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    // Endpoint to add a game for testing purposes
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addGame(Map<String, Object> gameData) {
        String id = "game-" + (games.size() + 1);
        games.put(id, gameData);
        return Response.ok(Map.of("id", id)).build();
    }
}
