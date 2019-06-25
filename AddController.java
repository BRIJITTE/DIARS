package controller;
import modelos.Conectar;
import modelos.Usuarios;
import modelos.UsuariosValidar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
/**
 *
 * @author Dayana
 */
@Controller
@RequestMapping("frmAdd.htm")
public class AddController {
    UsuariosValidar UsuariosValidar;
    private JdbcTemplate jdbcTemplate;
    
    public AddController() 
    {
        this.UsuariosValidar = new UsuariosValidar();
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public ModelAndView form()
    {
        ModelAndView MAV = new ModelAndView();

        MAV.setViewName("frmAdd");
        MAV.addObject("Usuarios", new Usuarios());
        return MAV;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(@ModelAttribute("Usuarios") Usuarios a, BindingResult result, SessionStatus status){
        this.UsuariosValidar.validate(a, result);
        if(result.hasErrors())
        {
            ModelAndView MAV = new ModelAndView();
            
            MAV.setViewName("frmAdd");
            MAV.addObject("Usuarios", new Usuarios());
            return MAV;
        }
        else
        {
            this.jdbcTemplate.update
            (
                "Execute PA_IngresarUsuario ?,?,?,?,?,?,?",
                a.getDNI(), a.getNombre(), a.getApellido(), a.getCelular(), a.getEmail(), a.getContra(), a.getNivel()
            );
            return new ModelAndView("redirect:/frmHome.htm");
        }
    }
}
