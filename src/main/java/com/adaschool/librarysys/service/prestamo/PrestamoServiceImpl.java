package com.adaschool.librarysys.service.prestamo;

import com.adaschool.librarysys.models.Prestamo;
import com.adaschool.librarysys.models.User;
import com.adaschool.librarysys.repositories.PrestamoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PrestamoServiceImpl implements PrestamoService {
    private final PrestamoRepository loanRepository;

    private static final String LOAN_NOT_FOUND = "Prestamo no encontrado";

    @Value("${spring.profiles.active}")
    private String profile;

    @Override
    public Prestamo createLoan(String idBook, Prestamo prestamo) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String idUser = ((User) userDetails).getId();
        prestamo.setIdUsuario(idUser);
        prestamo.setIdLibro(idBook);
        validateIdFormat(idBook);
        return loanRepository.createLoan(prestamo);
    }

    @Override
    public List<Prestamo> getLoans() {
        return loanRepository.getLoans();
    }

    @Override
    public Prestamo findLoanById(String id) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String idUser = ((User) userDetails).getId();
        validateIdFormat(id);
        return loanRepository.findLoanById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(LOAN_NOT_FOUND)));
    }

    @Override
    public Prestamo updateLoan(String id, Prestamo prestamo) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String idUser = ((User) userDetails).getId();
        validateIdFormat(id);
        Prestamo existingLoan = loanRepository.findLoanById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(LOAN_NOT_FOUND)));
        return loanRepository.updateLoan(existingLoan);
    }

    @Override
    public void deleteLoan(String id) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String idUser = ((User) userDetails).getId();
        validateIdFormat(id);
        loanRepository.findLoanById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(LOAN_NOT_FOUND)));
        loanRepository.deleteLoan(id);
    }

    private void validateIdFormat(String idBook) {
        if (profile.equals("postgres")) {
            try {
                Long.parseLong(idBook);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Formato del id invalido para postgres: " + idBook);
            }
        }
    }
}