package com.flyhero.flyapi.utils;

public final class FormatUtil {

	/**
	 * 对json字符串格式化
	 * @Title: formatJsonString 
	 * @author flyhero(http://flyhero.top)  
	 * @date 2016年12月28日 下午5:20:09 
	 * @param @param jsonStr
	 * @param @return   
	 * @return String    
	 * @throws
	 */
	public static String formatJsonString(String jsonStr) {
		if (null == jsonStr || "".equals(jsonStr))
			return "";
		StringBuilder sb = new StringBuilder();
		char last = '\0';
		char current = '\0';
		int indent = 0;
		for (int i = 0; i < jsonStr.length(); i++) {
			last = current;
			current = jsonStr.charAt(i);
			switch (current) {
			case '{':
			case '[':
				sb.append(current);
				sb.append("<w:br />");
				indent++;
				addTab(sb, indent);
				break;
			case '}':
			case ']':
				sb.append("<w:br />");
				indent--;
				addTab(sb, indent);
				sb.append(current);
				break;
			case ',':
				sb.append(current);
				if (last != '\\') {
					sb.append("<w:br />");
					addTab(sb, indent);
				}
				break;
			default:
				sb.append(current);
			}
		}

		return sb.toString();
	}

	/**
	 * 添加制表符
	 * @Title: addTab 
	 * @author flyhero(http://flyhero.top)  
	 * @date 2016年12月28日 下午5:21:31 
	 * @param @param sb
	 * @param @param indent   
	 * @return void    
	 * @throws
	 */
	private static void addTab(StringBuilder sb, int indent) {
		for (int i = 0; i < indent; i++) {
			sb.append("<w:t  xml:space=\"preserve\">    </w:t>");
		}
	}
	
}