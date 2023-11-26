package org.logic;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Comment {
        private static AtomicInteger counter = new AtomicInteger(0);
        private int id;
        private String employee;
        private String text;
        private Integer importance;
        private Date date;
        private String sender;

        Comment(int id, String employee, String text, Integer importance, Date date, String sender){
                this.setId(counter.incrementAndGet());
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