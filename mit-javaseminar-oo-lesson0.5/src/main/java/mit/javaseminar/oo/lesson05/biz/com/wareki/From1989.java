package mit.javaseminar.oo.lesson05.biz.com.wareki;

import mit.javaseminar.oo.lesson05.abs.Nen;

public class From1989 implements InterWarekiState {
	
	/* (非 Javadoc)
	 * @see mit.javaseminar.oo.lesson05.biz.com.wareki.InterWarekiState#getGengo2String()
	 */
	@Override
	public String getGengo2String() {
		return "平成";
	}

	/* (非 Javadoc)
	 * @see mit.javaseminar.oo.lesson05.biz.com.wareki.InterWarekiState#getGengo1String()
	 */
	@Override
	public String getGengo1String() {
		return "平";
	}

	/* (非 Javadoc)
	 * @see mit.javaseminar.oo.lesson05.biz.com.wareki.InterWarekiState#getGengoInitial()
	 */
	@Override
	public String getGengoInitial() {
		return "H";
	}

	@Override
	public String getGengoNen(Nen nen) {
		//めんどくさいので別途
		return "";
	}

}
