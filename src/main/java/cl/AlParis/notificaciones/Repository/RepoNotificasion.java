package cl.AlParis.notificaciones.Repository;

import cl.AlParis.notificaciones.Model.ModelNoti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoNotificasion extends JpaRepository<ModelNoti, Long> {
    
}
