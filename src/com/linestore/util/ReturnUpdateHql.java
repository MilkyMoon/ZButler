package com.linestore.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

public class ReturnUpdateHql {
	public static String ReturnHql(Class c, Object t, int id) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		boolean flag = true;

		String Name = null;

		String idString = null;

		String hql = "update " + c.getSimpleName() + " my set ";

		Field[] fs = c.getDeclaredFields();

		for (int i = 0; i < fs.length; i++) {
			// System.out.println(fs[i].getType().getSimpleName() + "=====" +
			// upperCase(fs[i].getName()));
			if (!"Set".equals(fs[i].getType().getSimpleName())) {

				if (idString == null) {
					idString = getFirstUp(fs[i].getName()) + "Id";
				}
				Method m = c.getDeclaredMethod("get" + upperCase(fs[i].getName()));
				if (m.invoke(t) != null && !"".equals(m.invoke(t))) {
					Name = fs[i].getType().getSimpleName();
					switch (Name) {
					case "Integer":
						if (flag) {
							flag = false;
							hql += "my." + fs[i].getName() + "=" + m.invoke(t);
						} else {
							hql += ", my." + fs[i].getName() + "=" + m.invoke(t);
						}
						break;
					case "Float":
						if (flag) {
							flag = false;
							hql += "my." + fs[i].getName() + "=" + m.invoke(t);
						} else {
							hql += ", my." + fs[i].getName() + "=" + m.invoke(t);
						}
						break;
					case "String":
						if (flag) {
							flag = false;
							hql += "my." + fs[i].getName() + "='" + (String) m.invoke(t) + "'";
						} else {
							hql += ", my." + fs[i].getName() + "='" + (String) m.invoke(t) + "'";
						}
						break;
					case "Date":
						SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String date = ft.format(m.invoke(t));
						if (flag) {
							flag = false;
							hql += "my." +fs[i].getName() + "='" + date + "'";
						} else {
							hql += ", my." + fs[i].getName() + "='" + date + "'";
						}
						break;
					default:
						String idStringOther = null;
						System.out.println(m.invoke(t));
						Class cOther = m.invoke(t).getClass();
						Field[] fsOther = cOther.getDeclaredFields();
						for (int j = 0; j < fsOther.length; j++) {
							if (!"Set".equals(fsOther[j].getType().getSimpleName())) {
								if (idStringOther == null) {
									idStringOther = getFirstUp(fsOther[j].getName()) + "Id";
								}
							}
						}
						System.out.println(idStringOther);
						Method mOther = cOther.getDeclaredMethod("get" + upperCase(idStringOther));
						System.out.println(mOther.invoke(m.invoke(t)));
						if (flag) {
							flag = false;
							hql += "my." +fs[i].getName() + "." + idStringOther + "=" + mOther.invoke(m.invoke(t)) + "";
						} else {
							hql += ", my." + fs[i].getName() + "." + idStringOther + "=" + mOther.invoke(m.invoke(t)) + "";
						}
					}
				}
			}

		}

		hql += " where " + idString + "=" + id;

		System.out.println(hql);
		
		return hql;
	}

	public static String upperCase(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);
	}

	public static String getFirstUp(String str) {
		String re = "";
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= 'A' && ch[i] <= 'Z') {
				break;
			} else {
				re += ch[i];
			}
		}
		return re;
	}
	
	public static String ReturnHql(Class c, Object t, String id) throws NoSuchMethodException, SecurityException,
		IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	
	boolean flag = true;
	
	String Name = null;
	
	String idString = null;
	
	String hql = "update " + c.getSimpleName() + " set ";
	
	Field[] fs = c.getDeclaredFields();
	
	for (int i = 0; i < fs.length; i++) {
		// System.out.println(fs[i].getType().getSimpleName() + "=====" +
		// upperCase(fs[i].getName()));
		if (!"Set".equals(fs[i].getType().getSimpleName())) {
	
			if (idString == null) {
				idString = getFirstUp(fs[i].getName()) + "Id";
			}
			Method m = c.getDeclaredMethod("get" + upperCase(fs[i].getName()));
			if (m.invoke(t) != null && !"".equals(m.invoke(t))) {
				Name = fs[i].getType().getSimpleName();
				switch (Name) {
				case "Integer":
					if (flag) {
						flag = false;
						hql += fs[i].getName() + "=" + m.invoke(t);
					} else {
						hql += ", " + fs[i].getName() + "=" + m.invoke(t);
					}
					break;
				case "Float":
					if (flag) {
						flag = false;
						hql += fs[i].getName() + "=" + m.invoke(t);
					} else {
						hql += ", " + fs[i].getName() + "=" + m.invoke(t);
					}
					break;
				case "String":
					if (flag) {
						flag = false;
						hql += fs[i].getName() + "='" + (String) m.invoke(t) + "'";
					} else {
						hql += ", " + fs[i].getName() + "='" + (String) m.invoke(t) + "'";
					}
					break;
				case "Date":
					SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String date = ft.format(m.invoke(t));
					if (flag) {
						flag = false;
						hql += fs[i].getName() + "='" + date + "'";
					} else {
						hql += ", " + fs[i].getName() + "='" + date + "'";
					}
					break;
				default:
					String idStringOther = null;
					System.out.println(m.invoke(t));
					Class cOther = m.invoke(t).getClass();
					Field[] fsOther = cOther.getDeclaredFields();
					for (int j = 0; j < fsOther.length; j++) {
						if (!"Set".equals(fsOther[j].getType().getSimpleName())) {
							if (idStringOther == null) {
								idStringOther = getFirstUp(fsOther[j].getName()) + "Id";
							}
						}
					}
					System.out.println(idStringOther);
					Method mOther = cOther.getDeclaredMethod("get" + upperCase(idStringOther));
					System.out.println(mOther.invoke(m.invoke(t)));
					if (flag) {
						flag = false;
						hql += fs[i].getName() + "." + idStringOther + "=" + mOther.invoke(m.invoke(t)) + "";
					} else {
						hql += ", " + fs[i].getName() + "." + idStringOther + "=" + mOther.invoke(m.invoke(t)) + "";
					}
				}
			}
		}
	
	}
	
	hql += " where " + idString + "='" + id + "'";
	
	System.out.println(hql);
	
	return hql;
	}
}
