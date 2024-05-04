package com.example.pokedex_new;


import java.sql.Connection;
import java.sql.DriverManager;

public class dbcontroller
{
    public Connection databaseLink;

    public Connection getConnection()
    {
        String databaseName = "fateen_nr";
        String databaseUser = "root";
        String databasePassword = "newcomers??";

        String url = "jdbc:mysql://localhost/"+ databaseName;


        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return databaseLink;
    }


}