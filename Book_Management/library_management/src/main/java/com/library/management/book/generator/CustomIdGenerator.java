package com.library.management.book.generator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class CustomIdGenerator implements IdentifierGenerator {

    private static int current = 12; // This will simulate an auto-increment for simplicity

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        current++;
        return generateCustomId(current);
    }

    private String generateCustomId(int number) {
        // Prefix "BOOK-" with a zero-padded number (4 digits)
        return String.format("BOOK-%04d", number);
    }
}
