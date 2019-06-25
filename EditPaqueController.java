/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import modelos.Conectar;
import modelos.Paquete;
import modelos.PaqueteValidar;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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
public class EditPaqueController {
    PaqueteValidar PaqueteValidar;
    private JdbcTemplate jdbcTemplate;
    
    public EditPaqueController(){
        this.PaqueteValidar = new PaqueteValidar();
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request){
        ModelAndView MAV = new ModelAndView();
        int IdPaque = Integer.parseInt(request.getParameter("IdPaque"));
        
        
        Paquete Datos = this.selectPaquete(IdPaque);
        MAV.setViewName("AdmiPaqueEdit");
        MAV.addObject("Paquete",new Paquete(IdPaque, Datos.getNombrePaque(), Datos.getDescripPaque(), Datos.getPrecioPaque()));
        return MAV;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form
        (
            @ModelAttribute("Paquete") Paquete p,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
        )
    {
        this.PaqueteValidar.validate(p, result);
        if(result.hasErrors()){
            ModelAndView MAV = new ModelAndView();
            int IdPaque = Integer.parseInt(request.getParameter("IdPaque"));
            Paquete Datos = this.selectPaquete(IdPaque);
            MAV.setViewName("AdmiPaqueEdit");
            MAV.addObject("Paquete",new Paquete(IdPaque, Datos.getNombrePaque(), Datos.getDescripPaque(), Datos.getPrecioPaque()));
            return MAV;
        }else{
            int IdPaque = Integer.parseInt(request.getParameter("IdPaque"));
            this.jdbcTemplate.update(
                    "Update paquetes Set NombrePaque = ?, DescripPaque = ?, PrecioPaque = ? Where IdPaque = ?",
                    p.getNombrePaque(), p.getDescripPaque(), p.getPrecioPaque(), IdPaque);
            return new ModelAndView("redirect:/AdmiPaqueHome.htm");
        }
    }

    private Paquete selectPaquete(int IdPaque) {
        final Paquete paque = new Paquete();
        String Quer = "Select IdPaque, NombrePaque, DescripPaque, PrecioPaque From paquetes Where Activo = 1 And IdPaque = '" + IdPaque + "'";
        return (Paquete) jdbcTemplate.query(
            Quer, new ResultSetExtractor<Paquete>(){
                public Paquete extractData(ResultSet rs) throws SQLException, DataAccessException{
                    if (rs.next()){
                        paque.setIdPaque(Integer.parseInt(rs.getString("IdPaque")));
                        paque.setNombrePaque(rs.getString("NombrePaque"));
                        paque.setDescripPaque(rs.getString("DescripPaque"));
                        paque.setPrecioPaque(rs.getInt("PrecioPaque"));
                    }
                    return paque;
                }
            }
        );
        
    }

}
