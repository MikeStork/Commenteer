package org.logic;

import org.logic.interfaces.SQLCommentParserInterface;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLCommentParser implements SQLCommentParserInterface {

    public String createSaveQuery(Comment comment) {
        String query = "INSERT INTO comments VALUES (NULL,?,?,?,?,?);";
        return query;
    }
    public String createDeleteQuery(Comment comment) {
        String query = "DELETE FROM comments WHERE id="+comment.getId()+";";
        return query;
    }
    public String createListQuery() {
        return "SELECT * FROM comments;";
    }
    public String createTrendQuery(){
        return "SELECT employee, AVG(CASE WHEN YEARWEEK(date) = YEARWEEK(CURDATE()) THEN importance END) AS avg_importance_current_week, COALESCE(AVG(CASE WHEN YEARWEEK(date) < YEARWEEK(CURDATE()) THEN importance END), 0) AS avg_importance_earlier_time, CASE WHEN AVG(CASE WHEN YEARWEEK(date) = YEARWEEK(CURDATE()) THEN importance END) > COALESCE(AVG(CASE WHEN YEARWEEK(date) < YEARWEEK(CURDATE()) THEN importance END), 0) THEN 'Increased' WHEN AVG(CASE WHEN YEARWEEK(date) = YEARWEEK(CURDATE()) THEN importance END) < COALESCE(AVG(CASE WHEN YEARWEEK(date) < YEARWEEK(CURDATE()) THEN importance END), 0) THEN 'Decreased' ELSE 'Equivalent' END AS trend FROM comments GROUP BY employee;";
    }
    public List<Comment> resultSetToCommentList(ResultSet resultSet) throws SQLException {
        List<Comment> comments = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String employee = resultSet.getString("employee");
            String text = resultSet.getString("text");
            Integer importance = resultSet.getInt("importance");
            Date date = resultSet.getDate("date");
            String sender = resultSet.getString("sender");

            Comment comment = new Comment(id,employee,text,importance,date,sender);
            comments.add(comment);
        }

        return comments;
    }
    public ArrayList<Trend> resultSetToTrendList(ResultSet resultSet) throws SQLException{
        ArrayList<Trend> listedData= new ArrayList<>();
        while(resultSet.next()){
            listedData.add(new Trend(resultSet.getString("employee"),resultSet.getFloat("avg_importance_earlier_time"),resultSet.getFloat("avg_importance_current_week"),resultSet.getString("trend")));
        }
        return listedData;
    }
}
