/**
 * 
 */
package com.lingzhuo.factory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.lingzhuo.entity.ManagerEntity;

/**
 * @ClassName: BeanFactory
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LHX
 * @date 2017年8月30日 下午5:25:34
 *
 */
public class BeanFactory {
	
	private Object bean;
	private static BeanFactory beanFactory;
	public static BeanFactory getBeanFactory(){
		if(beanFactory!=null){
		return beanFactory;
		}else{
			beanFactory =new BeanFactory();
			return beanFactory;
		}
	}
	
	public Object getBean(Class obj){
		try {
			bean=obj.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
		
	}
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException{
		ManagerEntity mgr =new ManagerEntity(); 
		Class obj =mgr.getClass();	
		//获取类名
		System.out.println("------obj.getCanon...-----:"+obj.getCanonicalName());
	    //获取属性
		Field[] fields =obj.getDeclaredFields();
		for(int i=0 ;i<fields.length;i++){
			System.out.println("属性名："+fields[i].getName()+"类型："+fields[i].getType().getName());
			
		}
		//获取方法
		try {
			Method methods =obj.getMethod("setManagerId",Integer.class);
			methods.invoke(mgr, 1000);//调用方法
			
			Method method1=obj.getMethod("getManagerId");
			Integer res=(Integer) method1.invoke(mgr);
			
			System.out.println("-----res--------:"+res);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Class obj1 =Class.forName("com.lingzhuo.entity.ManagerEntity");
		try {
			obj1.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ManagerEntity  mgr1 =(ManagerEntity) BeanFactory.getBeanFactory().getBean(ManagerEntity.class);
		mgr1.setManagerId(999);
		mgr1.setUsername("qianqian");
		System.out.println("-----mgr-----"+mgr1.getManagerId()+";name:"+mgr1.getUsername());
		
	}

}
