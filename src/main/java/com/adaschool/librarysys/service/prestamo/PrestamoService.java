package com.adaschool.librarysys.service.prestamo;

import com.adaschool.librarysys.models.Prestamo;

import java.util.List;

public interface PrestamoService {
    Prestamo createLoan(String idBook, Prestamo prestamo);
    List<Prestamo> getLoans();
    Prestamo findLoanById(String idBook);
    Prestamo updateLoan(String idBook, Prestamo prestamo);
    void deleteLoan(String idBook);
}
