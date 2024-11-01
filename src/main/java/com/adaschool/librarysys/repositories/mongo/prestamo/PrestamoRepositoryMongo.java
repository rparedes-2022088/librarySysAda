package com.adaschool.librarysys.repositories.mongo.prestamo;

import com.adaschool.librarysys.models.Prestamo;
import com.adaschool.librarysys.models.mongo.PrestamoMongo;
import com.adaschool.librarysys.repositories.PrestamoRepository;
import com.adaschool.librarysys.util.caster.PrestamoCaster;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Profile("mongo")
@RequiredArgsConstructor
@Service
public class PrestamoRepositoryMongo implements PrestamoRepository {
    private final PrestamoRepositoryNoSql loanRepositoryNoSql;
    
    private final PrestamoCaster loanCaster;
    
    @Override
    public Prestamo createLoan(Prestamo prestamo) {
        PrestamoMongo loanMongo = loanCaster.loanToLoanMongo(prestamo);
        PrestamoMongo newMongo = loanRepositoryNoSql.save(loanMongo);
        return loanCaster.loanMongoToLoan(newMongo);
    }

    @Override
    public List<Prestamo> getLoans() {
        return loanRepositoryNoSql.findAll().stream()
                .map(loanCaster::loanMongoToLoan)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Prestamo> findLoanById(String id) {
        // Busca el préstamo en la base de datos y convierte el resultado a Prestamo
        Optional<PrestamoMongo> loanMongo = loanRepositoryNoSql.findById(id);
        return loanMongo.map(loanCaster::loanMongoToLoan);
    }

    @Override
    public Prestamo updateLoan(Prestamo prestamo) {
        PrestamoMongo loanMongo = loanCaster.loanToLoanMongo(prestamo);
        PrestamoMongo newMongo = loanRepositoryNoSql.save(loanMongo);
        return loanCaster.loanMongoToLoan(newMongo);
    }
    
    @Override
    public void deleteLoan(String id) {
        loanRepositoryNoSql.deleteById(id);
    }
}
