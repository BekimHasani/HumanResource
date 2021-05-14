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
public class EmployeeTrainingsException extends Exception {

    /**
     * Creates a new instance of <code>EmployeeTrainingsException</code> without
     * detail message.
     */
    public EmployeeTrainingsException() {
    }

    /**
     * Constructs an instance of <code>EmployeeTrainingsException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public EmployeeTrainingsException(String msg) {
        super(msg);
    }
}
