package com.sare.entity;

import com.sare.utility.Brans;
import com.sare.utility.Cinsiyet;
import com.sare.utility.Durum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbldoktor")
public class Doktor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    String soyad;
    String email;
    String sifre;
    String telefon;
    String tckimlik;
    String il;
    String ilce;
    String adres;
    Integer yas;
    Cinsiyet cinsiyet;
    Brans brans;
    String ozgecmis;
    String resimUrl;
    Durum durum;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}