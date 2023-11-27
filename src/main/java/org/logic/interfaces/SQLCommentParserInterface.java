/**
 * Interface for parsing SQL queries and converting result sets to Java objects in a commenting application.
 */
package org.logic.interfaces;

import org.logic.Comment;
import org.logic.Trend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface SQLCommentParserInterface {

    /**
     * Creates an SQL query for saving a comment to the database.
     *
     * @param comment The comment to be saved.
     * @return The SQL query for saving the comment.
     */
    String createSaveQuery(Comment comment);

    /**
     * Creates an SQL query for deleting a comment from the database.
     *
     * @param comment The comment to be deleted.
     * @return The SQL query for deleting the comment.
     */
    String createDeleteQuery(Comment comment);

    /**
     * Creates an SQL query for retrieving a list of all comments from the database.
     *
     * @return The SQL query for retrieving all comments.
     */
    String createListQuery();

    /**
     * Creates an SQL query for retrieving trends from the database.
     *
     * @return The SQL query for retrieving trends.
     */
    String createTrendQuery();

    /**
     * Converts a result set to a list of Comment objects.
     *
     * @param resultSet The result set to be converted.
     * @return A list of Comment objects.
     * @throws SQLException If a database access error occurs.
     */
    List<Comment> resultSetToCommentList(ResultSet resultSet) throws SQLException;

    /**
     * Converts a result set to a list of Trend objects.
     *
     * @param resultSet The result set to be converted.
     * @return A list of Trend objects.
     * @throws SQLException If a database access error occurs.
     */
    List<Trend> resultSetToTrendList(ResultSet resultSet) throws SQLException;
}
