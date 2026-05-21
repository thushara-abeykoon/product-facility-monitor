package io.entgra.alert.mgt.api.util;

import io.entgra.alert.mgt.api.beans.ErrorListItem;
import io.entgra.alert.mgt.api.beans.ErrorResponse;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.wso2.carbon.context.PrivilegedCarbonContext;
import org.apache.commons.logging.Log;

import javax.validation.ConstraintViolation;
import javax.ws.rs.InternalServerErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AlertMgtUtil {
    private static final Log log = LogFactory.getLog(AlertMgtUtil.class);
    private static <T> T loadOsgiService(Class<T> serviceClass) {
        Object osgiService = null;
        try {
            PrivilegedCarbonContext ctx = PrivilegedCarbonContext.getThreadLocalCarbonContext();
            osgiService = ctx.getOSGiService(serviceClass, null);
            return serviceClass.cast(osgiService);
        } catch (RuntimeException e) {
            String message = "Carbon context OGSi lookup failed for " + serviceClass.getName();
            if (log.isDebugEnabled()) {
                log.debug(message, e);
            }
            throw new InternalServerErrorException(message, e);
        }
    }

    public static <T> ErrorResponse getConstraintViolationErrorDTO(Set<ConstraintViolation<T>> violations) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setDescription("Validation Error");
        errorResponse.setMessage("Bad Request");
        errorResponse.setCode(400l);
        errorResponse.setMoreInfo("");
        List<ErrorListItem> errorListItems = new ArrayList<>();
        for (ConstraintViolation violation : violations) {
            ErrorListItem errorListItemDTO = new ErrorListItem();
            errorListItemDTO.setCode(400 + "_" + violation.getPropertyPath());
            errorListItemDTO.setMessage(violation.getPropertyPath() + ": " + violation.getMessage());
            errorListItems.add(errorListItemDTO);
        }
        errorResponse.setErrorItems(errorListItems);
        return errorResponse;
    }
}
