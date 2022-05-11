package com.example.xaridor.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Xaridor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String ism;

    @Column(nullable = false)
    private String familya;

    @Column(nullable = false, unique = true)
    private String telraqam;

    @Column(nullable = false)
    private String manzil;
}
