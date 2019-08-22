package sample;

import java.sql.*;
import java.util.ArrayList;

public class Database {


    private final String URL = "jdbc:sqlite:user.db";

    private Connection Connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Fails here!");
        }

        return conn;
    }


    public Database() {

            String sqlCreate = "CREATE TABLE IF NOT EXISTS info (" +
                    "wName TEXT NOT NULL PRIMARY KEY, username TEXT, password TEXT, email TEXT, websiteUrl TEXT, info TEXT);";

            ExecuteStatement(sqlCreate);




    }

    //Gets result set from
    public ResultSet GetResultSet(String sql) {
        Connection conn = Connect();

        try {

            Statement statement = conn.createStatement();

            return statement.executeQuery(sql);


        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }


    public void ExecuteStatement(String sql) {
        try {
            Connection connection = Connect();
            Statement state = connection.createStatement();
            state.execute(sql);

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void Insert(String sql) {

    }

    public void Insert(String sql, int numVariables, String[] variableAssignments) {
        try {

            Connection conn = Connect();
            PreparedStatement statement = conn.prepareStatement(sql);


            for (int i = 0; i < numVariables; i++) {
                statement.setString(i + 1, variableAssignments[i]);
            }

            statement.executeUpdate();

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }




    public void Delete(String sql, String text) {
        //Get connection and create preparedstatement to delete name from textedit.
        try {
            Connection conn = Connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);


            pstmt.setString(1, text);
            pstmt.executeUpdate();

            //Anyting that goes wrong goes under here.
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Delete is unsuccessful.");
        }
    }


    public ArrayList<Node> GetVector() {
        String sql = "SELECT * FROM info ORDER BY wName ASC;";
        ResultSet rs = GetResultSet(sql);
        ArrayList<Node> list = new ArrayList(0);
        try {
            while (rs.next()) {
                Node k = new Node(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(k);

            }

            rs.close();

        }catch (Exception e) {
            e.printStackTrace();

        }

        return list;

    }

}
