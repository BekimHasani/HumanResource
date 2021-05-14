/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;
import java.time.LocalDate;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Armend
 */
public class Utility {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static boolean isEmpty(String sr) {
        return sr == null || sr.trim().isEmpty();
    }

    public static Date toDate(LocalDate d) {
        return java.sql.Date.valueOf((LocalDate) d);
    }

    public static LocalDate toLocalDate(Date d) {
        return ((Date) d).toLocalDate();
    }

    public static boolean validEmail(String email) {
        final Pattern EMAIL = Pattern.compile("[a-zA-Z]([a-zA-Z0-9_.,!])+@CompanyName\\.com", Pattern.CASE_INSENSITIVE);
        return EMAIL.matcher(email).matches();
    }

    public static boolean validMobileNumber(String number) {
        final Pattern MOBILE = Pattern.compile("003834\\d{7}");
        return MOBILE.matcher(number).matches();
    }

    public static boolean validHomeNumber(String number) {
        final Pattern HOME = Pattern.compile("0038338\\d{6}");
        return HOME.matcher(number).matches();
    }

    public static boolean validName(String name) {
        final Pattern NAME = Pattern.compile("[A-Z][a-z ]*", Pattern.CASE_INSENSITIVE);
        return NAME.matcher(name).matches();
    }

    public static boolean validPersonalNumber(String number) {
        final Pattern PERSONAL = Pattern.compile("12\\d{8}");
        return PERSONAL.matcher(number).matches();
    }

    public static boolean validState(String state) {
        final Pattern STATE = Pattern.compile("[a-zA-Z]+");
        return STATE.matcher(state).matches();
    }

    public static boolean validRequestDays(String days) {
        final Pattern DAYS = Pattern.compile("[0-9]+");
        return DAYS.matcher(days).matches();
    }

    public static boolean validDepartmentName(String name) {
        final Pattern NAME = Pattern.compile("[A-Z][a-zA-Z ]+", Pattern.CASE_INSENSITIVE);
        return NAME.matcher(name).matches();
    }

    public static boolean validEmployeeNubers(String days) {
        final Pattern DAYS = Pattern.compile("^[0-9]+");
        return DAYS.matcher(days).matches();
    }

    public static String format(java.util.Date d) {
        return sdf.format(d);
    }

    /**
     * getMD5 - is a
     * method that accepts as a String as a parameter and returns the encrypted
     * version of the Strings.
     *
     * @param input the string that needs to be encrypted
     * @return - encrypted string
     */
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeToExcell(JTable table, String path) throws FileNotFoundException, IOException {
        new WorkbookFactory();
        Workbook wb = new XSSFWorkbook(); //Excell workbook
        Sheet sheet = (Sheet) wb.createSheet(); //WorkSheet
        Row row = sheet.createRow(2); //Row created at line 3
        TableModel model = table.getModel(); //Table model

        Row headerRow = sheet.createRow(0); //Create row at line 0
        for (int headings = 0; headings < model.getColumnCount(); headings++) { //For each column
            headerRow.createCell(headings).setCellValue(model.getColumnName(headings));//Write column name
            sheet.autoSizeColumn(headings);
        }

        for (int rows = 0; rows < model.getRowCount(); rows++) { //For each table row
            for (int cols = 0; cols < table.getColumnCount(); cols++) { //For each table column
                if (isNumeric(model.getValueAt(rows, cols).toString()) == false) {
                    row.createCell(cols).setCellValue(model.getValueAt(rows, cols).toString());
                    sheet.autoSizeColumn(cols);//Write value to String  
                } else {
                    row.createCell(cols).setCellValue(Double.parseDouble(model.getValueAt(rows, cols).toString()));
                    sheet.autoSizeColumn(cols);//Write value to double    
                }

            }

            //Set the row to the next one in the sequence 
            row = sheet.createRow((rows + 3));
        }
        wb.write(new FileOutputStream(path));//Save the file     
    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
