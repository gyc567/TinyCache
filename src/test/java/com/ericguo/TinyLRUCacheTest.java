/**
 * 
 */
package com.ericguo;



import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * @author eric guo 
 * @email  gyc567@aol.com
 */
public class TinyLRUCacheTest {
	ICache<String, String> cache=null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cache=new TinyLRUCache<String, String>(2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		cache=null;
	}

	@Test
	public void testPutAndGet() {
		String key="0";
		String value="a";
		String key1="01";
		String value1="a1";
		
		assertThat(cache.put(key, value), is(true));
		assertThat(cache.put(key1, value1), is(true));
		assertThat(cache.get(key), is(value));
		assertThat(cache.get(key1), is(value1));
		
		String key12="012";
		String value12="a12";
		assertThat(cache.put(key12, value12), is(true));
		assertThat(cache.get(key), not(value));
		assertThat(cache.get(key12), is(value12));
	}
	@Test
	public void testRemove() {
		String key="0";
		String value="a";
		Assert.assertTrue(cache.put(key, value));
		
		String key1="01";
		String value1="a1";
		Assert.assertTrue(cache.put(key1, value1));
		Assert.assertEquals("a", cache.get("0"));
		Assert.assertEquals("a1", cache.get("01"));
		cache.remove(key1);
		String key12="012";
		String value12="a12";
		Assert.assertTrue(cache.put(key12, value12));
		
		Assert.assertNotNull(cache.get(key));
		Assert.assertNull(cache.get(key1));
		
	}

}
