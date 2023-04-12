package rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rms.entity.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem,Integer> {
}
