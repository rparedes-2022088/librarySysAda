package com.adaschool.librarysys.repositories.sql.prestamo;

import com.adaschool.librarysys.models.Prestamo;
import com.adaschool.librarysys.models.post.PrestamoPost;
import com.adaschool.librarysys.repositories.PrestamoRepository;
import com.adaschool.librarysys.util.caster.PrestamoCaster;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Profile("postgres")
@RequiredArgsConstructor
@Repository
public class PrestamoRepositoryPost implements PrestamoRepository {
    private final PrestamoRepositorySql loanRepositoryJpa;
    private final PrestamoCaster loanCaster; 

    @Override
    public Prestamo createLoan(Prestamo prestamo) {
        PrestamoPost loanPostgres = loanCaster.loanToLoanPostgres(prestamo);
        PrestamoPost newLoan = loanRepositoryJpa.save(loanPostgres);
        return loanCaster.loanPostgresToLoan(newLoan);
    }

    @Override
    public List<Prestamo> getLoans() {
        return loanRepositoryJpa.findAll().stream()
                .map(loanCaster::loanPostgresToLoan)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Prestamo> findLoanById(String id) {
        Optional<PrestamoPost> loanPostgres = loanRepositoryJpa.findById(Long.parseLong(id));
        return loanPostgres.map(loanCaster::loanPostgresToLoan);
    }

    @Override
    public Prestamo updateLoan(Prestamo prestamo) {
        PrestamoPost loanPostgres = loanCaster.loanToLoanPostgres(prestamo);
        PrestamoPost newLoan = loanRepositoryJpa.save(loanPostgres);
        return loanCaster.loanPostgresToLoan(newLoan);
    }

    @Override
    public void deleteLoan(String id) {
        loanRepositoryJpa.deleteById(Long.parseLong(id));
    }
}