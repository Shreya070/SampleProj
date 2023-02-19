package com.javajdbcpostgre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class insertjdbc {
   public static void main(String args[]) {
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/testdb1",
            "postgres", "Shreya@7");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "INSERT INTO BUSINESS (ID,NAME,AGE,ADDRESS,SALARY) "
            + "VALUES (1, 'Amit', 23, 'California', 30000.00 );";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO BUSINESS (ID,NAME,AGE,ADDRESS,SALARY) "
            + "VALUES (2, 'Tony', 27, 'Texas', 25000.00 );";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO BUSINESS (ID,NAME,AGE,ADDRESS,SALARY) "
            + "VALUES (3, 'Tom', 26, 'Norway', 22000.00 );";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO BUSINESS (ID,NAME,AGE,ADDRESS,SALARY) "
            + "VALUES (4, 'Mandy', 28, 'Rich-Mond ', 55000.00 );";
         stmt.executeUpdate(sql);

         stmt.close();
         c.commit();
         c.close();
      } catch (Exception e) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
   }
}