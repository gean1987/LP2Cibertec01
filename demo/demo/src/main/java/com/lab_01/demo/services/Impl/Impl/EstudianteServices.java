package com.lab_01.demo.services.Impl.Impl;

import com.lab_01.demo.model.Estudiante;
import com.lab_01.demo.repository.IEstudianteRepository;
import com.lab_01.demo.services.Impl.IEstudianteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



// LOGICA DE NEGOCIO (VALIDACIONES; CONVERTIR OBJETOS, PROCESAR INFORMACION)
@Service
public class EstudianteServices implements IEstudianteServices {

    IEstudianteRepository _petRepository;

    @Autowired
    public EstudianteServices(IEstudianteRepository petRepository) {
        _petRepository = petRepository;
    }


    @Override
    public List<Estudiante> GetAllPets() {
        return _petRepository.findAll();
    }

    @Override
    public Estudiante SavePet(Estudiante entity) {
        Estudiante estudianteSaved = _petRepository.save(entity);
        return estudianteSaved;
    }

    @Override
    public Estudiante UpdatePet(Estudiante entity) {
        Optional<Estudiante> rowInDB = _petRepository.findById(entity.getId());
        if (rowInDB.isPresent()) {
            Estudiante estudianteToUpdate = rowInDB.get();
            // Actualizar los campos del estudiante
            estudianteToUpdate.setName(entity.getName());
            estudianteToUpdate.setApellido(entity.getApellido());
            estudianteToUpdate.setCorreo(entity.getCorreo());
            estudianteToUpdate.setEdad(entity.getEdad());
            return _petRepository.save(estudianteToUpdate);
        } else {
            // Manejo del caso en que el estudiante no exista
            return new Estudiante();
        }
    }

    @Override
    public Estudiante FindPetById(int id) {
        Optional<Estudiante> rowInDB = _petRepository.findById(id);
        if (rowInDB.isPresent())
            return rowInDB.get();
        else
            return new Estudiante();
    }

    @Override
    public Estudiante DeletePetById(int id) {
        Optional<Estudiante> rowInDB = _petRepository.findById(id);
        if (rowInDB.isPresent()) {
            Estudiante estudianteToDelete = rowInDB.get();
            _petRepository.delete(estudianteToDelete);
            return estudianteToDelete;
        } else {
            // Manejo del caso en que el estudiante no exista
            return new Estudiante();
        }
    }

    @Override
    public List<Estudiante> SearchPets(String name) {
        return null;
    }
}