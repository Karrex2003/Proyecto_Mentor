package proyects.proyectomentoria.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inicio")
public class ControllerUsuarios {
    @GetMapping("/crear")
    public ResponseEntity<?> crearUsuarios (){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
