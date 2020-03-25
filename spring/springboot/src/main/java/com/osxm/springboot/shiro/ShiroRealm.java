/**
 * @Title: ShiroRealm.java
 * @Package com.osxm.springboot.shiro
 * @Description: TODO
 * @author oscarchen
 * @date 2019年11月7日
 * @version V1.0
 */
package com.osxm.springboot.shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.osxm.springboot.entity.Permission;
import com.osxm.springboot.entity.Role;
import com.osxm.springboot.entity.User;
import com.osxm.springboot.service.UserService;

/**
 * @ClassName: ShiroRealm
 * @Description: TODO
 * @author oscarchen
 */
public class ShiroRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		User user = (User) principals.getPrimaryPrincipal();
		for (Role role : user.getRoleList()) {
			authorizationInfo.addRole(role.getRoleName());
			for (Permission p : role.getPermissions()) {
				authorizationInfo.addStringPermission(p.getPermission());
			}
		}
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String userId = (String) token.getPrincipal();
		User user = userService.get(userId);
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userId, user.getPassword(),
				getName());
		return authenticationInfo;
	}

}
