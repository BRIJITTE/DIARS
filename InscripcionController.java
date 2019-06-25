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
public class InscripcionController {
     private JdbcTemplate jdbcTemplate;
    
    public InscripcionController()
    {
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping("Inscripcion.htm")
    public ModelAndView Inscripcion()
    {
        ModelAndView MAV = new ModelAndView();
        String SQL = "Select i.IdInscrip, u.DNI, u.Nombre as NombreCliente, u.Apellido, p.NombrePaque, c.NombreClass,ut.Nombre, i.PrecioInscrip from inscripciones i inner join usuario u on i.IdUsuario=u.IdUsuario inner join paquetes p on i.IdPaque=p.IdPaque inner join clases c on i.IdClass=c.IdClass inner join usuario ut on c.IdTrainer=ut.IdUsuario where i.Activo=1";
        List Dato = this.jdbcTemplate.queryForList(SQL);
        MAV.addObject("Datos",Dato);
        MAV.setViewName("Inscripcion");
        return MAV;
    }
}
