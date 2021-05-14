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
public class TrainingStatusException extends Exception {

    /**
     * Creates a new instance of <code>TrainingStatusException</code> without
     * detail message.
     */
    public TrainingStatusException() {
    }

    /**
     * Constructs an instance of <code>TrainingStatusException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public TrainingStatusException(String msg) {
        super(msg);
    }
}
