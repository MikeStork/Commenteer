/**
 * Interface for interacting with and managing trends in a commenting application.
 */
package org.logic.interfaces;

public interface TrendInterface {

    /**
     * Gets the employee associated with the trend.
     *
     * @return The employee associated with the trend.
     */
    String getEmployee();

    /**
     * Sets the employee associated with the trend.
     *
     * @param employee The employee to be set for the trend.
     */
    void setEmployee(String employee);

    /**
     * Gets the value for the current week in the trend.
     *
     * @return The value for the current week in the trend.
     */
    Float getCurrWeek();

    /**
     * Gets the value for the earlier period in the trend.
     *
     * @return The value for the earlier period in the trend.
     */
    Float getEarlier();

    /**
     * Gets the trend description.
     *
     * @return The trend description.
     */
    String getTrend();

    /**
     * Sets the value for the current week in the trend.
     *
     * @param currWeek The value to be set for the current week in the trend.
     */
    void setCurrWeek(Float currWeek);

    /**
     * Sets the value for the earlier period in the trend.
     *
     * @param earlier The value to be set for the earlier period in the trend.
     */
    void setEarlier(Float earlier);

    /**
     * Sets the trend description.
     *
     * @param trend The trend description to be set.
     */
    void setTrend(String trend);
}
