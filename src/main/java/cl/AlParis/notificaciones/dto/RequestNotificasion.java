package cl.AlParis.notificaciones.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record RequestNotificasion(  

    @NotBlank(message = "El ID del pedido es obligatorio")
    String pedidoId,

    @NotNull(message = "El ID del cliente es obligatorio")
    Long clienteId,

    @NotBlank(message = "El destinatario es obligatorio")
    String destinatario,

    @NotBlank(message = "El tipo de canal es obligatorio")
    String tipoCanal,

    @NotBlank(message = "El asunto no puede ir vacío")
    String asunto,

    @NotBlank(message = "El mensaje es obligatorio")
    String mensaje
 ) {}
