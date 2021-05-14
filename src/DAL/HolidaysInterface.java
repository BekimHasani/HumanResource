/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Holidays;
import java.util.List;

/**
 *
 * @author BesaC
 */
public interface HolidaysInterface {

    void create(Holidays rs) throws HolidaysException;

    void edit(Holidays rs) throws HolidaysException;

    void remove(Holidays rs) throws HolidaysException;

    List<Holidays> findAll() throws HolidaysException;

    Holidays findByID(Short i) throws HolidaysException;
    
    List<Holidays> findByHolidayDescription(String description) throws HolidaysException;
}
