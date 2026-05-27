package io.entgra.proprietary.alert.mgt.api.exception;

import io.entgra.proprietary.alert.mgt.api.util.AlertMgtUtil;

import javax.validation.ConstraintViolation;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Set;

public class ConstraintViolationException extends WebApplicationException {
    private final String message;

    public <T> ConstraintViolationException(Set<ConstraintViolation<T>> violations) {
        super(new BadRequestException(Response
                .status(Response.Status.BAD_REQUEST)
                .entity(AlertMgtUtil.getConstraintViolationErrorDTO(violations))
                .build()));

        //Set the error message
        StringBuilder stringBuilder = new StringBuilder();
        for (ConstraintViolation<T> violation : violations) {
            stringBuilder.append(violation.getRootBeanClass().getSimpleName());
            stringBuilder.append(".");
            stringBuilder.append(violation.getPropertyPath());
            stringBuilder.append(": ");
            stringBuilder.append(violation.getMessage());
            stringBuilder.append(", ");
        }
        message = stringBuilder.toString();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
