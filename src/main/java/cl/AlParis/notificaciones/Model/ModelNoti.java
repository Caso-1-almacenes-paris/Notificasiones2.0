package cl.AlParis.notificaciones.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notificaciones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ModelNoti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    
    @Column(name = "PEDIDO_ID", nullable = false)
    private String pedidoId;

    
    @Column(name = "CLIENTE_ID", nullable = false)
    private String clienteId; 

    
    @Column(name = "DESTINATARIO", nullable = false, length = 100)
    private String destinatario;


    @Column(name = "TIPO_CANAL", nullable = false, length = 20)
    private String tipoCanal;

    @Column(name = "ASUNTO", nullable = false, length = 150)
    private String asunto;

    
    @Column(name = "MENSAJE", nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    
    @Column(name = "ESTADO", nullable = false, length = 20)
    private String estado;

    
    @Column(name = "FECHA_ENVIO")
    private LocalDateTime fechaEnvio;

    
    @PrePersist
    protected void onCreate() {
        this.fechaEnvio = LocalDateTime.now();
        if (this.estado == null) {
            this.estado = "PENDIENTE"; 
        }
    }
}
