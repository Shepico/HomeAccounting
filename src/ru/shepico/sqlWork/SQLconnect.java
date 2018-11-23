package ru.shepico.sqlWork;

import ru.shepico.homeacc.ConstantAccount;
import ru.shepico.homeacc.directories.Currency;

import java.sql.*;
import java.util.ArrayList;

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
            connect = DriverManager.getConnection("jdbc:sqlite:" + ConstantAccount.NAME_DB + ".db");
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

    public ArrayList<Currency> selectData(String query, String typeCatalog) {
        ArrayList<Currency> arrCurrency = null;
        connect = openDB();


        if (connect != null) {
            try {
                stmt = connect.createStatement();
                //String sql = "INSERT INTO " + db + "(ID,NAME,AGE,ADDRESS,SALARY) " +
                //            "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
                ResultSet rs = stmt.executeQuery(query);

               /* while ( rs.next() ) {
                    int id = rs.getInt("crcy_id");
                    String name = rs.getString("crcy_name");
                    System.out.println( "ID = " + id );
                    System.out.println( "NAME = " + name );
                }*/
               if (typeCatalog.equals("Currency")) {
                    arrCurrency = fillCurrency(rs);
               }
                rs.close();

                stmt.close();
                connect.commit();
                connect.close();
                return arrCurrency;
            } catch (SQLException e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
        return arrCurrency;
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

    //
    private ArrayList<Currency> fillCurrency (ResultSet result) {
        Currency next;
        ArrayList<Currency> arrCurrency = null;

        try {
            //result.last();
            //int count = result.getRow();
        //    arrCurrency = new ArrayList<>();
            //result.first();
             while (result.next() ) {
                 /*int id = result.getInt("id");
                 String name = result.getString("name");
                 System.out.println( "ID = " + id );
                 System.out.println( "NAME = " + name );*/
                 next = new Currency(result.getInt("id"), result.getString("name"));
                 arrCurrency.add(next);
             }
            return arrCurrency;
        } catch (SQLException e) {
             System.err.println(e.getClass().getName() + ": " + e.getMessage());
             System.exit(0);
        }finally {
            return arrCurrency;
        }
    }
}


