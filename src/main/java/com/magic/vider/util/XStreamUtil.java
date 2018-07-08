package com.magic.vider.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

public class XStreamUtil {
	/**
	 * 将object转化成xml
	 * @param obj
	 * @return
	 */
	public static String objectToXml(Object obj){
		XStream stream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
		if (null == obj) {
			return null;
		}
		//xstream使用注解转换
		stream.processAnnotations(obj.getClass());
		return stream.toXML(obj);
	}
	/**
	 * 将xml转成object
	 * @param xml
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xmlToObject(String xml,Class<T> cls) {
		XStream stream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
		//xstream使用注解转换
		stream.processAnnotations(cls);
		return (T)stream.fromXML(xml);
	}
}
