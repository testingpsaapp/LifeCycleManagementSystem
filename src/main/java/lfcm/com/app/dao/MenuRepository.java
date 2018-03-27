package lfcm.com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lfcm.com.app.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Long>{

}
