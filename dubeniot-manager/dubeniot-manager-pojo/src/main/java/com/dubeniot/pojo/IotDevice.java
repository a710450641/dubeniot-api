package com.dubeniot.pojo;

import java.util.Date;

public class IotDevice {
    private Integer deviceid;

    private String devicemac;

    private String deviceserialnumber;

    private String devicetype;

    private String deviceversion;

    private Date created;

    public Integer getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

    public String getDevicemac() {
        return devicemac;
    }

    public void setDevicemac(String devicemac) {
        this.devicemac = devicemac == null ? null : devicemac.trim();
    }

    public String getDeviceserialnumber() {
        return deviceserialnumber;
    }

    public void setDeviceserialnumber(String deviceserialnumber) {
        this.deviceserialnumber = deviceserialnumber == null ? null : deviceserialnumber.trim();
    }

    public String getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype == null ? null : devicetype.trim();
    }

    public String getDeviceversion() {
        return deviceversion;
    }

    public void setDeviceversion(String deviceversion) {
        this.deviceversion = deviceversion == null ? null : deviceversion.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}