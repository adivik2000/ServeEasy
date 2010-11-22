package com.serveeasy.model.program;

import com.serveeasy.model.AbstractTestCase;
import com.serveeasy.model.bar.Table;
import com.serveeasy.model.bar.TableCollection;
import com.serveeasy.model.users.AdminUser;
import com.serveeasy.model.users.EmployeeUser;
import com.serveeasy.model.users.User;
import org.junit.Test;

/**
 * User: elvis
 * Date: 21-Nov-2010
 * Time: 15:40:13
 */
public class WorkDayTest extends AbstractTestCase {

    @Test
    public void testWorkDay() {

        WorkDay wd = new WorkDay();

        Table t1 = new Table(3, "t1");
        Table t2 = new Table(3, "t2");
        Table t3 = new Table(3, "t3");
        Table t4 = new Table(3, "t4");
        Table t5 = new Table(3, "t5");
        Table t6 = new Table(3, "t6");
        Table t7 = new Table(3, "t7");
        Table t8 = new Table(3, "t8");
        Table t9 = new Table(3, "t9");

        TableCollection tc1 = new TableCollection();
        tc1.addTable(t1);
        tc1.addTable(t2);
        tc1.addTable(t3);
        tc1.addTable(t4);
        tc1.addTable(t5);

        System.out.println(tc1.getActiveTables().size());

        tc1.removeTable(t2);

        System.out.println(tc1.getActiveTables().size());


        System.exit(0);



        User u1 = new EmployeeUser();
        u1.setUsername("user1");




        TableCollection tc2 = new TableCollection();
        tc2.addTable(t5);
        tc2.addTable(t6);
        tc2.addTable(t7);
        tc2.addTable(t8);
        tc2.addTable(t9);
        User u2 = new AdminUser();
        u2.setUsername("admin");

        wd.assignUser(u1);
        wd.assignUserToTables(u1, tc1);

        assertEquals(1, wd.getUsers().size());

        wd.assignUserToTables(u2, tc1);

        assertEquals(2, wd.getUsers().size());

        User u3 = new EmployeeUser();
        u3.setUsername("user 3");

        wd.assignUserToTables(u3, tc2);

        assertEquals(3, wd.getUsers().size());
        assertEquals(2, wd.getUsersForTable(t3).size());
        assertEquals(true, wd.getUsersForTable(t3).contains(u1));
        assertEquals(true, wd.getUsersForTable(t3).contains(u2));
        assertEquals(false, wd.getUsersForTable(t3).contains(u3));

        User u4 = new EmployeeUser();
        u4.setUsername("user 4");
        wd.copyUserTablesToUser(u1, u4);

        assertEquals(4, wd.getUsers().size());
        assertEquals(3, wd.getUsersForTable(t3).size());
        assertEquals(true, wd.getUsersForTable(t3).contains(u1));
        assertEquals(true, wd.getUsersForTable(t3).contains(u2));
        assertEquals(false, wd.getUsersForTable(t3).contains(u3));
        assertEquals(true, wd.getUsersForTable(t5).contains(u3));
        assertEquals(true, wd.getUsersForTable(t5).contains(u4));

        System.out.println(wd.getUsersForTable(t3));

        wd.removeTableForUser(u1, t3);

        assertEquals(4, wd.getUsers().size());
        System.out.println(wd.getUsersForTable(t3));
        assertEquals(2, wd.getUsersForTable(t3).size());
        assertEquals(false, wd.getUsersForTable(t3).contains(u1));
        assertEquals(true, wd.getUsersForTable(t3).contains(u2));
        assertEquals(false, wd.getUsersForTable(t3).contains(u3));
        assertEquals(true, wd.getUsersForTable(t5).contains(u3));
        assertEquals(true, wd.getUsersForTable(t5).contains(u4));
    }
}