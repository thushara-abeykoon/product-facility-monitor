package io.entgra.alert.mgt.common.beans;

public class Alert {
    private String name;
    private Long timestamp;

    public Alert(String name, Long timestamp) {
        this.name = name;
        this.timestamp = timestamp;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
