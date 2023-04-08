package com.example.demo.security;

import com.example.demo.security.anotation.IAuthenticationFacade;
import org.springframework.security.core.Authentication;

public class AuthenticationFacade implements IAuthenticationFacade {
    @Override
    public Authentication getAuthontication() {
        return null;
    }
}
