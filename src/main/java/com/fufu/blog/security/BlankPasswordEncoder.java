package com.fufu.blog.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class BlankPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence);
    }
}
