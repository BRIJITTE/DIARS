/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import modelos.Conectar;
import modelos.Paquete;
import modelos.PaqueteValidar;
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
@RequestMapping("AdmiPaqueAdd.htm")
public class AddPaqueController {
    
    PaqueteValidar PaqueteValidar;
    private JdbcTemplate jdbcTemplate;
    
    public AddPaqueController(){
        this.PaqueteValidar = new PaqueteValidar();
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public ModelAndView form()
    {
        ModelAndView MAV = new ModelAndView();
        
        MAV.setViewName("AdmiPaqueAdd");
        MAV.addObject("Paquete", new Paquete());
        return MAV;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("Paquete") Paquete p,
                BindingResult result,
                SessionStatus status
        )
    {
        this.PaqueteValidar.validate(p, result);
        if(result.hasErrors())
        {
            ModelAndView MAV = new ModelAndView();

            MAV.setViewName("AdmiPaqueAdd");
            MAV.addObject("Paquete", new Paquete());
            return MAV;
        }
        else
        {
            this.jdbcTemplate.update
            (
                "Exec PA_IngresarPaquete  ?, ?, ?",
                    p.getNombrePaque(),p.getDescripPaque(),p.getPrecioPaque()
            );
            return new ModelAndView("redirect:/AdmiPaqueHome.htm");
        }
    }
}
