package org.example.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Y {
	//存在多个X bean的情况
	//先byType匹配，如果只有1个 Bean，完成匹配
	//如果有多个相同的type时，再根据Name去匹配，只有一个Name时完成匹配，否则失败
	@Autowired
	private X x;

}
