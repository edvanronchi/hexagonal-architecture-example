package demo.adapters.outbound.repositories;

import demo.adapters.outbound.entities.JpaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaUserRepository extends JpaRepository<JpaUserEntity, UUID>  {

}
