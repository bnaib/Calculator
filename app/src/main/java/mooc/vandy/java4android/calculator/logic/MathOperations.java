package mooc.vandy.java4android.calculator.logic;

/**
 * It is interface for class Add, Subtract, Multiply, Divide
 * @param <T> - class of arguments of operation
 */
public interface MathOperations<T> {
    /**
     * Sets fields method
     * It is need for correct input at any operation.
     * @param argumentNumber - number of argument in operation
     * @param value - value of argument
     *
     * See more information in classes of this interface.
     */
    public void     setArgument(int argumentNumber, T value);

    /**
     * Sets fields method
     * It is need for correct input at any operation.
     * @param argumentNumber - number of argument in operation
     * @return - value of argument
     *
     * See more information in classes of this interface.
     */
    public T        getArgument(int argumentNumber);

    /**
     * Gets result of operation, and returns string of it.
     * @return - string result of operation
     *
     * See more information in classes of this interface.
     */
    public String   toString();
}
