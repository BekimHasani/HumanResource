/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author Bekim
 */
public class AttendanceException extends Exception {

    /**
     * Creates a new instance of <code>AttendanceException</code> without detail
     * message.
     */
    public AttendanceException() {
    }

    /**
     * Constructs an instance of <code>AttendanceException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AttendanceException(String msg) {
        super(msg);
    }
}
