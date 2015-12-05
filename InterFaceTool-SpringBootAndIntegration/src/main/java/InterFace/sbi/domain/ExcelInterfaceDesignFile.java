/**
 * 
 */
package InterFace.sbi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MIT
 *
 */
@Entity
@Table(name = "excel_interface_design_files")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelInterfaceDesignFile {
	
	@Id
	@Column(nullable = false)
	private Integer id;

	@Column(nullable = false)
	private String dirName;
	
	@Column(nullable = false)
	private String filetype;

}
