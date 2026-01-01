package com.sare.entity;

import com.sare.utility.RandevuDurumu;
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
@Table(name = "tblrandevu")
public class Randevu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long kullaniciId;
    String brans;
    String doktor;
    String randevuGunu;
    String randevuSaati;
    RandevuDurumu state;
}
