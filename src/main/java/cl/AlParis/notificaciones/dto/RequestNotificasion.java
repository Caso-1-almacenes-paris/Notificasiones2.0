package cl.AlParis.notificaciones.dto;

import jakarta.validation.constraints.NotBlank;


public record RequestNotificasion(  

    @NotBlank(message = "El ID del pedido es obligatorio")
    String pedidoId,

    @NotBlank(message = "El ID del cliente es obligatorio") 
    String clienteId,

    @NotBlank(message = "El destinatario es obligatorio")
    String destinatario,

    @NotBlank(message = "El tipo de canal es obligatorio")
    String tipoCanal,

    @NotBlank(message = "El asunto no puede ir vacío")
    String asunto,

    @NotBlank(message = "El mensaje es obligatorio")
    String mensaje
 ) {}
