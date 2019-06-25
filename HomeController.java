package controller;
import modelos.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
/**
 *
 * @author Dayana
 */
public class HomeController {
    private JdbcTemplate jdbcTemplate;
    
    public HomeController()
    {
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping("frmHome.htm")
    public ModelAndView Home()
    {
        ModelAndView MAV = new ModelAndView();
        String SQL = "Select IdUsuario, DNI, Nombre, Apellido, Celular, Email, Contra, Nivel from usuario where Activo=1";
        List Dato = this.jdbcTemplate.queryForList(SQL);
        MAV.addObject("Datos",Dato);
        MAV.setViewName("frmHome");
        return MAV;
    }
}
