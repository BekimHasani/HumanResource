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
public class EmployeeLeavesException extends Exception {

    /**
     * Creates a new instance of <code>EmployeeLeavesException</code> without
     * detail message.
     */
    public EmployeeLeavesException() {
    }

    /**
     * Constructs an instance of <code>EmployeeLeavesException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EmployeeLeavesException(String msg) {
        super(msg);
    }
}
