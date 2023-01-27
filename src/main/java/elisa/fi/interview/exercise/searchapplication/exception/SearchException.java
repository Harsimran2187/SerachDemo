package elisa.fi.interview.exercise.searchapplication.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class SearchException extends Exception {
    private static final Logger LOGGER = LogManager.getLogger(SearchException.class);
    public SearchException(String msg){
        super(msg);
        LOGGER.error("Invalid Input....Enter only interger values!!!");
    }

}
