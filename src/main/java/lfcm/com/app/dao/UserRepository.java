package lfcm.com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lfcm.com.app.entity.User;



public interface UserRepository extends JpaRepository<User,Long> 
{
	@Query("SELECT u from User u where LOWER(u.soeId) = LOWER(:userSoeId)")
	User findBySoeId(@Param("userSoeId")String userSoeId);

}
