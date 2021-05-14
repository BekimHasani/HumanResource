/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author USER
 */
public class RequestStatusException extends Exception {

    /**
     * Creates a new instance of <code>RequestStatusException</code> without
     * detail message.
     */
    public RequestStatusException() {
    }

    /**
     * Constructs an instance of <code>RequestStatusException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public RequestStatusException(String msg) {
        super(msg);
    }
}
