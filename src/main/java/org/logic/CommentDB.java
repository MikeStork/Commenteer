package org.logic;

import org.logic.interfaces.CommentBDInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentDB implements CommentBDInterface {

        private final static String DBURL = "jdbc:mysql://127.0.0.1:3306/commenteer";
        private final static String DBUSER = "root";
        private final static String DBPASS = "";
        private final static String DBDRIVER = "com.mysql.cj.jdbc.Driver";
        private Connection connection;
        private String query;
        private final SQLCommentParser sqlCommentParser = new SQLCommentParser();


    /**
     * Saves the given comment to the database.
     *
     * @param comment The comment to be saved.
     */
        public void save(Comment comment) {
            query = sqlCommentParser.createSaveQuery(comment);

            try {
                Class.forName(DBDRIVER).newInstance();
                connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1,comment.getEmployee());
                statement.setString(2, comment.getText());
                statement.setInt(3, comment.getImportance());
                statement.setDate(4,comment.getDate());
                statement.setString(5,comment.getSender());
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (InstantiationException | IllegalAccessException
                     | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

    /**
     * Retrieves a list of all comments from the database.
     *
     * @return A list of comments from the database.
     */
    public ArrayList<Comment> list() {
        query = sqlCommentParser.createListQuery();
        ArrayList<Comment> comments = new ArrayList<>();
        try {
            Class.forName(DBDRIVER).newInstance();
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            PreparedStatement statement = connection.prepareStatement(query);
            comments = (ArrayList<Comment>)sqlCommentParser.resultSetToCommentList(statement.executeQuery());
            statement.close();
            connection.close();
        } catch (InstantiationException | IllegalAccessException
                 | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }
    /**
     * Retrieves a list of trends from the database.
     *
     * @return A list of trends from the database.
     */
    public ArrayList<Trend> trend(){
            query = sqlCommentParser.createTrendQuery();
        ArrayList<Trend> trendList = new ArrayList<Trend>() ;
        try {
            Class.forName(DBDRIVER).newInstance();
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            PreparedStatement statement = connection.prepareStatement(query);
            trendList = sqlCommentParser.resultSetToTrendList(statement.executeQuery());
            statement.close();
            connection.close();
        } catch (InstantiationException | IllegalAccessException
                 | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return trendList;
    }
    /**
     * Deletes the given comment from the database.
     *
     * @param comment The comment to be deleted.
     */
    public void delete(Comment comment) {
        query = sqlCommentParser.createDeleteQuery(comment);

        try {
            Class.forName(DBDRIVER).newInstance();
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (InstantiationException | IllegalAccessException
                 | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


}
