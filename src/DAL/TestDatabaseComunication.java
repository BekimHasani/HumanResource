/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.EmployeeLeaves;
import BLL.Logins;
import static GUI.MainForm.getEmployee;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Armend
 */
public class TestDatabaseComunication {
    final static EmployeeLeavesRepository elr = new EmployeeLeavesRepository();
    static LoginsInterface lr = new LoginsRepository();
    public static void main(String[] args) throws InterruptedException {
        Time t1 = new Time(System.currentTimeMillis());
        System.out.println(t1);
        Thread.sleep(3204);
        Time t2 = new Time(System.currentTimeMillis());
        System.out.println(t2);
        System.out.println(new Time (t2.getHours() - t1.getHours() , t2.getMinutes() - t1.getMinutes(),t2.getSeconds() - t1.getSeconds()));
    }
}
