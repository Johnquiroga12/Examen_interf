package com.john.examenpracticom5a.controlador;

import com.john.examenpracticom5a.modelo.Empleado;
import com.john.examenpracticom5a.servicio.empleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class empleadoController {
    @Autowired
    private empleadoService ser;

    @GetMapping("/do/listar")
    public ResponseEntity<List<Empleado>> getAll() {
        try {
            return new ResponseEntity<>(ser.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/do/search/{id}")
    public ResponseEntity<Empleado> getById(@PathVariable("id") Integer id){
        try {
            return  new ResponseEntity<>(ser.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/do/crear")
    public ResponseEntity<Empleado> createReproducion(@RequestBody Empleado empleado){
        try {
            return new ResponseEntity<>(ser.save(empleado), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/do/delete/{id}")
    public ResponseEntity<?> deletesong(@PathVariable("id") Integer id) {
        try {
            ser.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar al docente");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/do/update/{id}")
    public ResponseEntity<Empleado> updateClient(@RequestBody Empleado empl, @PathVariable("id") Integer id){
        Empleado ca =ser.findById(id);

        if(ca == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                ca.setNombre(empl.getNombre());
                ca.setApellido(empl.getApellido());
                ca.setObservacion(empl.getObservacion());
                ca.setTelefono(empl.getTelefono());
                ca.setDireccion(empl.getDireccion());
                ca.setDias_trabajo(empl.getDias_trabajo());
                ca.setSueldo(empl.getSueldo());
                ca.setFecha_nacimiento(empl.getFecha_nacimiento());

                return new ResponseEntity<>(ser.save(empl), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
