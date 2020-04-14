/**
 * @Title: Usr.java
 * @Package cn.osxm.springboot.entity
 * @Description: TODO
 * @author oscarchen
 * @date 2020年4月11日
 * @version V1.0
 */
package cn.osxm.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @ClassName: Usr
 * @Description: TODO
 * @author oscarchen
 */
@Entity
public class Usr {

	@Id
	private Integer id;

	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
