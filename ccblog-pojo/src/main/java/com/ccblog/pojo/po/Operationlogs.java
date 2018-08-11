package com.ccblog.pojo.po;

import java.util.Date;

public class Operationlogs {
    private Integer oplogId;

    private String oplogIp;

    private String oplogOperation;

    private String oplogArea;

    private String oplogComputer;

    private String oplogBrowser;

    private Date oplogCreateTime;

    public Integer getOplogId() {
        return oplogId;
    }

    public void setOplogId(Integer oplogId) {
        this.oplogId = oplogId;
    }

    public String getOplogIp() {
        return oplogIp;
    }

    public void setOplogIp(String oplogIp) {
        this.oplogIp = oplogIp == null ? null : oplogIp.trim();
    }

    public String getOplogOperation() {
        return oplogOperation;
    }

    public void setOplogOperation(String oplogOperation) {
        this.oplogOperation = oplogOperation == null ? null : oplogOperation.trim();
    }

    public String getOplogArea() {
        return oplogArea;
    }

    public void setOplogArea(String oplogArea) {
        this.oplogArea = oplogArea == null ? null : oplogArea.trim();
    }

    public String getOplogComputer() {
        return oplogComputer;
    }

    public void setOplogComputer(String oplogComputer) {
        this.oplogComputer = oplogComputer == null ? null : oplogComputer.trim();
    }

    public String getOplogBrowser() {
        return oplogBrowser;
    }

    public void setOplogBrowser(String oplogBrowser) {
        this.oplogBrowser = oplogBrowser == null ? null : oplogBrowser.trim();
    }

    public Date getOplogCreateTime() {
        return oplogCreateTime;
    }

    public void setOplogCreateTime(Date oplogCreateTime) {
        this.oplogCreateTime = oplogCreateTime;
    }
}