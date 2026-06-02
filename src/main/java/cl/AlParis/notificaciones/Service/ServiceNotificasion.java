package cl.AlParis.notificaciones.Service;

import cl.AlParis.notificaciones.Model.ModelNoti;
import cl.AlParis.notificaciones.Repository.RepoNotificasion;
import cl.AlParis.notificaciones.dto.RequestNotificasion;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceNotificasion {

    private final RepoNotificasion repository;

    
    public ServiceNotificasion(RepoNotificasion repository) {
        this.repository = repository;
    }

    
    public ModelNoti enviarNotificacion(RequestNotificasion dto) {
        ModelNoti notificacion = new ModelNoti();
        
        
        notificacion.setPedidoId(dto.pedidoId());
        notificacion.setClienteId(dto.clienteId());
        notificacion.setDestinatario(dto.destinatario());
        notificacion.setTipoCanal(dto.tipoCanal().toUpperCase());
        notificacion.setAsunto(dto.asunto());
        notificacion.setMensaje(dto.mensaje());
        notificacion.setEstado("ENVIADO");
        notificacion.setFechaEnvio(LocalDateTime.now());
        return repository.save(notificacion);
    }

    
    public List<ModelNoti> obtenerHistorial() {
        return repository.findAll();
    }
}
