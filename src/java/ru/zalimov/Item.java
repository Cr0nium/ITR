package ru.zalimov;


public class Item {

    private String fio;
    private String device;
    private int id;
    private String SN;
    private String stats;
    private String date;
    private int period;
    
    
    public String getFio() {
        return fio;
    }

    public String getDevice() {
        return device;
    }

    public int getId() {
        return id;
    }

    public String getSN() {
        return SN;
    }

    public String getStats() {
        return stats;
    }

    public String getDate() {
        return date;
    }

    public int getPeriod() {
        return period;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSN(String SN) {
        this.SN = SN;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
