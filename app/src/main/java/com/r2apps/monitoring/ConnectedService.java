package com.r2apps.monitoring;

/**
 * Created by Barun.Gupta on 3/17/2017.
 */

public class ConnectedService {

    private String noOfInstance = "0";
    private String name;
    private String noOfUpInstanceHtml = "0";
    private boolean startStop;

    public String getNoOfInstance() {
        return noOfInstance;
    }

    public void setNoOfInstance(String noOfInstance) {
        this.noOfInstance = noOfInstance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoOfUpInstanceHtml() {
        return noOfUpInstanceHtml;
    }

    public void setNoOfUpInstanceHtml(String noOfUpInstanceHtml) {
        this.noOfUpInstanceHtml = noOfUpInstanceHtml;
    }

    public boolean isStartStop() {
        return startStop;
    }

    public void setStartStop(boolean startStop) {
        this.startStop = startStop;
    }
}
