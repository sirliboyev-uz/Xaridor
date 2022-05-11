package com.example.xaridor.Repository;

import com.example.xaridor.Model.Xaridor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XaridorRepository extends JpaRepository<Xaridor, Integer> {
    boolean existsByTelraqam(String raqam);
    boolean existsByTelraqamAndIdNot(String telraqam, Integer id);
}
