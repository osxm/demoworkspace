/**
 * @Title: HomeService.java
 * @Package com.osxm.springboot.service
 * @Description: TODO
 * @author oscarchen
 * @date 2019年11月14日
 * @version V1.0
 */
package com.osxm.springboot.service;

/**
  * @ClassName: HomeService
  * @Description: TODO
  * @author oscarchen
  */
public interface HomeService {

    public String login(String userId,String password);
    
    public void logout();
}

