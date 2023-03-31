package com.stl.ManagerLogin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stl.ManagerLogin.model.Loginmodel;
import com.stl.ManagerLogin.repository.ManagerRepo;

@Service
public class ManagerlogService implements UserDetailsService{
    @Autowired
    ManagerRepo managerrepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Loginmodel manager = managerrepo.findById(username).get();
        if(manager == null) {
            return null;
        }
        
        return new Managerlog(manager);
    }
    
}
