package com.john.examenpracticom5a.repositoryo;

import com.john.examenpracticom5a.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface empleadoRepository extends JpaRepository<Empleado, Integer> {
}
