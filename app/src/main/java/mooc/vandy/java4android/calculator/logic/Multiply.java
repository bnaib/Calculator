package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Multiply operation.
 */
public class Multiply
        implements MathOperations<Integer> {
    /**
     * Private fields of arguments
     */
    private Integer     argumentOne;
    private Integer     argumentTwo;

    /**
     * Sets fields method
     * @param argumentNumber - number of argument in operation (1 or 2)
     * @param value - value of argument (any Integer)
     *
     * If argumentNumber isn't equal 1 or 2, creates exception
     */
    public void         setArgument(int argumentNumber, Integer value) {
        if (argumentNumber == 1)
            this.argumentOne = value;
        else if (argumentNumber == 2)
            this.argumentTwo = value;
        else
            throw new IllegalArgumentException(
                    "Illegal argumentNumber: " + argumentNumber);
    }

    /**
     * Sets fields method
     * @param argumentNumber - number of argument in operation (1 or 2)
     * @return - value of argument
     *
     * If argumentNumber isn't equal 1 or 2, creates exception
     */
    public Integer      getArgument(int argumentNumber) {
        if (argumentNumber == 1)
            return(this.argumentOne);
        if (argumentNumber == 2)
            return(this.argumentTwo);
        throw new IllegalArgumentException(
                "Illegal argumentNumber: " + argumentNumber);
    }

    /**
     * Constructor
     * Sets arguments of operation
     * @param argumentOne - any Integer
     * @param argumentTwo - any Integer
     */
    public              Multiply(Integer argumentOne, Integer argumentTwo) {
        this.setArgument(1, argumentOne);
        this.setArgument(2, argumentTwo);
    }

    /**
     * Multiplies argumentOne and argumentTwo, and returns string of it.
     *
     * int max value is 2147483647
     * int min value is -2147483648
     * I use int to long conversion to get correct result.
     * Example:
     * (int)2147483647 + (int)1 = (int)-2147483648
     * but
     * (long)2147483647 + (int)1 = (long)2147483648
     *
     * argumentOne.longValue() - convert int to long
     * argumentOne.longValue() + argumentTwo - return long
     * String.valueOf - convert long to string.
     */
    public String       toString() {
        return (String.valueOf(
                this.argumentOne.longValue() * this.argumentTwo));
    }
}
