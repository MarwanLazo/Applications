package com.sprapp.springdata;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprapp.dto.TempTableDTO;
import com.sprapp.entity.TempTableEB;

@Repository(value = "tempTableRepositry")
public interface TempTableRepositry extends DAO<TempTableEB, String> {
	@Query("SELECT t FROM TempTableEB t where t.tempName LIKE %:tempName% ORDER BY t.tempName DESC")
	// @Query(value = "SELECT * FROM temp_table where TEMP_NAME =
	// ?#{[tempName]}", nativeQuery = true)
	List<TempTableEB> findAllTemps(@Param("tempName") String tempName);

	@Query("SELECT t FROM TempTableEB t  ORDER BY t.tempName ASC")
	List<TempTableEB> findAllTemps();

	@Query("SELECT new com.sprapp.dto.TempTableDTO(t.tempName,t.tempEmail) FROM TempTableEB t WHERE t.tempName LIKE %:name%")
	TempTableDTO geTempTableDTO(@Param("name") String name);

	TempTableEB findTempTableByTempName(@Param("tempName") String tempName);
}
