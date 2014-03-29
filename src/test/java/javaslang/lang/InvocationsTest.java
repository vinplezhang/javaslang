package javaslang.lang;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.Serializable;

import org.junit.Test;

public class InvocationsTest {

	@Test
	public void shouldParseReturnTypeVoid() {
		final ReturnTypeVoid lambda = () -> {};
		final Class<?> actual = Invocations.getLambdaSignature(lambda).getReturnType();
		assertThat(actual.getName()).isEqualTo("void");
	}

	@Test
	public void shouldParseReturnTypeBoolean() {
		final ReturnTypeBoolean lambda = () -> true;
		final Class<?> actual = Invocations.getLambdaSignature(lambda).getReturnType();
		assertThat(actual.getName()).isEqualTo("boolean");
	}

	@Test
	public void shouldParseReturnTypeByte() {
		final ReturnTypeByte lambda = () -> (byte) 1;
		final Class<?> actual = Invocations.getLambdaSignature(lambda).getReturnType();
		assertThat(actual.getName()).isEqualTo("byte");
	}

	@Test
	public void shouldParseReturnTypeChar() {
		final ReturnTypeChar lambda = () -> '@';
		final Class<?> actual = Invocations.getLambdaSignature(lambda).getReturnType();
		assertThat(actual.getName()).isEqualTo("char");
	}

	@Test
	public void shouldParseReturnTypeDouble() {
		final ReturnTypeDouble lambda = () -> 1.0d;
		final Class<?> actual = Invocations.getLambdaSignature(lambda).getReturnType();
		assertThat(actual.getName()).isEqualTo("double");
	}

	@Test
	public void shouldParseReturnTypeFloat() {
		final ReturnTypeFloat lambda = () -> 1.0f;
		final Class<?> actual = Invocations.getLambdaSignature(lambda).getReturnType();
		assertThat(actual.getName()).isEqualTo("float");
	}

	@Test
	public void shouldParseReturnTypeInt() {
		final ReturnTypeInt lambda = () -> 1;
		final Class<?> actual = Invocations.getLambdaSignature(lambda).getReturnType();
		assertThat(actual.getName()).isEqualTo("int");
	}

	@Test
	public void shouldParseReturnTypeLong() {
		final ReturnTypeLong lambda = () -> 1L;
		final Class<?> actual = Invocations.getLambdaSignature(lambda).getReturnType();
		assertThat(actual.getName()).isEqualTo("long");
	}

	@Test
	public void shouldParseReturnTypeShort() {
		final ReturnTypeShort lambda = () -> (short) 1;
		final Class<?> actual = Invocations.getLambdaSignature(lambda).getReturnType();
		assertThat(actual.getName()).isEqualTo("short");
	}

	@Test
	public void shouldParseReturnTypeArrayReference() {
		final ReturnTypeArrayOfInt lambda = () -> new int[] {};
		final Class<?> actual = Invocations.getLambdaSignature(lambda).getReturnType();
		assertThat(actual.getName()).isEqualTo("[I");
	}

	@Test
	public void shouldParseReturnTypeArrayOfArrayReference() {
		final ReturnTypeArrayOfArrayOfString lambda = () -> new String[][] {};
		final Class<?> actual = Invocations.getLambdaSignature(lambda).getReturnType();
		assertThat(actual.getName()).isEqualTo("[[Ljava.lang.String;");
	}

	@Test
	public void shouldParseReturnTypeClassReference() {
		final ReturnTypeClassReference lambda = () -> "hi";
		final Class<?> actual = Invocations.getLambdaSignature(lambda).getReturnType();
		assertThat(actual.getName()).isEqualTo("java.lang.String");
	}

	@Test
	public void shouldParseNoParameterTypes() {
		final NoParameterTypes lambda = () -> {};
		final Class<?>[] actual = Invocations.getLambdaSignature(lambda).getParameterTypes();
		assertThat(actual).isEmpty();
	}
	
	@Test
	public void shouldParseOneParameterType() {
		final OneParameterType lambda = (int i) -> {};
		final Class<?>[] actual = Invocations.getLambdaSignature(lambda).getParameterTypes();
		assertThat(actual).containsExactly(int.class);
	}
	
	@Test
	public void shouldParseTwoParameterTypes() throws ClassNotFoundException {
		final TwoParameterTypes lambda = (String s, byte[][] bytes) -> {};
		final Class<?>[] actual = Invocations.getLambdaSignature(lambda).getParameterTypes();
		assertThat(actual).containsExactly(String.class, Class.forName("[[B"));
	}
	
	@FunctionalInterface
	static interface ReturnTypeVoid extends Serializable {
		void go();
	}

	@FunctionalInterface
	static interface ReturnTypeBoolean extends Serializable {
		boolean go();
	}
	
	@FunctionalInterface
	static interface ReturnTypeByte extends Serializable {
		byte go();
	}

	@FunctionalInterface
	static interface ReturnTypeChar extends Serializable {
		char go();
	}
	
	@FunctionalInterface
	static interface ReturnTypeFloat extends Serializable {
		float go();
	}
	
	@FunctionalInterface
	static interface ReturnTypeDouble extends Serializable {
		double go();
	}
	
	@FunctionalInterface
	static interface ReturnTypeInt extends Serializable {
		int go();
	}
	
	@FunctionalInterface
	static interface ReturnTypeLong extends Serializable {
		long go();
	}
	
	@FunctionalInterface
	static interface ReturnTypeShort extends Serializable {
		short go();
	}
	
	@FunctionalInterface
	static interface ReturnTypeArrayOfInt extends Serializable {
		int[] go();
	}
	
	@FunctionalInterface
	static interface ReturnTypeArrayOfArrayOfString extends Serializable {
		String[][] go();
	}
	
	@FunctionalInterface
	static interface ReturnTypeClassReference extends Serializable {
		String go();
	}

	@FunctionalInterface
	static interface NoParameterTypes extends Serializable {
		void go();
	}
	
	@FunctionalInterface
	static interface OneParameterType extends Serializable {
		void go(int i);
	}
	
	@FunctionalInterface
	static interface TwoParameterTypes extends Serializable {
		void go(String s, byte[][] bytes);
	}
	
}
