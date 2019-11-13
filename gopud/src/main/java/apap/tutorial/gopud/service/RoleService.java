package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.RoleModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    List<RoleModel> findAll();
}
