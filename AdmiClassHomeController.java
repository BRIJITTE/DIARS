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
public class AdmiClassHomeController {
    private JdbcTemplate jdbcTemplate;
    
    public AdmiClassHomeController()
    {
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping("AdmiClassHome.htm")
    public ModelAndView home()
    {
        ModelAndView MAV = new ModelAndView();
        String SQL = "Select c.IdClass, c.NombreClass, c.DescripClass, c.PrecioClass, u.Nombre From clases c inner join usuario u on c.IdTrainer=u.IdUsuario where u.Nivel=3 and c.Activo=1";
        List Dato = this.jdbcTemplate.queryForList(SQL);
        MAV.addObject("Datos",Dato);
        MAV.setViewName("AdmiClassHome");
        return MAV;
    }
}
