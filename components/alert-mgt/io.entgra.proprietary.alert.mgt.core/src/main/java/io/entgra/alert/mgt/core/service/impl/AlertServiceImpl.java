package io.entgra.alert.mgt.core.service.impl;

import io.entgra.alert.mgt.common.beans.Alert;
import io.entgra.alert.mgt.common.exception.AlertException;
import io.entgra.alert.mgt.common.spi.AlertService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AlertServiceImpl implements AlertService {
    private static final Log log = LogFactory.getLog(AlertServiceImpl.class);
    private final Stack<Alert> alertStack = new Stack<>();

    @Override
    public List<Alert> getAlerts() throws AlertException {
        return new ArrayList<>(alertStack);
    }

    @Override
    public void createAlert(String name) throws AlertException {
        alertStack.add(new Alert(name, 0L));
        log.info("Alert has been added successfully!");
    }
}
