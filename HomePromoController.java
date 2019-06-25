/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import modelos.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dayana
 */
public class HomePromoController {
    private JdbcTemplate jdbcTemplate;
    
    public HomePromoController()
    {
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping("AdmiPromoHome.htm")
    public ModelAndView home()
    {
        ModelAndView MAV = new ModelAndView();
        String SQL = "Select IdPromo, NombrePromo, DescripPromo, Descuento From promocion where Activo=1";
        List Dato = this.jdbcTemplate.queryForList(SQL);
        MAV.addObject("Datos",Dato);
        MAV.setViewName("AdmiPromoHome");
        return MAV;
    }
}
