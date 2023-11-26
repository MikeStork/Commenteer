package org.logic;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLCommentParser {

    public String createSaveQuery(Comment comment) {
//        String query = "INSERT INTO comments VALUES (NULL,"
//                +comment.getEmployee()+" ,'"
//                +comment.getText() + "', '"
//                +comment.getSender() +"','"
//                +comment.getDate() +"','"
//                +comment.getImportance()+"');";
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
}
