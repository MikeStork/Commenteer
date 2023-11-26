package org.logic;

public class Trend {
    String employee;
    Float earlier;
    Float currWeek;
    String trend;
    Trend(String employee, Float earlier,Float currWeek, String trend){
        this.setTrend(trend);
        this.setEarlier(earlier);
        this.setCurrWeek(currWeek);
        this.setEmployee(employee);
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Float getCurrWeek() {
        return currWeek;
    }

    public Float getEarlier() {
        return earlier;
    }

    public String getTrend() {
        return trend;
    }

    public void setCurrWeek(Float currWeek) {
        this.currWeek = currWeek;
    }

    public void setEarlier(Float earlier) {
        this.earlier = earlier;
    }

    public void setTrend(String trend) {
        this.trend = trend;
    }
}
