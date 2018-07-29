package mit.javaseminar.oo.lesson05.biz.com.wareki;

import mit.javaseminar.oo.lesson05.abs.Nen;

public interface InterWarekiState {

	String getGengo2String();

	String getGengo1String();

	String getGengoInitial();
	
	String getGengoNen(Nen nen);

}