package com.adaschool.librarysys.repositories;

import com.adaschool.librarysys.models.Prestamo;

import java.util.List;
import java.util.Optional;

public interface PrestamoRepository {
    Prestamo createLoan(Prestamo prestamo);
    
    List<Prestamo> getLoans();
    
    Optional<Prestamo> findLoanById(String id);
    
    Prestamo updateLoan(Prestamo prestamo);
    
    void deleteLoan(String id);
}
