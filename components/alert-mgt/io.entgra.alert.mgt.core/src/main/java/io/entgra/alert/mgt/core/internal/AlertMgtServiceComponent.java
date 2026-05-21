package io.entgra.alert.mgt.core.internal;
import io.entgra.alert.mgt.common.spi.AlertService;
import io.entgra.alert.mgt.core.service.impl.AlertServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

@Component(name = "io.entgra.alert.mgt.core.internal.AlertMgtServiceComponent")
public class AlertMgtServiceComponent {
    private static final Log log = LogFactory.getLog(AlertMgtServiceComponent.class);

    @Activate
    protected void activate(ComponentContext componentContext) {
        try {
            BundleContext bundleContext = componentContext.getBundleContext();

            bundleContext.registerService(AlertService.class, new AlertServiceImpl(), null);
            if (log.isDebugEnabled()) {
                log.debug("Alert Service has been registered");
            }
        } catch (Throwable e) {
            log.error("Error occurred while activating Alert Management Service", e);
        }
    }

    @Deactivate
    protected void deactivate(ComponentContext componentContext) {
        if (log.isDebugEnabled()) {
            log.debug("De-activating Factory Management Service Component");
        }
    }

}
