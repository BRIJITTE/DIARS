/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import modelos.Conectar;
import modelos.UsuariosValidar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dayana
 */
public class LoginController {
    private JdbcTemplate jdbcTemplate;
     UsuariosValidar UsuariosValidar;
    
    public LoginController()
    {
        this.UsuariosValidar = new UsuariosValidar();
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    @RequestMapping("Login.htm")
    public void Login(String dni, String pass)
    {
        
        
        
    }
}
