package com.greening_india.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CustomerUserPrincipal{

    private UUID userId;
    private String email;

    public void CustomUserPrincipal(UUID userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public UUID getUserId() {
        return userId;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(); // no roles for now
    }

    public String getPassword() {
        return null; // not needed
    }

    public String getUsername() {
        return email;
    }

    public boolean isAccountNonExpired() { return true; }
    public boolean isAccountNonLocked() { return true; }
    public boolean isCredentialsNonExpired() { return true; }
    public boolean isEnabled() { return true; }
}
