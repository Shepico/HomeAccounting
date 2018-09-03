package ru.shepico.sqlWork;

import java.sql.*;

public class SQLconnect {
    private Connection connect;
    private Statement stmt;

    public SQLconnect() {
        connect = null;
        stmt = null;
    }

    private Connection openDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:accDB.db");
            connect.setAutoCommit(false);
            //System.out.println("Opened database successfully");
            return (connect);
            //connect.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return null;
    }

    public boolean selectData(String query) {
        connect = openDB();
        if (connect != null) {
            try {
                stmt = connect.createStatement();
                //String sql = "INSERT INTO " + db + "(ID,NAME,AGE,ADDRESS,SALARY) " +
                //            "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
                ResultSet rs = stmt.executeQuery(query);
                while ( rs.next() ) {
                    int id = rs.getInt("crcy_id");
                    String name = rs.getString("crcy_name");
                    System.out.println( "ID = " + id );
                    System.out.println( "NAME = " + name );
                }
                rs.close();

                stmt.close();
                connect.commit();
                connect.close();
                return true;
            } catch (SQLException e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
        return false;
    }

    public boolean insertData(String query) {
        connect = openDB();
        if (connect != null) {
            try {
                stmt = connect.createStatement();
                //String sql = "INSERT INTO " + db + "(ID,NAME,AGE,ADDRESS,SALARY) " +
                //            "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
                stmt.executeUpdate(query);
                stmt.close();
                connect.commit();
                connect.close();
                return true;
            } catch (SQLException e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
        return false;
    }

    public boolean removeData(String query) {
        return false;
    }

    public boolean changeData(String query) {
        return false;
    }

}


