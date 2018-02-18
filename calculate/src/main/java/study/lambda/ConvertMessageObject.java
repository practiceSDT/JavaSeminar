package study.lambda;

import java.util.function.BiFunction;

@FunctionalInterface
public interface ConvertMessageObject<T> extends BiFunction<T,T,T> {

		// (T, T) -> T
//		public T apply(T left, T right);
}	
