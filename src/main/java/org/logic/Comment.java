package org.logic;

import org.logic.interfaces.CommentInterface;

import java.sql.Date;
/**
 * Comment class interacting with and managing comments in a commenting application.
 */
public class Comment implements CommentInterface {
        private int id;
        private String employee;
        private String text;
        private Integer importance;
        private Date date;
        private String sender;

        public Comment(int id, String employee, String text, Integer importance, Date date, String sender){
                this.setId(id);
                this.setEmployee(employee);
                this.setText(text);
                this.setImportance(importance);
                this.setDate(date);
                this.setSender(sender);
        }
        public Comment(String employee, String text, Integer importance, Date date, String sender){
                this.setId(-1);
                this.setEmployee(employee);
                this.setText(text);
                this.setImportance(importance);
                this.setDate(date);
                this.setSender(sender);
        }
        /**
         * Gets the date of the comment.
         *
         * @return The date of the comment.
         */
        public Date getDate() {
                return date;
        }
        /**
         * Sets the date of the comment.
         *
         * @param date The date to be set for the comment.
         */
        public void setDate(Date date) {
                this.date = date;
        }
        /**
         * Gets the ID of the comment.
         *
         * @return The ID of the comment.
         */
        public int getId() {
                return id;
        }
        /**
         * Sets the ID of the comment.
         *
         * @param id The ID to be set for the comment.
         */
        public void setId(int id) {
                this.id = id;
        }
        /**
         * Gets the importance level of the comment.
         *
         * @return The importance level of the comment.
         */
        public Integer getImportance() {
                return importance;
        }
        /**
         * Sets the importance level of the comment.
         *
         * @param importance The importance level to be set for the comment.
         */
        public void setImportance(Integer importance) {
                this.importance = importance;
        }
        /**
         * Gets the sender of the comment.
         *
         * @return The sender of the comment.
         */
        public String getSender() {
                return sender;
        }
        /**
         * Sets the sender of the comment.
         *
         * @param sender The sender to be set for the comment.
         */
        public void setSender(String sender) {
                this.sender = sender;
        }

        /**
         * Gets the text of the comment.
         *
         * @return The text of the comment.
         */
        public String getText() {
                return text;
        }
        /**
         * Sets the text of the comment.
         *
         * @param text The text to be set for the comment.
         */
        public void setText(String text) {
                this.text = text;
        }
        /**
         * Gets the employee associated with the comment.
         *
         * @return The employee associated with the comment.
         */
        public String getEmployee() {
                return employee;
        }
        /**
         * Sets the employee associated with the comment.
         *
         * @param employee The employee to be set for the comment.
         */
        public void setEmployee(String employee) {
                this.employee = employee;
        }
}
