package lfcm.com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lfcm.com.app.entity.CLAAcessConfig;



@Repository
public interface CLAAcessConfigRepository extends JpaRepository<CLAAcessConfig,Long>{

	@Query("SELECT l FROM CLAAcessConfig l WHERE LOWER(l.soeId) = LOWER(:soeId)")
	public CLAAcessConfig getCLAAcessConfigBySoeId(@Param("soeId") String soeId);

	@Query("Select l from CLAAcessConfig l where LOWER(l.role) = LOWER(:role)")
	public CLAAcessConfig findCLAAcessConfigBySubModuleAndRole(@Param("role")String role);
}
