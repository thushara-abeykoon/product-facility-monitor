package io.entgra.alert.mgt.api.service.impl;

import io.entgra.alert.mgt.api.service.AlertApiService;
import io.entgra.alert.mgt.common.beans.Alert;
import io.swagger.jaxrs.PATCH;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class AlertApiServiceImpl implements AlertApiService {
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response createAlert(Alert alert) {
        return null;
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getAllAlerts() {
        return null;
    }
}
