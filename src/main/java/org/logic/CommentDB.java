package org.logic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class CommentDB {

        /**
         * Tutaj należy zdefiniować użytkownika, hasło, adres oraz
         * sterownik do bazy danych z którą zamierzamy się połączyć.
         */
        private final static String DBURL = "jdbc:mysql://127.0.0.1:3306/commenteer";
        private final static String DBUSER = "root";
        private final static String DBPASS = "";
        private final static String DBDRIVER = "com.mysql.cj.jdbc.Driver";

        //obiekt tworzący połączenie z bazą danych.
        private Connection connection;
        //zapytanie SQL
        private String query;
        //parser zapytań SQL dla obiektów klasy Article
        private SQLCommentParser sqlCommentParser = new SQLCommentParser();


        public void save(Comment comment) {
            query = sqlCommentParser.createSaveQuery(comment);

            try {
                Class.forName(DBDRIVER).newInstance();
                connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1,comment.getEmployee());
                statement.setString(2, comment.getText());
                statement.setString(3, comment.getSender());
                statement.setDate(4,comment.getDate());
                statement.setInt(5,comment.getImportance());
                //TODO statements
                statement.executeQuery();

                //zwolnienie zasobów i zamknięcie połączenia
                statement.close();
                connection.close();
            } catch (InstantiationException | IllegalAccessException
                     | ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

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

    public void delete(Comment comment) {
        query = sqlCommentParser.createDeleteQuery(comment);

        try {
            Class.forName(DBDRIVER).newInstance();
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            PreparedStatement statement = connection.prepareStatement(query);

            //TODO statements
            statement.executeUpdate(query);

            //zwolnienie zasobów i zamknięcie połączenia
            statement.close();
            connection.close();
        } catch (InstantiationException | IllegalAccessException
                 | ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
