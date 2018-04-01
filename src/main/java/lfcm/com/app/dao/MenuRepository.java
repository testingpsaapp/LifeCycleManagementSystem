package lfcm.com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lfcm.com.app.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Long>{

	@Query("SELECT DISTINCT m.mainMenu FROM Menu m WHERE m.accessGroup like %:userAccessGroup% ")
	public List<String> getMainMenuNameByAccessGroup(@Param("userAccessGroup") String userAccessGroup);
	
	@Query("SELECT DISTINCT m.subMenu FROM Menu m WHERE m.mainMenu = :mainMenu and m.accessGroup like %:userAccessGroup%")
	public List<String> getMenuByMainMenu(@Param("mainMenu") String mainMenu,@Param("userAccessGroup") String userAccessGroup);
	
	@Query("SELECT DISTINCT m.subMenuLink FROM Menu m WHERE m.mainMenu = :mainMenu and m.subMenu = :subMenu and m.accessGroup like %:userAccessGroup%")
	public String getSubMenuLinkByMainMenuSubMenuAccess(@Param("mainMenu") String mainMenu,@Param("userAccessGroup") String userAccessGroup,@Param("subMenu") String subMenu);
	
	@Query("SELECT m.action FROM Menu m WHERE m.mainMenu = :mainMenu and m.subMenu = :subMenu and m.accessGroup like %:userAccessGroup%")
	public List<String> getSubMenuAction(@Param("mainMenu") String mainMenu,@Param("userAccessGroup") String userAccessGroup,@Param("subMenu") String subMenu);
	
}
