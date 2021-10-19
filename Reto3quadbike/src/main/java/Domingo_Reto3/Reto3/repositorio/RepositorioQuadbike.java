/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domingo_Reto3.Reto3.repositorio;

import Domingo_Reto3.Reto3.modelo.Quadbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Domingo_Reto3.Reto3.repositorio.crud.InterfaceQuadbike;

/**
 *
 * @author CONSUELO
 */
@Repository
public class RepositorioQuadbike {

    @Autowired
    private InterfaceQuadbike crud;

    public List<Quadbike> getAll() {
        return (List<Quadbike>) crud.findAll();
    }

    public Optional<Quadbike> getBike(int id) {
        return crud.findById(id);
    }

    public Quadbike save(Quadbike bike) {
        return crud.save(bike);
    }

    public void delete(Quadbike bike) {
        crud.delete(bike);
    }

}
