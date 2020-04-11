/**
 * @Title: UserService.java
 * @Package cn.osxm.h2springboot.service
 * @Description: TODO
 * @author oscarchen
 * @date 2020年4月10日
 * @version V1.0
 */
package cn.osxm.h2springboot.service;

import java.util.List;

import cn.osxm.h2springboot.entity.Usr;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @author oscarchen
 */
public interface UsrService {

	public List<Usr> list();
}
