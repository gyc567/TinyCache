/**
 * 
 */
package com.ericguo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

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
	@Test
	public void test_string_to_integer_function()
	{
		List<String> list1 = ImmutableList.of("1", "2");
		List<String> list2 = ImmutableList.of("3", "4");
		List<String> list3 = ImmutableList.of("5", "6");
		List<List<String>> lists = ImmutableList.of(list1, list2, list3);
		ArrayList<Integer> integerArrayList = Lists.newArrayList(Iterables.transform(Iterables.concat(lists), StringToIntegerFunction.INSTANCE));
		assertThat(integerArrayList.get(0),is(1));
	}
	
	public final static class StringToIntegerFunction implements Function<String,Integer>
	{
		public static final StringToIntegerFunction INSTANCE=new StringToIntegerFunction();
		private StringToIntegerFunction(){}
		
		//convert the String to Integer
		public Integer apply(String input) {
			if(null==input)
				return null;
			
			return Integer.valueOf(input);
		}
		
	}
	
	

}
