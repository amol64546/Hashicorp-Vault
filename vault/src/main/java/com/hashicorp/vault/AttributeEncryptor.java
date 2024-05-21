package com.hashicorp.vault;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Converter
public class AttributeEncryptor implements AttributeConverter<String, String> {

    private static VaultEncryptionUtil vaultEncryptionUtil;

    @Autowired
    public void setVaultEncryptionUtil(VaultEncryptionUtil vaultEncryptionUtil) {
        AttributeEncryptor.vaultEncryptionUtil = vaultEncryptionUtil;
    }

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return vaultEncryptionUtil.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return vaultEncryptionUtil.decrypt(dbData);
    }
}
