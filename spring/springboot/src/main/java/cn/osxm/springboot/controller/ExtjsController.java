/**
 * 
 */
package cn.osxm.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuemi
 *
 */
@RestController
@RequestMapping("/extjs")
public class ExtjsController {
	
	/**
	 * 
	 * @return {"datas":[{"value":"关羽"},{"value":"张飞"},{"value":"黄忠"},{"value":"马超"}]}
	 */
	@RequestMapping("/tagfield")
	public Map<String,Object> tagfield() {
		Map<String,Object> rtn = new HashMap<String,Object>();
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map1 = new HashMap<String,String>();
		map1.put("value", "关羽");  
		Map<String,String> map2 = new HashMap<String,String>();
		map2.put("value", "张飞");  
		Map<String,String> map3 = new HashMap<String,String>();
		map3.put("value", "黄忠");  
		Map<String,String> map4 = new HashMap<String,String>();
		map4.put("value", "马超");  
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		rtn.put("datas",list);
		return rtn;
	}

}
