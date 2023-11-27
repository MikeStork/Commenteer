package org.logic.interfaces;

    /**
     * Interface for interacting with and managing comments in a database for a commenting application.
     */
import org.logic.Comment;
import org.logic.Trend;

import java.util.List;
public interface CommentBDInterface {



        /**
         * Saves the given comment to the database.
         *
         * @param comment The comment to be saved.
         */
        void save(Comment comment);

        /**
         * Retrieves a list of all comments from the database.
         *
         * @return A list of comments from the database.
         */
        List<Comment> list();

        /**
         * Retrieves a list of trends from the database.
         *
         * @return A list of trends from the database.
         */
        List<Trend> trend();

        /**
         * Deletes the given comment from the database.
         *
         * @param comment The comment to be deleted.
         */
        void delete(Comment comment);


}
