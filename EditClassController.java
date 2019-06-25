/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modelos.Class1;
import modelos.ClassValidar;
import modelos.Conectar;
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
public class EditClassController {
    ClassValidar ClassValidar;
    private JdbcTemplate jdbcTemplate;
    
    public EditClassController(){
        this.ClassValidar = new ClassValidar();
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request){
        ModelAndView MAV = new ModelAndView();
        int IdClass = Integer.parseInt(request.getParameter("IdClass"));
        
        String SQL_T = "Select IdUsuario, Nombre from usuario where Nivel=3";
        List Dato_T = this.jdbcTemplate.queryForList(SQL_T);
        MAV.addObject("Usuario",Dato_T);
        MAV.setViewName("frmAddClass");
        
        Class1 Datos = this.selectClass1(IdClass);
        MAV.setViewName("frmEditClass");
        MAV.addObject("Class1",new Class1(IdClass, Datos.getNombreClass(), Datos.getDescripClass(), Datos.getPrecioClass(), Datos.getIdTrainer()));
        return MAV;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form
        (
            @ModelAttribute("Class1") Class1 a,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
        )
    {
        this.ClassValidar.validate(a, result);
        if(result.hasErrors()){
            ModelAndView MAV = new ModelAndView();
            int IdClass = Integer.parseInt(request.getParameter("IdClass"));
            Class1 Datos = this.selectClass1(IdClass);
            MAV.setViewName("frmEditClass");
            MAV.addObject("Class1",new Class1(IdClass, Datos.getNombreClass(), Datos.getDescripClass(), Datos.getPrecioClass(), Datos.getIdTrainer()));
            return MAV;
        }else{
            int IdClass = Integer.parseInt(request.getParameter("IdClass"));
            this.jdbcTemplate.update(
                    "Update clases Set NombreClass = ?, DescripClass = ?, PrecioClass = ?, IdTrainer = ? Where IdClass = ?",
                    a.getNombreClass(), a.getDescripClass(), a.getPrecioClass(), a.getIdTrainer(), IdClass);
            return new ModelAndView("redirect:/AdmiClassHome.htm");
        }
    }

    private Class1 selectClass1(int IdClass) {
        final Class1 clase = new Class1();
        String Quer = "Select IdClass, NombreClass, DescripClass, PrecioClass, IdTrainer From clases Where Activo = 1 And IdClass = '" + IdClass + "'";
        return (Class1) jdbcTemplate.query(
            Quer, new ResultSetExtractor<Class1>(){
                public Class1 extractData(ResultSet rs) throws SQLException, DataAccessException{
                    if (rs.next()){
                        clase.setIdClass(Integer.parseInt(rs.getString("IdClass")));
                        clase.setNombreClass(rs.getString("NombreClass"));
                        clase.setDescripClass(rs.getString("DescripClass"));
                        clase.setPrecioClass(Double.parseDouble(rs.getString("PrecioClass")));
                        clase.setIdTrainer(Integer.parseInt(rs.getString("IdTrainer")));
                    }
                    return clase;
                }
            }
        );
        
    }

}
