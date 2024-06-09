package com.lab_01.demo.rest;

import com.lab_01.demo.model.Estudiante;
import com.lab_01.demo.services.Impl.IEstudianteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class EstudianteController {

    /*
     * Consultar => GET
     * Grabar => POST
     * Actualizar => PUT(*) / PATCH
     * Eliminar => DELETE
     * */
    IEstudianteServices petServices;

    @Autowired
    public EstudianteController(IEstudianteServices petServices) {
        this.petServices=petServices;
    }

    @GetMapping("/Estudiantes")
    public List<Estudiante> getAll() {
        return petServices.GetAllPets();
    }

    @GetMapping("/Estudiante/{id}")
    public Estudiante getAll(@PathVariable int id) {
        return petServices.FindPetById(id);
    }

    @PostMapping("/Estudiante")
    public Estudiante savePet(@RequestBody Estudiante entity) {
        return petServices.SavePet(entity);
    }

    @PutMapping("/Estudiante")
    public Estudiante updatePet(@RequestBody Estudiante entity) {
        return petServices.UpdatePet(entity);
    }

    @DeleteMapping("/Estudiante/{id}")
    public Estudiante deletePetById(@PathVariable int id) {
        return petServices.DeletePetById(id);
    }


}
