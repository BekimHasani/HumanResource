/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author BesaC
 */
public class HolidaysException extends Exception {

    /**
     * Creates a new instance of <code>HolidaysException</code> without detail
     * message.
     */
    public HolidaysException() {
    }

    /**
     * Constructs an instance of <code>HolidaysException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public HolidaysException(String msg) {
        super(msg);
    }
}
