package com.example.xaridor.Controller;

import com.example.xaridor.Model.Xaridor;
import com.example.xaridor.Service.XaridorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/xaridor")
public class XaridorController {

    @Autowired
    XaridorService xaridorService;
    @PostMapping("/joylash")
    public String xaridorJoylash(@RequestBody Xaridor xaridor){
        return xaridorService.xaridorJoylash(xaridor);
    }

    @GetMapping("/chiqarish")
    public List<Xaridor> xaridorlarniChiqarish(){
        return xaridorService.xaridorlar();
    }
    @GetMapping("/chiqarish/{id}")
    public Xaridor xaridorniChiqarish(@PathVariable Integer id){
        return xaridorService.xaridor(id);
    }
    @DeleteMapping("/ochirish/{id}")
    public String xaridorniOchirish(@PathVariable Integer id){
        return xaridorService.ochirish(id);
    }
    @PutMapping("/{id}")
    public String xaridorYangilash(@RequestBody Xaridor xaridor, @PathVariable Integer id){
        return xaridorService.yangilash(xaridor, id);
    }
}
