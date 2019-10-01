package apap.tutorial.gopud.repository;

import apap.tutorial.gopud.model.MenuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import java.math.BigInteger;

@Repository
public interface MenuDB extends JpaRepository<MenuModel, Long> {
    Optional<MenuModel> findById(Long id);
    List<MenuModel> findByRestoranIdRestoran(Long idRestoran);
}