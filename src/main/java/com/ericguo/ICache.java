/**
 * 
 */
package com.ericguo;

/**
 * @author eric guo 
 * @email  gyc567@aol.com
 */
public interface ICache<K,V> {

	V get(K key);
	boolean put(K key,V value);
	boolean remove(K key);
	int size();
}
