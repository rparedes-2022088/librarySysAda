package com.adaschool.librarysys.controller;

import com.adaschool.librarysys.models.Prestamo;
import com.adaschool.librarysys.service.prestamo.PrestamoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/loan")
public class PrestamoController {
    private final PrestamoService loanService;
    
    @PostMapping("/{idBook}")
    public ResponseEntity<Prestamo> createLoan(@PathVariable String idBook, @RequestBody Prestamo loan) {
        Prestamo newLoan = loanService.createLoan(idBook, loan);
        return new ResponseEntity<>(newLoan, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Prestamo>> getAllLoans() {
        List<Prestamo> loanPostgres = loanService.getLoans();
        return new ResponseEntity<>(loanPostgres, HttpStatus.OK);
    }
    
    @GetMapping("/{idBook}")
    public ResponseEntity<Prestamo> getLoanById(@PathVariable String idBook) {
        Prestamo loan = loanService.findLoanById(idBook);
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }
    
    @PutMapping("/{idBook}")
    public ResponseEntity<Prestamo> updateLoan(@PathVariable String idBook, @RequestBody Prestamo loan) {
        Prestamo newLoan = loanService.updateLoan(idBook, loan);
        return new ResponseEntity<>(newLoan, HttpStatus.OK);
    }
    
    @DeleteMapping("/{idBook}")
    public ResponseEntity<Map<String, String>> deleteLoan(@PathVariable String idBook) {
        loanService.deleteLoan(idBook);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Prestamo deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
