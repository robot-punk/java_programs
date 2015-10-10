package com.drag_and_drops.utils;

import java.util.Properties;

/**
 * リソースユーティリティ
 *
 * @author takashi-okumura
 *
 */
public final class ResourceUtil {
	public ResourceUtil() {

	}

	public static Properties getProperties(String path) {
		return org.seasar.framework.util.ResourceUtil.getProperties(path);
	}

	public static String getPropertyValue(String key) {
		// TODO ロケール対応
		return ResourceUtil.getPropertyValue("application.properties", key);
	}

	public static String getPropertyValue(String path, String key) {
		// TODO ロケール対応
		return ResourceUtil.getProperties(path).getProperty(key);
	}

}
