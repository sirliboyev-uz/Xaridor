package com.example.xaridor.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Xaridor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull(message = "Ism bo'sh bo'lmasligi kerak")
    private String ism;

    @Column(nullable = false)
    @NotNull(message = "Familya bo'sh bo'lmasligi kerak")
    private String familya;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Telefon raqam bo'sh bo'lmasligi kerak")
    private String telraqam;

    @Column(nullable = false)
    @NotNull(message = "Manzil bo'sh bo'lmasligi kerak")
    private String manzil;
}
