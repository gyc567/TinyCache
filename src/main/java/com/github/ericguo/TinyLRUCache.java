package com.github.ericguo;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author eric guo 
 * @email  gyc567@aol.com
 */
public class TinyLRUCache<K,V> implements ICache<K, V>{
	
	private  Deque<K> queue;
	private  Map<K,V> map;
	
	private int limit=100;
	
	public TinyLRUCache(int limit) {
		super();
		this.queue=new LinkedList<K>();
		this.map=new HashMap<K, V>();
		this.limit=limit;
		
	}

	public V get(K key) {
		return map.get(key);
	}

	public boolean put(K key, V value) {
		
		V oldValue=map.put(key, value);
		if(null!=oldValue)
		{
			queue.removeFirstOccurrence(key);
		}
		queue.addFirst(key);
		if(map.size()>limit)
		{
			K k=queue.removeLast();
			map.remove(k);
		}
		
		return true;
	}

	public boolean remove(Object key) {
		
		return queue.removeFirstOccurrence(key)&&(null!=map.remove(key));
	}

	/* (non-Javadoc)
	 * @see main.com.ericguo.ICache#size()
	 */
	public int size() {
		// TODO Auto-generated method stub
		return map.size();
	}
	
	

}
