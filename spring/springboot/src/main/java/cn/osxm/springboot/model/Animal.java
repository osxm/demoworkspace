
package cn.osxm.springboot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import cn.osxm.springboot.web.StringToBoolSerializer;

/**
 * @author xuemi
 *
 */
public class Animal {
	private String name;

	@JsonSerialize(using = StringToBoolSerializer.class)
	//@JsonFormat(shape=Shape.BOOLEAN)
	//@JsonSerialize(using = BooleanSerializer.class)
	private String extinct;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtinct() {
		return extinct;
	}

	public void setExtinct(String extinct) {
		this.extinct = extinct;
	}
}
