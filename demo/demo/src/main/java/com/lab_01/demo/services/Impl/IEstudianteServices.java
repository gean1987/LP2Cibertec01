package com.lab_01.demo.services.Impl;

import com.lab_01.demo.model.Estudiante;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IEstudianteServices {
    List<Estudiante> GetAllPets();
    Estudiante SavePet(Estudiante entity);
    Estudiante UpdatePet(Estudiante entity);
    Estudiante FindPetById(int id);
    Estudiante DeletePetById(int id);
    List<Estudiante> SearchPets(String name);
}
