package com.stl.ManagerLogin.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.stl.ManagerLogin.model.Loginmodel;

@SuppressWarnings("serial")
public class Managerlog implements UserDetails{
    Loginmodel manager = new Loginmodel();
    
    public Managerlog(Loginmodel manager){
        this.manager=manager;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("MANAGER"));
    }

    @Override
    public String getPassword() {
        return manager.getPassword();
    }

    

    @Override
    public String getUsername() {
        return manager.getManageremail();
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
