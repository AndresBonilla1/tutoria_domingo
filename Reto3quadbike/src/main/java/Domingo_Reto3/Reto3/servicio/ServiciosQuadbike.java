/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domingo_Reto3.Reto3.servicio;

import Domingo_Reto3.Reto3.modelo.Quadbike;
import Domingo_Reto3.Reto3.repositorio.RepositorioQuadbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CONSUELO
 */
@Service
public class ServiciosQuadbike {
     @Autowired
    private RepositorioQuadbike metodosCrud;

    public List<Quadbike> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Quadbike> getBike(int bikeId) {
        return metodosCrud.getBike(bikeId);
    }

    public Quadbike save(Quadbike bike){
        if(bike.getId()==null){
            return metodosCrud.save(bike);
        }else{
            Optional<Quadbike> e=metodosCrud.getBike(bike.getId());
            if(e.isEmpty()){
                return metodosCrud.save(bike);
            }else{
                return bike;
            }
        }
    }

    public Quadbike update(Quadbike bike){
        if(bike.getId()!=null){
            Optional<Quadbike> e=metodosCrud.getBike(bike.getId());
            if(!e.isEmpty()){
                if(bike.getName()!=null){
                    e.get().setName(bike.getName());
                }
                if(bike.getBrand()!=null){
                    e.get().setBrand(bike.getBrand());
                }
                if(bike.getYear()!=null){
                    e.get().setYear(bike.getYear());
                }
                if(bike.getDescription()!=null){
                    e.get().setDescription(bike.getDescription());
                }
                if(bike.getCategory()!=null){
                    e.get().setCategory(bike.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return bike;
            }
        }else{
            return bike;
        }
    }


    public boolean deleteBike(int bikeId) {
        Boolean aBoolean = getBike(bikeId).map(bike -> {
            metodosCrud.delete(bike);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
