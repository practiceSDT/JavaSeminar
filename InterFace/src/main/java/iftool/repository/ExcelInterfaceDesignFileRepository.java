/**
 * 
 */
package iftool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iftool.entity.ExcelInterfaceDesignFile;

/**
 * @author MIT
 *
 */
@Repository
public interface ExcelInterfaceDesignFileRepository 
		extends JpaRepository<ExcelInterfaceDesignFile, Integer> {

}
