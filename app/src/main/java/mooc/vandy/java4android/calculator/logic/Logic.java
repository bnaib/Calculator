package mooc.vandy.java4android.calculator.logic;

import mooc.vandy.java4android.calculator.logic.Add;
import mooc.vandy.java4android.calculator.logic.Divide;
import mooc.vandy.java4android.calculator.logic.Multiply;
import mooc.vandy.java4android.calculator.logic.Subtract;
import mooc.vandy.java4android.calculator.ui.ActivityInterface;

/**
 * Performs an operation selected by the user.
 */
public class Logic 
       implements LogicInterface {
    /**
     * Constants for using symbolic value of operation.
     */
    static final int ADDITION = 1;
    static final int SUBTRACTION = 2;
    static final int MULTIPLICATION = 3;
    static final int DIVISION = 4;

    /**
     * Reference to the Activity output.
     */
    protected ActivityInterface mOut;

    /**
     * Constructor initializes the field.
     */
    public Logic(ActivityInterface out){
        mOut = out;
    }

    /**
     * Perform the @a operation on @a argumentOne and @a argumentTwo.
     * @param argumentOne - any int value
     * @param argumentTwo - any int value
     * @param operation - can be values:
     *      ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
     *
     * "if else" construction check "operation" and use corresponding class.
     * If "operation" value is not correct, prints error message.
     */
    public void process(int argumentOne,
                        int argumentTwo,
                        int operation) {
        MathOperations<Integer> operationObj = null;

        if (operation == ADDITION)
            operationObj = new Add(argumentOne, argumentTwo);
        else if (operation == SUBTRACTION)
            operationObj = new Subtract(argumentOne, argumentTwo);
        else if (operation == MULTIPLICATION)
            operationObj = new Multiply(argumentOne, argumentTwo);
        else if (operation == DIVISION)
            operationObj = new Divide(argumentOne, argumentTwo);
        if (operationObj == null)
            mOut.print("Error: operation isn't correct!");
        else
            mOut.print(operationObj.toString());
    }
}
