/**
 * 
 */
package iftool.helper;

import java.io.InputStream;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import iftool.entity.Argument;

/**
 * @author MIT
 *
 */
@Component
public class ScannerArgumentResolver implements ImplArgumentResolver {

	/* (non-Javadoc)
	 * @see tool.manage.outerif.IntArgumentResolver#reslove(java.io.InputStream)
	 */
	@Override
	public Argument reslove(InputStream stream) {
		try (Scanner scanner = new Scanner(stream)){
			int arg1 = scanner.nextInt();
			String arg2 = scanner.next();
			return new Argument(arg1, arg2);
		}
	}

}
