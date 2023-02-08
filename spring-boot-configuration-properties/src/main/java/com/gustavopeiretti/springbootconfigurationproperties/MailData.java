package com.gustavopeiretti.springbootconfigurationproperties;

public class MailData {

    private String hostName;
    private int port;
    private String from;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "MailData{" +
                "hostName='" + hostName + '\'' +
                ", port=" + port +
                ", from='" + from + '\'' +
                '}';
    }
}
