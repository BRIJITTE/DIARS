/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import modelos.Conectar;
import modelos.Promocion;
import modelos.PromocionValidar;
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
@RequestMapping("AdmiPromoAdd.htm")
public class AddPromoController {
   
    PromocionValidar PromocionValidar;
    private JdbcTemplate jdbcTemplate;
    
    public AddPromoController(){
        this.PromocionValidar = new PromocionValidar();
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public ModelAndView form()
    {
        ModelAndView MAV = new ModelAndView();
        
        MAV.setViewName("AdmiPromoAdd");
        MAV.addObject("Promocion", new Promocion());
        return MAV;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("Promocion") Promocion p,
                BindingResult result,
                SessionStatus status
        )
    {
        this.PromocionValidar.validate(p, result);
        if(result.hasErrors())
        {
            ModelAndView MAV = new ModelAndView();

            MAV.setViewName("AdmiPromoAdd");
            MAV.addObject("Promocion", new Promocion());
            return MAV;
        }
        else
        {
            this.jdbcTemplate.update
            (
                "Exec PA_IngresarPromocion  ?, ?, ?",
                    p.getNombrePromo(),p.getDescripPromo(),p.getDescuento()
            );
            return new ModelAndView("redirect:/AdmiPromoHome.htm");
        }
    }

    
}
