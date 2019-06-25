/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import modelos.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dayana
 */
public class DeletePromoController {
    private JdbcTemplate jdbcTemplate;
    public DeletePromoController()
    {
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping("AdmiPromoDelete.htm")
    public ModelAndView home(HttpServletRequest request) 
    {
        int IdPromo = Integer.parseInt(request.getParameter("IdPromo"));
        this.jdbcTemplate.update("Update promocion Set Activo = 0 Where IdPromo = ? ", IdPromo);
        return new ModelAndView("redirect:/AdmiPromoHome.htm");
    }
}
