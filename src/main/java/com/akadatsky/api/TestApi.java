package com.akadatsky.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class TestApi {

    @GET
    @Path("/")
    public Response base() {
        return Response.status(Response.Status.OK).entity("BASE").build();
    }

    @GET
    @Path("/test1")
    public Response test1() {
        return Response.status(Response.Status.OK).entity("test1").build();
    }

    @GET
    @Path("/test2/more/complex/url")
    public Response test2() {
        return Response.status(Response.Status.OK).entity("test2").build();
    }

    @GET
    @Path("/test3")
    public Response test3(@QueryParam("name") String name, @QueryParam("age") int age) {
        String result = String.format("Your name: %s, your age: %d", name, age);
        return Response.status(Response.Status.OK).entity(result).build();
    }

    @GET
    @Path("/test4/{name}/{age}")
    public Response test4(@PathParam("name") String name, @PathParam("age") int age) {
        String result = String.format("Your name: %s, your age: %d", name, age);
        return Response.status(Response.Status.OK).entity(result).build();
    }

    @GET
    @Path("/test5")
    public Response test3(@HeaderParam("User-Agent") String client) {
        String result = String.format("Your client: %s", client);
        return Response.status(Response.Status.OK).entity(result).build();
    }

    @POST
    @Path("/test6")
    public Response test6(@FormParam("name") String name, @FormParam("age") int age) {
        String result = String.format("Your name: %s, your age: %d", name, age);
        return Response.status(Response.Status.OK).entity(result).build();
    }

    @POST
    @Path("/test7")
    public Response test7(String body) {
        String result = String.format("Your body: %s", body);
        return Response.status(Response.Status.OK).entity(result).build();
    }

    @PUT
    @Path("/test8")
    @Consumes(MediaType.APPLICATION_JSON) //APPLICATION_FORM_URLENCODED
    @Produces(MediaType.APPLICATION_JSON)
    public Response test8(String body) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(body)
                .header("MyHeader", "test")
                .build();
    }

}
