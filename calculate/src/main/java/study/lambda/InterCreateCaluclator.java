package study.lambda;

@FunctionalInterface
public interface InterCreateCaluclator<T, R> {
		public R apply(T t);	
}
