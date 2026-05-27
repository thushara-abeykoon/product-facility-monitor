package io.entgra.proprietary.alert.mgt.api.service;

import io.entgra.proprietary.alert.mgt.common.beans.Alert;
import io.entgra.proprietary.alert.mgt.common.util.AlertMgtConstants;
import io.entgra.device.mgt.core.apimgt.annotations.Scope;
import io.entgra.device.mgt.core.apimgt.annotations.Scopes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Extension;
import io.swagger.annotations.ExtensionProperty;
import io.swagger.annotations.Info;
import io.swagger.annotations.ResponseHeader;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@SwaggerDefinition(
        info = @Info(
                version = "1.0.0",
                title = "Alert Management API Service",
                extensions = {
                        @Extension(properties = {
                                @ExtensionProperty(name = "name", value = "Alert Management API Alert Management"),
                                @ExtensionProperty(name = "context", value = "/api/alert-mgt/v1.0/alerts"),
                        })
                }
        ),
        tags = {
                @Tag(name = "device_management", description = "Facility Monitoring Alert Management Service")
        }
)

@Path("/alerts")
@Api(value = "Facility Monitoring API Alert Management")
@Scopes(
        scopes = {
                @Scope(
                        name = "View Alert",
                        description = "View Alert",
                        key = "fm:am:alerts:view",
                        permissions = {"/facility-mgt/alerts/acknowledge"},
                        roles = {"Internal/devicemgt-user"}
                ),
                @Scope(
                        name = "Create Alert",
                        description = "Create Alert",
                        key = "fm:am:alerts:create",
                        permissions = {"/facility-mgt/alerts/view"},
                        roles = {"Internal/devicemgt-user"}
                )
        }
)
public interface AlertApiService {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON,
            httpMethod = "POST",
            value = "Create an alert",
            notes = "Create an alert",
            tags = "Alert Management Service",
            extensions = {
                    @Extension(properties = {
                            @ExtensionProperty(
                                    name = AlertMgtConstants.Common.SCOPE,
                                    value = "fm:am:alerts:create"
                            )
                    })
            }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "OK. \n Successfully created the alert",
                    responseHeaders = {
                            @ResponseHeader(
                                    name = "Content-Location",
                                    description = "URL."
                            ),
                            @ResponseHeader(
                                    name = "Content-Type",
                                    description = "Content type of the body"
                            ),
                            @ResponseHeader(
                                    name = "ETag",
                                    description = "Entity Tag of the response resource.\n" +
                                            "Used by caches, or in conditional requests."
                            ),
                            @ResponseHeader(
                                    name = "Last-Modified",
                                    description = "Date and time the resource was last modified.\n" +
                                            "Used by caches, or in conditional requests."
                            )
                    }
            )
    })
    Response createAlert(@Valid Alert alert);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Filter downtime codes with pagination",
            notes = "Filter downtime codes by criteria with pagination",
            extensions = @Extension(properties = {
                    @ExtensionProperty(
                            name = AlertMgtConstants.Common.SCOPE,
                            value = "fm:downtimecode:view")
            })
    )
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "OK. Successfully fetched filtered downtime codes.",
                    response = Alert.class
            )
    })
    Response getAllAlerts();
}
