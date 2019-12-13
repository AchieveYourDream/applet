package com.kute.appletcore.entity;

public class InvOrderNumber {
    /**
     * 
     */
    private String prefix;

    /**
     * 
     */
    private String dateTime;

    /**
     * 
     */
    private Integer serialNumber;

    /**
     * 
     * @return prefix 
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * 
     * @param prefix 
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * 
     * @return date_time 
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * 
     * @param dateTime 
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * 
     * @return serial_number 
     */
    public Integer getSerialNumber() {
        return serialNumber;
    }

    /**
     * 
     * @param serialNumber 
     */
    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }
}