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
public class EmployeeDepHistoryException extends Exception {

    /**
     * Creates a new instance of <code>EmployeeDepHistoryException</code>
     * without detail message.
     */
    public EmployeeDepHistoryException() {
    }
    
    public EmployeeDepHistoryException(String msg) {
        super(msg);
    }
}
