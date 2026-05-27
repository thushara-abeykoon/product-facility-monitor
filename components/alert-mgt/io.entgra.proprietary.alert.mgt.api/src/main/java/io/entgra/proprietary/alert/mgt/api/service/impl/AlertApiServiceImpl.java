package io.entgra.proprietary.alert.mgt.api.service.impl;

import io.entgra.proprietary.alert.mgt.api.service.AlertApiService;
import io.entgra.proprietary.alert.mgt.common.beans.Alert;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/alerts")
public class AlertApiServiceImpl implements AlertApiService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response createAlert(Alert alert) {
        return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getAllAlerts() {
        return null;
    }
}
