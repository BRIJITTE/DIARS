/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import modelos.Conectar;
import modelos.UsuariosValidar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dayana
 */
public class RegistroController {
    private JdbcTemplate jdbcTemplate;
     UsuariosValidar UsuariosValidar;
    
    public RegistroController()
    {
        this.UsuariosValidar = new UsuariosValidar();
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    @RequestMapping("Registro.htm")
    public void Registro()
    {
        
        
        
    }
}
