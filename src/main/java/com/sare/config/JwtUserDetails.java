package com.sare.config;

import com.sare.entity.Hasta;
import com.sare.entity.Rol;
import com.sare.service.HastaService;
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
    private final HastaService hastaService;
    private final RolService rolService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


    public UserDetails loadUserById(Long hastaId) {
        Optional<Hasta> hasta = hastaService.hastaBulIdyeGore(hastaId);                        //Bu id ye sahip bir hasta var mı?
        if(hasta.isEmpty())                                                                    //Hasta yoksa boş dön.
            return null;
                                                                                               //Hasta var ise hastanın detay bilgilerine bakıyoruz.
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();                         //Hastanın yetkileri neler?
        List<Rol> rolListesi = rolService.rolBulHastaIdyeGore(hastaId);                        //Rol servisinden hastaId sine ait rollerin listesini çekiyoruz.
        rolListesi.forEach(r->{
            grantedAuthorities.add(new SimpleGrantedAuthority(r.getRoller().toString()));      //Gelen rol listesini GrantedAuthority içerisine ekliyoruz.
        });



        return User.builder()
                .username(hasta.get().getEmail())
                .password(hasta.get().getSifre())
                .accountLocked(false)                      //Hesap kilitli mi, değil.
                .accountExpired(false)                     //Hesabın süresi doldu mu, hayır.
                .authorities(grantedAuthorities)           //Hesabın yetkilerinin listesi nelerdir?
                .build();
    }


}
