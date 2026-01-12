package com.sare.config;

import com.sare.entity.Kullanici;
import com.sare.entity.Rol;
import com.sare.service.KullaniciService;
import com.sare.service.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
    private final RolService rolService;

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
        List<Rol> rolListesi = rolService.rolBulKullaniciIdyeGore(kullaniciId);                //Rol servisinden kullaniciId sine ait rollerin listesini çekiyoruz.
        rolListesi.forEach(r->{
            grantedAuthorities.add(new SimpleGrantedAuthority(r.getRoller().toString()));      //Gelen rol listesini GrantedAuthority içerisine ekliyoruz.
        });



        return User.builder()
                .username(kullanici.get().getEmail())
                .password(kullanici.get().getSifre())
                .accountLocked(false)                      //Hesap kilitli mi, değil.
                .accountExpired(false)                     //Hesabın süresi doldu mu, hayır.
                .authorities(grantedAuthorities)           //Hesabın yetkilerinin listesi nelerdir?
                .build();
    }


}
