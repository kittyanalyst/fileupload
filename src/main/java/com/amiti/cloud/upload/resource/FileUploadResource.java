package com.amiti.cloud.upload.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by ramchalasani on 11/1/16.
 */
@Api (value=" Upload Resource", description = "File Upload Processing")
@Component ("fileUploadResource")
@Path("/upload")
public class FileUploadResource {

    private final Logger logger = LoggerFactory.getLogger(FileUploadResource.class);


    @GET
    @Path ("hello")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation"),
            @ApiResponse(code = 400, message = "Failed validation"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public String sayHello() {
        return "Hello ! This is Apache CXF first Webservice!";
    }
}
