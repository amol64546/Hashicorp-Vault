//package com.hashicorp.vault;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.vault.core.VaultTemplate;
//
//@Component
//public class VaultTransit {
//
//  @Value("${transit.path}")
//  private String path;
//
//  @Value("${transit.key}")
//  private String key;
//
//
//  @Autowired
//  VaultTemplate vaultTemplate;
//
//  String encrypt(String data){
//    return vaultTemplate.opsForTransit(path).encrypt(key, data);
//  }
//
//  String decrypt(String data){
//    return vaultTemplate.opsForTransit(path).decrypt("details", data);
//  }
//
//
//}
//
