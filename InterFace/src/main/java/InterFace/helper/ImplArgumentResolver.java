/**
 * 
 */
package InterFace.helper;

import java.io.InputStream;

import InterFace.entity.Argument;

/**
 * @author MIT
 *
 */
public interface ImplArgumentResolver {
	Argument reslove(InputStream stream);

}
