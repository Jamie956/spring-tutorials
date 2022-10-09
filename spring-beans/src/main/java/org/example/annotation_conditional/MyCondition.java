package org.example.annotation_conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyCondition implements Condition {
	/**
	 * 返回false 时，使用这个condition 的类就不成实例化成bean
	 * context 容器
	 * metadata 获取使用condition 注解的类、方法信息
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		try {
			context.getClassLoader().loadClass("com.cat.annotation_conditional.X");
			//当X不存在时，返回false
//			context.getClassLoader().loadClass("com.cat.annotation_conditional.X123");
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}
}
