/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import modelos.Class1;
import modelos.ClassValidar;
import modelos.Conectar;
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
@RequestMapping("frmAddClass.htm")
public class AddClassController {
    ClassValidar ClassValidar;
    private JdbcTemplate jdbcTemplate;
    
    public AddClassController() 
    {
        this.ClassValidar = new ClassValidar();
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public ModelAndView form()
    {
        ModelAndView MAV = new ModelAndView();
        
        String SQL_T = "Select IdUsuario, Nombre from usuario where Nivel=3";
        List Dato_T = this.jdbcTemplate.queryForList(SQL_T);
        MAV.addObject("Usuario",Dato_T);
        MAV.setViewName("frmAddClass");

        MAV.setViewName("frmAddClass");
        MAV.addObject("Class1", new Class1());
        return MAV;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("Class1") Class1 c,
                BindingResult result,
                SessionStatus status
        )
    {
        this.ClassValidar.validate(c, result);
        if(result.hasErrors())
        {
            ModelAndView MAV = new ModelAndView();
            
            String SQL_T = "Select IdUsuario, Nombre from usuario where Nivel=3";
            List Dato_T = this.jdbcTemplate.queryForList(SQL_T);
            MAV.addObject("Usuario",Dato_T);
            MAV.setViewName("frmAddClass");

            MAV.setViewName("frmAddClass");
            MAV.addObject("Class1", new Class1());
            return MAV;
        }
        else
        {
            this.jdbcTemplate.update
            (
                "Exec PA_IngresarClass  ?, ?, ?, ?",
                    c.getNombreClass(),c.getDescripClass(),c.getPrecioClass(),c.getIdTrainer()
            );
            return new ModelAndView("redirect:/AdmiClassHome.htm");
        }
    }
}
