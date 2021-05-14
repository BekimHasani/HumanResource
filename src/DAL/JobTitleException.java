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
public class JobTitleException extends Exception {

    /**
     * Creates a new instance of <code>JobTitleException</code> without detail
     * message.
     */
    public JobTitleException() {
    }

    /**
     * Constructs an instance of <code>JobTitleException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public JobTitleException(String msg) {
        super(msg);
    }
}
