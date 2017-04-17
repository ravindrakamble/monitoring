package com.r2apps.monitoring.rest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ravindra.kambale on 3/22/2017.
 */

public class MailMetaData {
    private String clientRefId = "c5781597-ceaa-4f5e-aebe-c1ca9d9ce761";
    private int retryCount;
    private String mode = "ALL";
    private List<NotificationData> notifications;

    public String getClientRefId() {
        return clientRefId;
    }

    public void setClientRefId(String clientRefId) {
        this.clientRefId = clientRefId;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<NotificationData> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationData> notifications) {
        this.notifications = notifications;
    }

    public void addNotification(NotificationData notification) {
        if(this.notifications == null){
            this.notifications = new ArrayList<>();
        }
        this.notifications.add(notification);
    }
}
