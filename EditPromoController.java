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
import modelos.Promocion;
import modelos.PromocionValidar;
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
public class EditPromoController {
    PromocionValidar PromocionValidar;
    private JdbcTemplate jdbcTemplate;
    
    public EditPromoController(){
        this.PromocionValidar = new PromocionValidar();
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request){
        ModelAndView MAV = new ModelAndView();
        int IdPromo = Integer.parseInt(request.getParameter("IdPromo"));
        
        Promocion Datos = this.selectPromocion(IdPromo);
        MAV.setViewName("AdmiPromoEdit");
        MAV.addObject("Promocion",new Promocion(IdPromo, Datos.getNombrePromo(), Datos.getDescripPromo(), Datos.getDescuento()));
        return MAV;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form
        (
            @ModelAttribute("Promocion") Promocion p,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
        )
    {
        this.PromocionValidar.validate(p, result);
        if(result.hasErrors()){
            ModelAndView MAV = new ModelAndView();
            int IdPromo = Integer.parseInt(request.getParameter("IdPromo"));
            Promocion Datos = this.selectPromocion(IdPromo);
            MAV.setViewName("AdmiPromoEdit");
            MAV.addObject("Promocion",new Promocion(IdPromo, Datos.getNombrePromo(), Datos.getDescripPromo(), Datos.getDescuento()));
            return MAV;
        }else{
            int IdPromo = Integer.parseInt(request.getParameter("IdPromo"));
            this.jdbcTemplate.update(
                    "Update promocion Set NombrePromo = ?, DescripPromo = ?, Descuento = ? Where IdPromo = ?",
                    p.getNombrePromo(), p.getDescripPromo(), p.getDescuento(), IdPromo);
            return new ModelAndView("redirect:/AdmiPromoHome.htm");
        }
    }

    private Promocion selectPromocion(int IdPromo) {
        final Promocion promo = new Promocion();
        String Quer = "Select IdPromo, NombrePromo, DescripPromo, Descuento From promocion Where Activo = 1 And IdPromo = '" + IdPromo + "'";
        return (Promocion) jdbcTemplate.query(
            Quer, new ResultSetExtractor<Promocion>(){
                public Promocion extractData(ResultSet rs) throws SQLException, DataAccessException{
                    if (rs.next()){
                        promo.setIdPromo(Integer.parseInt(rs.getString("IdPromo")));
                        promo.setNombrePromo(rs.getString("NombrePromo"));
                        promo.setDescripPromo(rs.getString("DescripPromo"));
                        promo.setDescuento(Double.parseDouble(rs.getString("Descuento")));
                    }
                    return promo;
                }
            }
        );   
    }

}
