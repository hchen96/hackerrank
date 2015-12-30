package group_0739.piii;

/**
 *
 * @author group_0739
 *
 *This class represents an exception which is thrown when the input
 *is not as specified in the postconditions.
 */
public class InvalidInputException extends Exception {


    private static final long serialVersionUID = -8440440430786976561L;

    /**
     * Constructs a new InvalidInputException from the
     * superclass's constructor.
     */
    public InvalidInputException(){
        super();
    }

    /**
     * Constructs a new InvalidInputException from the
     * superclass's constructor.
     * @param message	The message to be added to explain why the exception
     * 					was thrown.
     */
    public InvalidInputException(String message){
        super(message);
    }

}