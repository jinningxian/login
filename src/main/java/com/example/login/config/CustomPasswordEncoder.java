package com.example.login.config;


import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {

    private final Encoder encoder;
    private final char offset;

    public CustomPasswordEncoder(char offset) {
        this.encoder = new Encoder();
        this.offset = offset;
    }

    @Override
    public String encode(CharSequence rawPassword) {
/*        System.out.println("CustomPasswordEncoder: " + rawPassword.toString());
        System.out.println("EncodePasswordEncoder: " + encoder.encode(rawPassword.toString(), offset));*/
        return encoder.encode(rawPassword.toString(), offset);
    }

/*    // encode password
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String encodedRawPassword = encode(rawPassword);
        return encodedRawPassword.equals(encodedPassword);
    }*/

    // decode method to compare password
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // ensure encoded password at least 2 chars (1 offset)
        if (encodedPassword == null || encodedPassword.length() < 2)
            return false;

        String decodedPassword = encoder.decode(encodedPassword);
        return decodedPassword.equals(rawPassword.toString());
    }

}

