package org.logic;

import org.logic.interfaces.CommentInterface;

import java.sql.Date;

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
        public Date getDate() {
                return date;
        }

        public void setDate(Date date) {
                this.date = date;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public Integer getImportance() {
                return importance;
        }

        public void setImportance(Integer importance) {
                this.importance = importance;
        }

        public String getSender() {
                return sender;
        }

        public void setSender(String sender) {
                this.sender = sender;
        }

        public String getText() {
                return text;
        }

        public void setText(String text) {
                this.text = text;
        }

        public String getEmployee() {
                return employee;
        }

        public void setEmployee(String employee) {
                this.employee = employee;
        }
}
