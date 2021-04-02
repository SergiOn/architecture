package com.so.security;

import java.security.Principal;

public interface TokenPrincipal extends Principal {
    Long getUserId();
    String token();
}
