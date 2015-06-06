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
	
	private  Deque<K> queue;//FIFO,maintain the newest key in first index
	private  Map<K,V> map;//map to store key,value pair
	
	private int limit=100;
	/*
	 * constructor with initial limit size 
	 */
	public TinyLRUCache(int limit) {
		super();
		this.queue=new LinkedList<K>();
		this.map=new HashMap<K, V>();
		this.limit=limit;
		
	}

	/*
	 * get value with key
	 * @see com.github.ericguo.ICache#get(java.lang.Object)
	 */
	public V get(K key) {
		return map.get(key);
	}

	public boolean put(K key, V value) {
		//if the putting on is equal the old value,re-index the key in queue 
		V oldValue=map.put(key, value);
		if(null!=oldValue)
		{
			queue.removeFirstOccurrence(key);
		}
		queue.addFirst(key);
		//while the map reach the limit size,remove the oldest value for queue and map
		if(map.size()>limit)
		{
			K k=queue.removeLast();
			map.remove(k);
		}
		
		return true;
	}

	/*
	 * remove the value with key
	 * @see com.github.ericguo.ICache#remove(java.lang.Object)
	 */
	public boolean remove(Object key) {
		
		return queue.removeFirstOccurrence(key)&&(null!=map.remove(key));
	}

	/* 
	 * return the size of map
	 * 
	 */
	public int size() {
		// TODO Auto-generated method stub
		return map.size();
	}
	
	

}
