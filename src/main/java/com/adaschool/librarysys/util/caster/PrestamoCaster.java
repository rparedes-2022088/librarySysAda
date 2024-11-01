package com.adaschool.librarysys.util.caster;

import com.adaschool.librarysys.models.Prestamo;
import com.adaschool.librarysys.models.mongo.PrestamoMongo;
import com.adaschool.librarysys.models.post.PrestamoPost;
import org.springframework.stereotype.Component;

@Component
public class PrestamoCaster {
    public PrestamoPost loanToLoanPostgres(Prestamo prestamo) {
        PrestamoPost prestamoPost = new PrestamoPost();
        prestamoPost.setId((prestamo.getId() != null && !prestamo.getId().isEmpty())
                ? Long.parseLong(prestamo.getId()) : null);
        prestamoPost.setIdUsuario((prestamo.getIdUsuario() != null && !prestamo.getIdUsuario().isEmpty())
                ? Long.parseLong(prestamo.getIdUsuario()) : null);
        prestamoPost.setIdLibro((prestamo.getIdLibro() != null && !prestamo.getIdLibro().isEmpty())
                ? Long.parseLong(prestamo.getIdLibro()) : null);
        return prestamoPost;
    }
    
    public Prestamo loanPostgresToLoan(PrestamoPost prestamoPost) {
        Prestamo prestamo = new Prestamo();
        prestamo.setIdUsuario(String.valueOf(prestamoPost.getIdUsuario()));
        prestamo.setIdLibro(String.valueOf(prestamoPost.getIdLibro()));
        return prestamo;
    }
    
    public PrestamoMongo loanToLoanMongo(Prestamo prestamo) {
        PrestamoMongo prestamoMongo = new PrestamoMongo();
        prestamoMongo.setId(prestamo.getId());
        prestamoMongo.setIdUsuario(prestamo.getIdUsuario());
        prestamoMongo.setIdLibro(prestamo.getIdLibro());
        return prestamoMongo;
    }
    
    public Prestamo loanMongoToLoan(PrestamoMongo prestamoMongo) {
        Prestamo prestamo = new Prestamo();
        prestamo.setIdUsuario(prestamoMongo.getIdUsuario());
        prestamo.setIdLibro(prestamoMongo.getIdLibro());
        return prestamo;
    }
}
