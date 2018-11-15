package com.example.store.controller;

import com.example.store.RecordNotFoundException;
import com.example.store.model.Seller;
import com.example.store.repository.SellerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class SellerController {
    private final SellerRepository repository;

    SellerController(SellerRepository repository){
        this.repository = repository;
    }

    @GetMapping("/sellers")
    List<Seller> all(){
        return repository.findAll();
    }

    @RequestMapping("/sellers")
    @ResponseBody
    Seller newSeller(Seller newSeller){
        return repository.save(newSeller);
    }

    // single items

    @GetMapping("/sellers/{id}")
    Seller one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

//    @RequestMapping("/sellers/{id}")
//    @ResponseBody
//    Seller replaceSeller(@PathVariable Long id, Seller seller){
//        return repository.save(seller);
//    }


    @PutMapping("/sellers/{id}")
    @ResponseBody
    Seller changeSeller(Seller newSeller, @PathVariable Long id) {
        return repository.findById(id).map(seller -> {
            seller.setName(newSeller.getName());
            return repository.save(seller);
        }).orElseGet(() -> {
            newSeller.setId(id);
            return repository.save(newSeller);
        });
    }

    @DeleteMapping("/sellers/{id}")
    void deleteSeller(@PathVariable Long id){
        repository.deleteById(id);
    }
}

