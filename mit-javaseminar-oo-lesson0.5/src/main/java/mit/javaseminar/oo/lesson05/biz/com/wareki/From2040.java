package mit.javaseminar.oo.lesson05.biz.com.wareki;

import mit.javaseminar.oo.lesson05.abs.Nen;

public class From2040 implements InterWarekiState {
	
	/* (非 Javadoc)
	 * @see mit.javaseminar.oo.lesson05.biz.com.wareki.InterWarekiState#getGengo2String()
	 */
	@Override
	public String getGengo2String() {
		return "元号";
	}

	/* (非 Javadoc)
	 * @see mit.javaseminar.oo.lesson05.biz.com.wareki.InterWarekiState#getGengo1String()
	 */
	@Override
	public String getGengo1String() {
		return "元";
	}

	/* (非 Javadoc)
	 * @see mit.javaseminar.oo.lesson05.biz.com.wareki.InterWarekiState#getGengoInitial()
	 */
	@Override
	public String getGengoInitial() {
		return "G";
	}

	@Override
	public String getGengoNen(Nen nen) {
		return  String.valueOf(
				Integer.valueOf(nen.getNen().substring(2, 3)) + (-18)
				);
	}

}
