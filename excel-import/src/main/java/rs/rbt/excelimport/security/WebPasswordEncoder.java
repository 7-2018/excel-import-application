package rs.rbt.excelimport.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * The type Web password encoder.
 */
public class WebPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return charSequence.toString().equals(s);
    }
}