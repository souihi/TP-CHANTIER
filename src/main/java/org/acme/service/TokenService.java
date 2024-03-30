package org.acme.service;

import io.smallrye.jwt.build.Jwt;
import jakarta.inject.Singleton;

import java.util.Arrays;
import java.util.HashSet;

@Singleton
public class TokenService {

    public String generateToken(){
        return Jwt.issuer("tp_chantier")
                .subject("jdoe@quarkus.io")
                .groups(new HashSet<>(Arrays.asList("Chef de chantier", "Admin", "Ouvrier")))
                .expiresAt(System.currentTimeMillis()+3600).sign();
    }
}
