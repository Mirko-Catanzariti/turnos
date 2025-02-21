package ar.com.turnos.controller;


import ar.com.turnos.entities.TiposDoc;
import ar.com.turnos.iservice.ITiposDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api")
public class TiposDocController {

    @Autowired
    ITiposDocService entityService;

    @GetMapping(path = "/tiposdoc")
    public List<TiposDoc> getAll() {return entityService.getAll();}

    @GetMapping(path = "/tiposdoc/{id}")
    public TiposDoc get(@PathVariable Integer id)
    {return entityService.get(id);}

    @GetMapping(path = "/tiposdoc/search/{expresion}")
    public List<TiposDoc> getListTiposDoc(@PathVariable String expresion)
    {return entityService.findByDescrip(expresion);}

    @PostMapping(value = "/tiposdoc", consumes = "application/json", produces = "application/json")
    public TiposDoc save(@RequestBody TiposDoc entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping(path = "tiposdoc/delete/{id}")
    public String delete(@PathVariable Integer id) {
        TiposDoc entity = null;
        try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }


}
