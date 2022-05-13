package com.example.xaridor.Controller;

import com.example.xaridor.Model.Xaridor;
import com.example.xaridor.Service.XaridorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/xaridor")
public class XaridorController {

    @Autowired
    XaridorService xaridorService;
    @PostMapping("/joylash")
    public ResponseEntity xaridorJoylash(@Valid @RequestBody Xaridor xaridor){
        Boolean s = xaridorService.xaridorJoylash(xaridor);
        if (s){
            return ResponseEntity.status((HttpStatus.OK)).body(s);
        }
        return ResponseEntity.status((HttpStatus.BAD_REQUEST)).body(s);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @GetMapping("/chiqarish")
    public ResponseEntity<?> xaridorlarniChiqarish(){
        return ResponseEntity.ok(xaridorService.xaridorlar());
    }
    @GetMapping("/chiqarish/{id}")
    public Xaridor xaridorniChiqarish(@PathVariable Integer id){
        return xaridorService.xaridor(id);
    }
    @DeleteMapping("/ochirish/{id}")
    public ResponseEntity<?> xaridorniOchirish(@PathVariable Integer id){
        return ResponseEntity.ok(xaridorService.ochirish(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> xaridorYangilash(@Valid @RequestBody Xaridor xaridor, @PathVariable Integer id){
        return ResponseEntity.ok(xaridorService.yangilash(xaridor, id));
    }
}
