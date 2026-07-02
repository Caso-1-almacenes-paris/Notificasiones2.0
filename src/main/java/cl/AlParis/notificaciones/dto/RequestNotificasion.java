package cl.AlParis.notificaciones.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
<<<<<<< HEAD
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
=======

>>>>>>> 3f2b061ffecc7eb19b35eb2555720ea0ffa0d155

public record RequestNotificasion(  

    @NotBlank(message = "El ID del pedido es obligatorio")
    String pedidoId,

    @NotBlank(message = "El ID del cliente es obligatorio") 
    String clienteId,

    @NotBlank(message = "El destinatario es obligatorio")
    @Email(message = "El formato del correo electrónico no es válido") 
    String destinatario,

    @NotBlank(message = "El tipo de canal es obligatorio")
    @Pattern(regexp = "^(EMAIL|SMS|WHATSAPP)$", message = "El canal debe ser EMAIL, SMS o WHATSAPP")
    String tipoCanal,

    @NotBlank(message = "El asunto no puede ir vacío")
    String asunto,

    @NotBlank(message = "El mensaje es obligatorio")
    String mensaje
) {}
