package cl.AlParis.notificaciones.Controller;

import cl.AlParis.notificaciones.Model.ModelNoti;
import cl.AlParis.notificaciones.Service.ServiceNotificasion;
import cl.AlParis.notificaciones.dto.RequestNotificasion;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class ControllerNotificasion {

    private final ServiceNotificasion service;

    public ControllerNotificasion(ServiceNotificasion service) {
        this.service = service;
    }

    
    @PostMapping("/enviar")
    public ResponseEntity<ModelNoti> crearNotificacion(@Valid @RequestBody RequestNotificasion request) {
        ModelNoti nuevaNoti = service.enviarNotificacion(request);
        return new ResponseEntity<>(nuevaNoti, HttpStatus.CREATED);
    }

    
    @GetMapping("/historial")
    public ResponseEntity<List<ModelNoti>> verHistorial() {
        return ResponseEntity.ok(service.obtenerHistorial());
    }
}
