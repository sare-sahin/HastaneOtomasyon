package com.sare.config;

import com.sare.entity.Kullanici;
import com.sare.service.KullaniciService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JwtUserDetails implements UserDetailsService {
    private final KullaniciService kullaniciService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


    public UserDetails loadUserById(Long kullaniciId) {
        Optional<Kullanici> kullanici = kullaniciService.kullaniciBulIdyeGore(kullaniciId);    //Bu id ye sahip bir kullanıcı var mı?
        if(kullanici.isEmpty())                                                                //Kullanıcı yoksa boş dön.
            return null;
                                                                                               //Kullanıcı var ise kullanıcının detay bilgilerine bakıyoruz.
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();                         //Kullanıcının yetkileri neler?

        return User.builder()
                .username(kullanici.get().getEmail())
                .password(kullanici.get().getSifre())
                .accountLocked(false)                      //Hesap kilitli mi, değil.
                .accountExpired(false)                     //Hesabın süresi doldu mu, hayır.
                .authorities(grantedAuthorities)           //Hesabın yetkilerinin listesi nelerdir?
                .build();
    }


}
