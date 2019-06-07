package cn.edu.jxnu.base.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * RedisTemplate
 */
public interface RedisService {

	/**
	 * 缓存map

	 */
	boolean putMap(String key, Map<Integer, List<String>> map) throws Exception;

	/**
	 * 查询哈希表 hKey 中给定域 hashKey 的值.
	 */
	List<String> hashGet(String hKey, Integer hashKey);

	/**
	 * 获取所有的KV散列值
	 */
	Map<Integer, List<String>> hashGetAll(String key) throws Exception;

	/**
	 * <p>
	 * 哈希表 hKey 中的域 hashKey 的值加上增量 delta 。 增量也可以为负数，相当于对给定域进行减法操作。 如果 key
	 * 不存在，一个新的哈希表被创建并执行 HINCRBY 命令。 如果域 field 不存在，那么在执行命令前，域的值被初始化为 0 。 对一个储存字符串值的域
	 * field 执行 HINCRBY 命令将造成一个错误。
	 * </p>
	 *
	 */
	// Long hashIncrementLongOfHashMap(String hKey, Integer hashKey, Integer i);

	/**
	 * 添加键值对到哈希表key中
	 */
	public void hashPushHashMap(String key, Integer hashKey, List<String> value);

	/**
	 * 获取哈希表key中的所有域
	 */
	Set<Object> hashGetAllHashKey(String key);

	/**
	 * 删除一个或多个哈希字段
	 */
	Long hashDeleteHashKey(String key, Object... hashKeys);

	/**
	 * 通过key删除
	 * 
	 * @param key
	 */
	boolean del(String key);

	/**
	 * 获取redis value (String)
	 * 
	 * @param key
	 * @return
	 */
	String get(String key);

	/**
	 * 添加key value 并且设置存活时间
	 * 
	 * @param key
	 * @param value
	 * @param liveTime
	 *            单位秒
	 */
	void set(String key, String value, long liveTime);

	/**
	 * 添加key value
	 * 
	 * @param key
	 * @param value
	 */
	void set(String key, String value);

}
