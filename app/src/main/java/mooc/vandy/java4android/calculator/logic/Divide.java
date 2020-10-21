package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Divide operation.
 */
public class Divide
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
    public              Divide(Integer argumentOne, Integer argumentTwo) {
        this.setArgument(1, argumentOne);
        this.setArgument(2, argumentTwo);
    }

    /**
     * Divides argumentOne by argumentTwo for get modulo and remainder,
     * and returns string of it.
     *
     * If argumentTwo is zero, returns string "Division by zero!"
     *
     * Gets programming modulo and remainder.
     * Modulo = argumentOne / argumentTwo
     * Remainder = argumentOne % argumentTwo
     * In programming, remainder can be less by zero,
     * but, in mathematics, 0 <= remainder < argumentTwo.
     * If programming value isn't equal math value,
     * adds to result string " or in Math: modulo R: remainder".
     *
     * Examples:
     * a : b = modulo and remainder
     * a = b * modulo + remainder;
     * Programming          | Mathematics
     * 1 : 3 = 0 and 1      | 1 : 3 = 0 and 1
     * -1 : 3 = 0 and -1    | -1 : 3 = -1 and 2
     * -10 : -3 = 3 and -1  | -10 : -3 = 4 and 2
     * 4 : -3 = -1 and 1     | 4 : -3 = -1 and 1
     *
     * 1) if "a / b = c" and "a % b = d"
     *      then "a = b * c + d"
     * 2) if "d >= 0" then results programming and mathematics are equals
     * 3) if "d < 0", and "a : b = e and f", and "a = b * e + f"
     *      then "a < 0", and "f = |b| + d", and "e = (a - f) / b"
     *
     * int max value is 2147483647
     * int min value is -2147483648
     * I use int to long conversion to get correct result.
     * Example:
     * (int)-2147483648 / (int)-1 = (int)-2147483648
     * but
     * (long)-2147483648 / (int)-1 = (long)2147483648
     */
    public String       toString() {
        long    div;
        long    mod;
        String  result;

        if (this.argumentTwo == 0)
            return ("Division by zero!");
        div = this.argumentOne.longValue() / this.argumentTwo;
        mod = this.argumentOne % this.argumentTwo;
        result = div + " R: " + mod;
        if (mod < 0) {
            mod = Math.abs(this.argumentTwo.longValue()) + mod;
            div = (this.argumentOne.longValue() - mod) / this.argumentTwo;
            result += " or in Math: " + div + " R: " + mod;
        }
        return (result);
    }
}
