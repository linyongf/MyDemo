package com.linyf.demo.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class JwtDemo {
    public static void main(String[] args) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] secretBytes = DatatypeConverter.parseBase64Binary("linyf");
        Key secretKeySpec = new SecretKeySpec(secretBytes, signatureAlgorithm.getJcaName());
        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put("name", "zhangsan");
        claimsMap.put("age", 18);

        JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject("subject")
                .setIssuer("issuer")
                .addClaims(claimsMap)
                .signWith(signatureAlgorithm, secretKeySpec);

        System.out.println(jwtBuilder.compact());
    }
}
