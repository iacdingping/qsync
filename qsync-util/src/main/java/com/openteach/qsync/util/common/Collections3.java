package com.openteach.qsync.util.common;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Collections工具集.
 * 在JDK的Collections和Guava的Collections2后, 命名为Collections3.
 * 
 */
public class Collections3 {

	private Collections3() {
	}

	/**
	 * a b 交集
	 * @param a
	 * @param b
	 * @param needSorted	如果为false 则 ac与bc默认已经排好序而且排序方式必须与c的一致
	 * @return
	 */
	public static int[] intersection(int[] a, int[] b, boolean needSorted) {
		List<Integer> result = new ArrayList<Integer>(Math.max(a.length,
				b.length));
		if (needSorted) {
			Arrays.sort(a);
			Arrays.sort(b);
		}
		for (int indexA = 0, lenA = a.length, indexB = 0, lenB = b.length; indexA < lenA
				&& indexB < lenB;) {
			if (a[indexA] == b[indexB]) {
				result.add(a[indexA]);
				indexA++;
				indexB++;
			} else if (a[indexA] < b[indexB]) {
				indexA++;
			} else {
				indexB++;
			}
		}
		int[] arrayresult = new int[result.size()];
		for(int i=0; i<arrayresult.length; i++) {
			arrayresult[i] = result.get(i);
		}
		return arrayresult;
	}
	
	/**
	 * 
	 * @param ac
	 * @param bc
	 * @param c				
	 * @param needSort	如果为false 则 ac与bc默认已经排好序而且排序方式必须与c的一致
	 * @return
	 */
	public static <T> List<T> intersection(final Collection<T> ac, final Collection<T> bc, 
			Comparator<T> c, boolean needSort) {
		List<T> a = new ArrayList<T>(ac);
		List<T> b = new ArrayList<T>(bc);
		List<T> result = new ArrayList<T>();
		if(needSort) {
			Collections.sort(a, c);
			Collections.sort(b, c);
		}
		for (int indexA = 0, lenA = a.size(), indexB = 0, lenB = b.size();
				indexA < lenA && indexB < lenB;) {
			if (c.compare(a.get(indexA), b.get(indexB)) == 0) {
				result.add(a.get(indexA));
				indexA++;
				indexB++;
			} else if (c.compare(a.get(indexA), b.get(indexB)) < 0) {
				indexA++;
			} else {
				indexB++;
			}
		}
		return result;
	}

	/**
	 * 多个集合的交集
	 * 小集合放在前面 速度会稍快
	 * @param c
	 * @param needSort
	 * @param ac
	 * @return
	 */
	public static <T> List<T> intersection(Comparator<T> c, boolean needSort, List<List<T>> ac) {
		Collections.sort(ac, new Comparator<Collection<T>>() {
			@Override
			public int compare(Collection<T> o1, Collection<T> o2) {
				return o1.size() - o2.size();
			}
		});
		List<T> result = null;
		for(List<T> l : ac) {
			if(result == null) {
				result = new ArrayList<T>();
				result.addAll(l);
			} else {
				result = intersection(l, result, c, needSort);
			}
		}
		return result;
	}
	
	/**
	 * 多个集合的交集
	 * 小集合放在前面 速度会稍快
	 * @param c
	 * @param needSort
	 * @param ac
	 * @return
	 */
	public static <T> List<T> intersection(Comparator<T> c, boolean needSort, List<T>... arrays) {
		List<List<T>> ac = new ArrayList<List<T>>();
		for(List<T> tmp : arrays) {
			ac.add(tmp);
		}
		return intersection(c, needSort, ac);
	}
	
	/**
	 * 返回a-b的集合.
	 * @deprecated 需要确保 a b 两个集合中的元素是相同的引用
	 */
	public static <T> List<T> subtract(final Collection<T> a, final Collection<T> b) {
		ArrayList<T> list = new ArrayList<T>(a);
		for (Object element : b) {
			list.remove(element);
		}
		return list;
	}
	
	/**
	 * 返回a-b的集合.
	 */
	public static <T> List<T> subtract(final List<T> a, final List<T> b, Comparator<T> c, boolean needSorted) {
		if(needSorted) {
			Collections.sort(a, c);
			Collections.sort(b, c);
		}
		List<T> list = new ArrayList<T>();
		for(int i=0, j=0; i<a.size()&&j<b.size(); ) {
			T at = a.get(i);
			T bt = b.get(j);
			int m = c.compare(at, bt);
			if(m == 0) {
				a.remove(at);
			} else if(m > 0)
				j++;
			else 
				i++;
		}
		return list;
	}
	
	public static <T> List<T> substract(
			List<T> a, int start, int size) {
		if(start > a.size()) {
			return new ArrayList<T>(0);
		}
		List<T>	list = new ArrayList<T>(size);
		for(int i=start-1, c=1; c<=size && i<a.size(); i++, c++) {
			list.add(a.get(i));
		}
		return list;
	}
	
	public static <T> List<T> substractAndRemove(
			List<T> a, int start, int size) {
		if(start > a.size()) {
			return new ArrayList<T>(0);
		}
		List<T>	list = new ArrayList<T>(size);
		for(int i=start-1, c=1; c<=size && i<a.size(); i++, c++) {
			list.add(a.get(i));
		}
		a.removeAll(list);
		return list;
	}
	
	/**
	 * 提取集合中的对象的属性(通过Getter函数), 组合成Map.
	 * 
	 * @param collection 来源集合.
	 * @param keyPropertyName 要提取为Map中的Key值的属性名.
	 * @param valuePropertyName 要提取为Map中的Value值的属性名.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map extractToMap(final Collection collection, final String keyPropertyName,
			final String valuePropertyName) {
		Map map = new HashMap(collection.size());

		try {
			for (Object obj : collection) {
				map.put(PropertyUtils.getProperty(obj, keyPropertyName),
						PropertyUtils.getProperty(obj, valuePropertyName));
			}
		} catch (Exception e) {
			throw Reflections.convertReflectionExceptionToUnchecked(e);
		}

		return map;
	}

	/**
	 * 提取集合中的对象的属性(通过Getter函数), 组合成List.
	 * 
	 * @param collection 来源集合.
	 * @param propertyName 要提取的属性名.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List extractToList(final Collection collection, final String propertyName) {
		List list = new ArrayList(collection.size());

		try {
			for (Object obj : collection) {
				list.add(PropertyUtils.getProperty(obj, propertyName));
			}
		} catch (Exception e) {
			throw Reflections.convertReflectionExceptionToUnchecked(e);
		}

		return list;
	}
	
	/**
	 * 提取集合中的对象的属性(通过Getter函数), 组合成由分割符分隔的字符串.
	 * 
	 * @param collection 来源集合.
	 * @param propertyName 要提取的属性名.
	 * @param separator 分隔符.
	 */
	@SuppressWarnings("rawtypes")
	public static String extractToString(final Collection collection, final String propertyName, final String separator) {
		List list = extractToList(collection, propertyName);
		return StringUtils.join(list, separator);
	}

	/**
	 * 转换Collection为String, 中间以 separator分隔。
	 */
	@SuppressWarnings("rawtypes")
	public static String convertToString(final Collection collection, final String separator) {
		return StringUtils.join(collection, separator);
	}

	/**
	 * 转换Collection为String, 每个元素的前面加入prefix，后面加入postfix，如<div>mymessage</div>。
	 */
	@SuppressWarnings("rawtypes")
	public static String convertToString(final Collection collection, final String prefix, final String postfix) {
		StringBuilder builder = new StringBuilder();
		for (Object o : collection) {
			builder.append(prefix).append(o).append(postfix);
		}
		return builder.toString();
	}
	
	public static void test() {
		int[] a = new int[1000000];
		int[] b = new int[1000000];
		
		Random r = new Random();
		
		for(int i=0; i<a.length; i++) {
			a[i] = r.nextInt(1000000);
		}
		for(int i=0; i<b.length; i++) {
			b[i] = r.nextInt(1000000);
		}
		
		long start = System.currentTimeMillis();
		
		int[] res = intersection(a, b, true);
		
		long end = System.currentTimeMillis();
		
		System.out.println(a.length + " 与 " + b.length + "交集:" + res.length + " cost " + (end - start));

	}
	
	public static void test2() {
		List<String> l = new ArrayList<String>();
		l.add("1");
		l.add("2");
		l.add("3");
		l.add("4");
		l.add("5");
		l.add("6");
		List<String> t = substract(l, 4, 3);
		
		for(String s : t) {
			System.out.println(s);
		}
	} 
	
	public static void main(String[] args) {
		test2();
	}
	
}
