package com.example.demo;
import javax.transaction.Transactional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
@Service
@Transactional
public class VendorService {
	@Autowired
    private VendorRepository repo;
	@Autowired
    private VendorDAO dao;
    
    public String authenticate(String user,String pwd) {
        return dao.authenticate(user, pwd);
    }
    public Vendor authenv(String user) {
        return dao.authenv(user);
    }
    
    public List<Vendor> showVendor() {
        return repo.findAll();
    }
    
    public Vendor get(Integer id) {
        return repo.findById(id).get();
       
    }
    public String addvendor(Vendor ven) {
    	return dao.addvendor(ven);
    }

    
}
	   
