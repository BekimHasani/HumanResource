/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author Armend
 */
public class HumanResourceLoginException extends Exception {

    /**
     * Creates a new instance of <code>HumanResourceLoginException</code>
     * without detail message.
     */
    public HumanResourceLoginException() {
    }

    /**
     * Constructs an instance of <code>HumanResourceLoginException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public HumanResourceLoginException(String msg) {
        super(msg);
    }
}
