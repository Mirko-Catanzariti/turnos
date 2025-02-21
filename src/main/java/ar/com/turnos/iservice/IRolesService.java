package ar.com.turnos.iservice;

import ar.com.turnos.entities.Roles;

import java.util.List;

public interface IRolesService {
        List<Roles> getAll();
        List<Roles> findByDescrip(String descrip);
        Roles get(Integer id);
        void save(Roles entity);
        String delete(Roles entity);

}
