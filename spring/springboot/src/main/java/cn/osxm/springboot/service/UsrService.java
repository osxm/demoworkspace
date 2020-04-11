/**
 * @Title: UsrService.java
 * @Package cn.osxm.springboot.service
 * @Description: TODO
 * @author oscarchen
 * @date 2020年4月11日
 * @version V1.0
 */
package cn.osxm.springboot.service;

import java.util.List;

import cn.osxm.springboot.entity.Usr;

/**
  * @ClassName: UsrService
  * @Description: TODO
  * @author oscarchen
  */
public interface UsrService {

	public List<Usr> listSafe(String id);
	public List<Usr> listUnSafe(String id);
}
