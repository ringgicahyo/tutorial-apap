package apap.tutorial.gopud.repository;

import apap.tutorial.gopud.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDB extends JpaRepository<RoleModel, Long> {
    List<RoleModel> findAll();
}
