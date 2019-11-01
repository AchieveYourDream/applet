package com.kute.appletgateway.jwt;


import java.io.Serializable;
import java.util.Collection;

public interface UserDetails  extends Serializable {

    Collection getAuthorities();

    String getPassword();

    String getUsername();

    boolean isAccountNonExpired();

    boolean isAccountNonLocked();

    boolean isCredentialsNonExpired();

    boolean isEnabled();
}
