package com.john.examenpracticom5a.servicio;

import com.john.examenpracticom5a.modelo.Empleado;
import com.john.examenpracticom5a.repositoryo.empleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class empleadoServiceImpl extends GenericServiceImpl<Empleado, Integer> implements empleadoService {
    @Autowired
    private empleadoRepository Repository;

    @Override
    public CrudRepository<Empleado, Integer> getDao() {
        return Repository;
    }
}
