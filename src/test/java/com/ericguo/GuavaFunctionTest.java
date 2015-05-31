/**
 * 
 */
package com.ericguo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Functions;

/**
 * @author eric guo
 * @email gyc567@aol.com
 */
public class GuavaFunctionTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		Map<String, Integer> map = new HashMap<String, Integer>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				put("love", 1);
				put("miss", 5);
			}
		};
		Function<String, Integer> mapFun;
		mapFun = Functions.forMap(map);

		Function<Integer, Integer> squareFun = new Function<Integer, Integer>() {

			public Integer apply(Integer input) {
				// TODO Auto-generated method stub
				return input * input;
			}

		};

		assertThat(mapFun.apply("love"), is(1));
		Function<String, Integer> compose = Functions
				.compose(squareFun, mapFun);
		assertThat(compose.apply("miss"), is(25));

	}

}
