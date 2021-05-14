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
public class EmployeeStatusException extends Exception {

    /**
     * Creates a new instance of <code>EmployeeStatusException</code> without
     * detail message.
     */
    public EmployeeStatusException() {
    }

    /**
     * Constructs an instance of <code>EmployeeStatusException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EmployeeStatusException(String msg) {
        super(msg);
    }
}
