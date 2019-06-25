/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import modelos.Conectar;
import modelos.InscripcionValidar;
import modelos.Inscripciones;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dayana
 */
@Controller
@RequestMapping("Inscripcion.htm")
public class InscripAddController {
    InscripcionValidar InscripcionValidar;
    private JdbcTemplate jdbcTemplate;
    
    public InscripAddController() 
    {
        this.InscripcionValidar = new InscripcionValidar();
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public ModelAndView form()
    {
        ModelAndView MAV = new ModelAndView();
        
        String SQL_P = "Select IdPaque, NombrePaque from paquetes";
        List Dato_P = this.jdbcTemplate.queryForList(SQL_P);
        MAV.addObject("paquetes",Dato_P);
        MAV.setViewName("Inscripcion");
        
        String SQL_C = "Select IdClass, NombreClass from clases";
        List Dato_C = this.jdbcTemplate.queryForList(SQL_C);
        MAV.addObject("clases",Dato_C);
        MAV.setViewName("Inscripcion");

        MAV.setViewName("Inscripcion");
        MAV.addObject("Inscripciones", new Inscripciones());
        return MAV;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("Inscripciones") Inscripciones i,
                BindingResult result,
                SessionStatus status
        )
    {
        this.InscripcionValidar.validate(i, result);
        if(result.hasErrors())
        {
            ModelAndView MAV = new ModelAndView();
        
            String SQL_P = "Select IdPaque, NombrePaque from paquetes";
            List Dato_P = this.jdbcTemplate.queryForList(SQL_P);
            MAV.addObject("paquetes",Dato_P);
            MAV.setViewName("Inscripcion");

            String SQL_C = "Select IdClass, NombreClass from clases";
            List Dato_C = this.jdbcTemplate.queryForList(SQL_C);
            MAV.addObject("clases",Dato_C);
            MAV.setViewName("Inscripcion");

            MAV.setViewName("Inscripcion");
            MAV.addObject("Inscripciones", new Inscripciones());
            return MAV;
        }
        else
        {
            this.jdbcTemplate.update
            (
                "Exec PA_IngresarInscripcion ?, ?, ?, ?",
                i.getIdUsuario(), i.getIdPaque(), i.getIdClass(), i.getPrecioInscrip()
            );
            return new ModelAndView("redirect:/Inscripcion.htm");
        }
    }
}
