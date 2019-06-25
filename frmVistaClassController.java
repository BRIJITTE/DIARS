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
public class frmVistaClassController {
    private JdbcTemplate jdbcTemplate;
    
    public frmVistaClassController()
    {
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping("frmVistaClass.htm")
    public ModelAndView frmVistaClassController()
    {
        ModelAndView MAV = new ModelAndView();
        String SQL = "Select c.IdClass, c.NombreClass, c.DescripClass, c.PrecioClass, u.Nombre From clases c inner join usuario u on c.IdTrainer=u.IdUsuario where u.Nivel=3";
        List Dato = this.jdbcTemplate.queryForList(SQL);
        MAV.addObject("Datos",Dato);
        MAV.setViewName("frmVistaClass");
        return MAV;
    }
}
