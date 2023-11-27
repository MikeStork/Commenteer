package org.logic.interfaces;

/**
 * Interface for interacting with and managing comments in a commenting application.
 */

import java.sql.Date;

public interface CommentInterface {

    /**
     * Gets the date of the comment.
     *
     * @return The date of the comment.
     */
    Date getDate();

    /**
     * Sets the date of the comment.
     *
     * @param date The date to be set for the comment.
     */
    void setDate(Date date);

    /**
     * Gets the ID of the comment.
     *
     * @return The ID of the comment.
     */
    int getId();

    /**
     * Sets the ID of the comment.
     *
     * @param id The ID to be set for the comment.
     */
    void setId(int id);

    /**
     * Gets the importance level of the comment.
     *
     * @return The importance level of the comment.
     */
    Integer getImportance();

    /**
     * Sets the importance level of the comment.
     *
     * @param importance The importance level to be set for the comment.
     */
    void setImportance(Integer importance);

    /**
     * Gets the sender of the comment.
     *
     * @return The sender of the comment.
     */
    String getSender();

    /**
     * Sets the sender of the comment.
     *
     * @param sender The sender to be set for the comment.
     */
    void setSender(String sender);

    /**
     * Gets the text of the comment.
     *
     * @return The text of the comment.
     */
    String getText();

    /**
     * Sets the text of the comment.
     *
     * @param text The text to be set for the comment.
     */
    void setText(String text);

    /**
     * Gets the employee associated with the comment.
     *
     * @return The employee associated with the comment.
     */
    String getEmployee();

    /**
     * Sets the employee associated with the comment.
     *
     * @param employee The employee to be set for the comment.
     */
    void setEmployee(String employee);
}
