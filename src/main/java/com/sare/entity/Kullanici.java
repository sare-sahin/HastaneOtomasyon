package com.sare.entity;

import com.sare.utility.Cinsiyet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbluserprofile")
public class Kullanici {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    String soyad;
    String email;
    String sifre;
    String telefon;
    String adres;
    String tckimlik;
    Integer yas;
    Cinsiyet cinsiyet;
}