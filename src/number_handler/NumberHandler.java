package number_handler;

import exceptions.NumberSystemException;
import model.Expression;

/**
 * @author tsypk on 07.11.2021 16:24
 * @project Calculator_kata
 * Handles number in String format
 */
public interface NumberHandler {
    /**
     * @param number number in number system string
     * @return int number
     */
    Integer handleNumber(String number);

    /**
     * @param number integet param
     * @return number in number system string
     * @throws NumberSystemException if number isn't found
     */
    String getNumberInNumberSystem(Integer number) throws NumberSystemException;

    /**
     * sets NumberSystem to expression, depending on implementation
     * @param expression expression
     */
    void setNumberSystem(Expression expression);

}
