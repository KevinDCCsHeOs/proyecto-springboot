package com.example.demo.web;


import com.example.demo.dto.AutoDTO;
import com.example.demo.form.AutoForm;
import com.example.demo.service.AutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autos")
@RequiredArgsConstructor
public class AutoController {

    @Autowired
    private AutoService autoService;

    @GetMapping("/all")
    public ResponseEntity<List<AutoDTO>> getAutos(){
        return ResponseEntity.ok(autoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutoDTO> getAutoByID(@PathVariable long id){
        return ResponseEntity.ok(autoService.getAutoDTOById(id));
    }

    @PostMapping
    public ResponseEntity<AutoDTO> create(@RequestBody AutoForm autoForm){
        return ResponseEntity.status(HttpStatus.CREATED).body(autoService.create(autoForm));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutoDTO> update(@PathVariable long id,@RequestBody AutoForm autoForm){
        return ResponseEntity.status(HttpStatus.CREATED).body(autoService.update(id, autoForm));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AutoDTO> delete(@PathVariable Integer id){
        return ResponseEntity.ok(autoService.delete(id));
    }

}
