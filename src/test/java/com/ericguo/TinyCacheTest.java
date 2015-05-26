/**
 * 
 */
package com.ericguo;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;





/**
 * @author eric guo 
 * @email  gyc567@aol.com
 */
public class TinyCacheTest {
	ICache<String, String> cache=null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cache=new TinyCache<String, String>(2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		cache=null;
	}

	@Test
	public void testPut() {
		String key="0";
		String value="a";
		Assert.assertTrue(cache.put(key, value));
		String key1="01";
		String value1="a1";
		Assert.assertTrue(cache.put(key1, value1));
		Assert.assertEquals("a", cache.get("0"));
		Assert.assertEquals("a1", cache.get("01"));
		String key12="012";
		String value12="a12";
		Assert.assertTrue(cache.put(key12, value12));
		
		Assert.assertNull(cache.get("0"));
		Assert.assertEquals("a12", cache.get("012"));
	}

}
