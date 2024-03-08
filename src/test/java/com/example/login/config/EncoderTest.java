package com.example.login.config;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EncoderTest {

    @Test
    public void testEncode() {
        Encoder encoder = new Encoder();
        // Test encoding with offset 'B'
        String encoded = encoder.encode("HELLO WORLD", 'B');
        assertEquals("BGDKKN VNQKC", encoded, "Encoding with offset 'B' should work");
    }

    @Test
    public void testDecode() {
        Encoder encoder = new Encoder();
        // Test decoding
        String decoded = encoder.decode("BGDKKN VNQKC");
        assertEquals("HELLO WORLD", decoded, "Decoding should return original text");
    }

    @Test
    public void testInvalidOffsetEncode() {
        Encoder encoder = new Encoder();
        // Test encoding with an invalid offset character
        assertThrows(IllegalArgumentException.class, () -> encoder.encode("HELLO WORLD", '#'),
                "Encoding with an invalid offset should throw IllegalArgumentException");
    }

    @Test
    public void testInvalidCharacterEncode() {
        Encoder encoder = new Encoder();
        // Test encoding with an invalid character in the input
        assertThrows(IllegalArgumentException.class, () -> encoder.encode("HELLO_WORLD", 'B'),
                "Encoding text with an invalid character should throw IllegalArgumentException");
    }
}
