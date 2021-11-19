package com.example.demo;
import java.security.interfaces.RSAKey;


import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDAO {

	@Autowired  
    JdbcTemplate jdbc;  
	public int generateId()
	{
		String cmd="select max(cid) from customer";
		List li=jdbc.query(cmd , new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					return rs.getInt(1)+1;
			}
			
		});
		return (int) li.get(0);
	}
    public String authenticate(String user,String pwd) {
        String cmd = "select count(*) cnt from customer where cusername=? "
                + " AND cpassword=?";
        List str=jdbc.query(cmd,new Object[] {user,pwd}, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
                return rs.getInt("cnt");
            }
            
        });
        return str.get(0).toString();
    }
    public customer authen(String user) {
		String cmd = "select * from customer where cusername=? ";
        List<customer> str=jdbc.query(cmd,new Object[] {user}, new RowMapper<customer>() {
            @Override
            public customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
            	customer c=new customer();
				c.setCid(rs.getInt("cid"));
				c.setCname(rs.getString("cname"));
				c.setCphno(rs.getString("cphno"));
				c.setCusername(rs.getString("cusername"));
				c.setCpassword(rs.getString("cpassword"));
				c.setCemail(rs.getString("cemail"));
				return c;
            }
            
        });
        return str.get(0);
    }
    public String addcustomer(customer cus) {
    	int id=generateId();
    	String cmd = "insert into customer(cid,cname,cphno,cusername,cpassword,cemail) values(?,?,?,?,?,?)";
    	 jdbc.update(cmd,id,cus.getCname(),cus.getCphno(),
    			 cus.getCusername(), 
    			 cus.getCpassword(),cus.getCemail());
    	 SendEmail.sendemail1();
    	 return "Account created Succesfully";
    	
    }
    
}
