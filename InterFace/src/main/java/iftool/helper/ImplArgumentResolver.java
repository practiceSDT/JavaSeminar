/**
 * 
 */
package iftool.helper;

import java.io.InputStream;

import iftool.entity.Argument;

/**
 * @author MIT
 *
 */
public interface ImplArgumentResolver {
	Argument reslove(InputStream stream);

}
