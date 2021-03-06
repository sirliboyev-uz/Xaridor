package com.example.xaridor.Service;

import com.example.xaridor.Model.Xaridor;
import com.example.xaridor.Repository.XaridorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class XaridorService {
    @Autowired
    XaridorRepository xaridorRepository;
    public Boolean xaridorJoylash(Xaridor xaridor){
        boolean telRaqam = xaridorRepository.existsByTelraqam(xaridor.getTelraqam());
        if (telRaqam){
            return false;
        }
        Xaridor xaridor1 = new Xaridor();
        xaridor1.setFamilya(xaridor.getFamilya());
        xaridor1.setIsm(xaridor.getIsm());
        xaridor1.setTelraqam(xaridor.getTelraqam());
        xaridor1.setManzil(xaridor.getManzil());
        xaridorRepository.save(xaridor1);
        return true;
    }

    public List<Xaridor> xaridorlar(){
        List<Xaridor> list = xaridorRepository.findAll();
        return list;
    }

    public Xaridor xaridor(Integer id){
        Optional<Xaridor> optionalXaridor = xaridorRepository.findById(id);
//        if (optionalXaridor.isPresent()){
//            Xaridor xaridor = optionalXaridor.get();
//            return xaridor;
//        }
//        return null;

        return optionalXaridor.orElse(null);
    }

    public String ochirish(Integer id){
        Optional<Xaridor> optionalXaridor = xaridorRepository.findById(id);
        if (optionalXaridor.isPresent()){
            xaridorRepository.deleteById(id);
            return "Ochirildi!";
        }
        return "Bunday xaridor mavjud emas";
    }
    public String yangilash(Xaridor xaridor, Integer id){
        Optional<Xaridor> optionalXaridor = xaridorRepository.findById(id);
        boolean b = xaridorRepository.existsByTelraqamAndIdNot(xaridor.getTelraqam(), id);
        if (b){
            return "Bunday xaridor mavjud";
        }
        if (optionalXaridor.isPresent()){
            Xaridor xaridor1 = optionalXaridor.get();
            xaridor1.setFamilya(xaridor.getFamilya());
            xaridor1.setIsm(xaridor.getIsm());
            xaridor1.setTelraqam(xaridor.getTelraqam());
            xaridor1.setManzil(xaridor.getManzil());
            xaridorRepository.save(xaridor1);
            return "Muvaffaqiyatli yangilandi!";
        }
        else return "Topilmadi";
    }
}
