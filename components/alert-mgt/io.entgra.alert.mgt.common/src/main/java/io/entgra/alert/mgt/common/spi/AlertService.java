package io.entgra.alert.mgt.common.spi;

import io.entgra.alert.mgt.common.beans.Alert;
import io.entgra.alert.mgt.common.exception.AlertException;

import java.util.List;

public interface AlertService {
    List<Alert> getAlerts() throws AlertException;
    void createAlert(String name) throws AlertException;
}
