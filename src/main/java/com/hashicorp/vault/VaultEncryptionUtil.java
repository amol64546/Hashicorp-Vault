package com.hashicorp.vault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.core.VaultTransitOperations;

@Component
public class VaultEncryptionUtil {

    @Value("${transit.path}")
    private String path;

    @Value("${transit.key}")
    private String key;

    private final VaultTransitOperations transitOperations;

    @Autowired
    public VaultEncryptionUtil(VaultTemplate vaultTemplate) {
        this.transitOperations = vaultTemplate.opsForTransit();
    }

    public String encrypt(String plaintext) {
        return transitOperations.encrypt(key, plaintext);
    }

    public String decrypt(String ciphertext) {
        return transitOperations.decrypt(key, ciphertext);
    }
}
