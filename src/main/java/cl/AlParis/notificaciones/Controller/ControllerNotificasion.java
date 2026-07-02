package cl.AlParis.notificaciones.Controller;

import cl.AlParis.notificaciones.Model.ModelNoti;
import cl.AlParis.notificaciones.Service.ServiceNotificasion;
import cl.AlParis.notificaciones.dto.RequestNotificasion;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content; 
import io.swagger.v3.oas.annotations.media.ExampleObject;

@Tag(name = "Notificaciones")
@RestController
@RequestMapping("/api/v1/notificaciones")
public class ControllerNotificasion {

    private final ServiceNotificasion service;

    public ControllerNotificasion(ServiceNotificasion service) {
        this.service = service;
    }

    @Operation(summary = "Enviar notificación")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
        content = @Content(examples = @ExampleObject(value = "{\"mensaje\": \"Tu pedido está en camino\", \"clienteId\": \"12345\"}"))
    )
    @ApiResponse(
        responseCode = "201",
        content = @Content(examples = @ExampleObject(value = "{\"id\": 1, \"estado\": \"ENVIADA\"}"))
    )
    @PostMapping("/enviar")
    public ResponseEntity<ModelNoti> crearNotificacion(
            @Valid @org.springframework.web.bind.annotation.RequestBody RequestNotificasion request) {
        ModelNoti nuevaNoti = service.enviarNotificacion(request);
        return new ResponseEntity<>(nuevaNoti, HttpStatus.CREATED);
    }

    @Operation(summary = "Ver historial completo")
    @ApiResponse(
        responseCode = "200",
        content = @Content(examples = @ExampleObject(value = "[{\"id\": 1, \"estado\": \"ENVIADA\"}]"))
    )
    @GetMapping("/historial")
    public ResponseEntity<List<ModelNoti>> verHistorial() {
        return ResponseEntity.ok(service.obtenerHistorial());
    }
}
