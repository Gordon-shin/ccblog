package com.ccblog.pojo.po;

public class Custombutton {
    private Integer custombuttonId;

    private String custombuttonName;

    private String custombuttonUrl;

    private Integer custombuttonLevel;

    private String custombuttonIcon;

    private Integer custombuttonStatus;

    public Integer getCustombuttonId() {
        return custombuttonId;
    }

    public void setCustombuttonId(Integer custombuttonId) {
        this.custombuttonId = custombuttonId;
    }

    public String getCustombuttonName() {
        return custombuttonName;
    }

    public void setCustombuttonName(String custombuttonName) {
        this.custombuttonName = custombuttonName == null ? null : custombuttonName.trim();
    }

    public String getCustombuttonUrl() {
        return custombuttonUrl;
    }

    public void setCustombuttonUrl(String custombuttonUrl) {
        this.custombuttonUrl = custombuttonUrl == null ? null : custombuttonUrl.trim();
    }

    public Integer getCustombuttonLevel() {
        return custombuttonLevel;
    }

    public void setCustombuttonLevel(Integer custombuttonLevel) {
        this.custombuttonLevel = custombuttonLevel;
    }

    public String getCustombuttonIcon() {
        return custombuttonIcon;
    }

    public void setCustombuttonIcon(String custombuttonIcon) {
        this.custombuttonIcon = custombuttonIcon == null ? null : custombuttonIcon.trim();
    }

    public Integer getCustombuttonStatus() {
        return custombuttonStatus;
    }

    public void setCustombuttonStatus(Integer custombuttonStatus) {
        this.custombuttonStatus = custombuttonStatus;
    }
}