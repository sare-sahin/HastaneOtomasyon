package com.sare.entity;

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
@Table(name = "tblmuayene")
public class Muayene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long hastaId;
    Long doktorId;
    Boolean muayeneYapildiMi;
    String hastalikOykusu;
    String tani;
    Long receteNo;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}