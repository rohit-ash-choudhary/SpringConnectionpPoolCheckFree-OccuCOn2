package com.sp.springJDBC.SpringConnectionPooling;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sp.resource.SpringConfigFile;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfigFile.class);
        JdbcTemplate jdt=context.getBean(JdbcTemplate.class);
        String sql_query="Insert into account values(?,?,?,?)";
        Object[] params= {22,"None","Slec",100};
        Object[] params2= {12,"ne","ec",2100};
        int count1=jdt.update(sql_query,params ) ; /* this is internally sent request to to DataSource to get connection then its excute query return back
        connection to the DataSource */
        int count2=jdt.update(sql_query,params2 ) ;
        
        if(count1 >0 && count2>0)
        {
        	System.out.println("SuccessFully Update");
        }
        else{
        	System.out.println("Failed to Update");
        }
        
//        Connection con1=ds.getConnection();
//        Connection con2=ds.getConnection();
//        Connection con3=ds.getConnection();
//        Connection con4=ds.getConnection();
//        Connection con5=ds.getConnection();
//        con5.close();
//        con4.close();
//        Connection con6=ds.getConnection();
//        int active_con=ds.getHikariPoolMXBean().getActiveConnections();
//        int ideal_con=ds.getHikariPoolMXBean().getIdleConnections();
//        int total_con=ds.getHikariPoolMXBean().getTotalConnections();
//        System.out.println(" active_con  :"+active_con);
//        System.out.println(" ideal_con  :"+ideal_con);
//        System.out.println(" total_con  :"+total_con);
//        System.out.println("Success");
        
    }
}
