package br.com.estagginc.estagg_api.core;

import java.util.Date;

public class TestAPIConnection {
    private Date timestamp;
    private String message;
    private String remoteAddress;

    public TestAPIConnection(Date timestamp, String message, String remoteAddress) {
        this.timestamp = timestamp;
        this.message = message;
        this.remoteAddress = remoteAddress;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }
}
