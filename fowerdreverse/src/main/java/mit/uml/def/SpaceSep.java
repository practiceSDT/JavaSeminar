package mit.uml.def;

import mit.uml.fw.InterSep;

public class SpaceSep implements InterSep {
	
	private String sepString = " ";

	/* (非 Javadoc)
	 * @see mit.uml.InterSep#getSepString()
	 */
	@Override
	public String getSepString() {
		return sepString;
	}

}
