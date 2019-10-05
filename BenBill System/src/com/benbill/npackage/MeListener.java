package com.benbill.npackage;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@WebServlet(name = "Servlet")
public class MeListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/benbill_schema", "root", "4321");
         PreparedStatement ps=con.prepareStatement("CREATE TABLE STUDENT2 (ID INT,NAME VARCHAR(4000), COURSE VARCHAR(4000), MOBILE VARCHAR(4000), FEE_SUB VARCHAR(4000), FEE VARCHAR(4000), PAID VARCHAR(4000), BALANCE VARCHAR(4000), ADDRESS VARCHAR(4000), FATHERNAME VARCHAR(4000), MOTHERNAME VARCHAR(4000), DATEOFBIRTH VARCHAR(4000), QUALIFICATION VARCHAR(4000), DATEOFJOINING VARCHAR(4000), DESCRIPTION VARCHAR(4000), TRAINER VARCHAR(4000), PRIMARY KEY (ID))");
            ps.executeUpdate();
            PreparedStatement ps4=con.prepareStatement("CREATE TABLE PAYREGISTER(ID INT,USERNAME VARCHAR(4000), USERPASS VARCHAR(4000), BRANCH VARCHAR(4000),DATEOFJOINING VARCHAR(4000), DATEOFBIRTH VARCHAR(4000), SALARY VARCHAR(4000),PRIMARY KEY (ID))");
            ps4.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub

    }

}
