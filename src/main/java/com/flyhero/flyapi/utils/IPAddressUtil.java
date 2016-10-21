package com.flyhero.flyapi.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class IPAddressUtil {

	private static Logger log = Logger.getLogger(IPAddressUtil.class);

	public static String getRemortIP(HttpServletRequest request) {
		if (request.getHeader("x-forwarded-for") == null) {
			return request.getRemoteAddr();
		}
		return request.getHeader("x-forwarded-for");
	}

	public static String getIPAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unkonwn".equalsIgnoreCase(ip)) {
			ip = request.getHeader("PRoxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unkonwn".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unkonwn".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip == null || ip.length() == 0 || "unkonwn".equalsIgnoreCase(ip)) {
			ip = request.getHeader("http_client_ip");
		}
		if (ip == null || ip.length() == 0 || "unkonwn".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDEC_FOR");
		}
		if (ip != null && ip.indexOf(",") != -1) {
			ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
		}
		return ip;
	}
	/**
	 * 
	 * @param content
	 *            ����Ĳ��� ��ʽΪ��name=xxx&pwd=xxx
	 * @param encoding
	 *            ��������������롣��GBK,UTF-8��
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getPosition(String content, String encodingString) {
		try {
			// �������pconline�Ľӿ�
			String urlStr = "http://ip.taobao.com/service/getIpInfo.php";
			// ��http://whois.pconline.com.cnȡ��IP���ڵ�ʡ������Ϣ
			String returnStr = getResult(urlStr, content, encodingString);
			if (returnStr != null) {
				// ���?�ص�ʡ������Ϣ
				log.info("result:" + returnStr);
				String[] temp = returnStr.split(",");
				if (temp.length < 3) {
					return "0";// ��ЧIP�����������
				}

				String country = "";
				String area = "";
				String region = "";
				String city = "";
				String county = "";
				String isp = "";
				for (int i = 0; i < temp.length; i++) {
					switch (i) {
					case 1:
						country = (temp[i].split(":"))[2].replaceAll("\"", "");
						country = decodeUnicode(country);// ���
						break;
					case 3:
						area = (temp[i].split(":"))[1].replaceAll("\"", "");
						area = decodeUnicode(area);// ����
						break;
					case 5:
						region = (temp[i].split(":"))[1].replaceAll("\"", "");
						region = decodeUnicode(region);// ʡ��
						break;
					case 7:
						city = (temp[i].split(":"))[1].replaceAll("\"", "");
						city = decodeUnicode(city);// ����
						break;
					case 9:
						county = (temp[i].split(":"))[1].replaceAll("\"", "");
						county = decodeUnicode(county);// ����
						break;
					case 11:
						isp = (temp[i].split(":"))[1].replaceAll("\"", "");
						isp = decodeUnicode(isp); // ISP��˾
						break;
					}
				}
				return country + "," + area + "," + region + "," + city + "," + county + "," + isp;
			}
			return null;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	/**
	 * @param urlStr
	 *            ����ĵ�ַ
	 * @param content
	 *            ����Ĳ��� ��ʽΪ��name=xxx&pwd=xxx
	 * @param encoding
	 *            ��������������롣��GBK,UTF-8��
	 * @return
	 */
	private static String getResult(String urlStr, String content, String encoding) {
		URL url = null;
		HttpURLConnection connection = null;
		try {
			url = new URL(urlStr);
			connection = (HttpURLConnection) url.openConnection();// �½�����ʵ��
			connection.setConnectTimeout(2000);// �������ӳ�ʱʱ�䣬��λ����
			connection.setReadTimeout(2000);// ���ö�ȡ��ݳ�ʱʱ�䣬��λ����
			connection.setDoOutput(true);// �Ƿ������� true|false
			connection.setDoInput(true);// �Ƿ��������true|false
			connection.setRequestMethod("POST");// �ύ����POST|GET
			connection.setUseCaches(false);// �Ƿ񻺴�true|false
			connection.connect();// �����Ӷ˿�
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());// ���������Զ˷�����д���
			out.writeBytes("ip=" + content);// д���,Ҳ�����ύ��ı? name=xxx&pwd=xxx
			out.flush();// ˢ��
			out.close();// �ر������
			// ��Զ�д����ݶԶ˷������������,��BufferedReader������ȡ
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			return buffer.toString();
		} catch (IOException e) {
			log.error(e.getMessage());
		} finally {
			if (connection != null) {
				connection.disconnect();// �ر�����
			}
		}
		return null;
	}

	/**
	 * unicode ת���� ����
	 * 
	 * @param theString
	 * @return
	 */
	public static String decodeUnicode(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException("Malformed      encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't') {
						aChar = '\t';
					} else if (aChar == 'r') {
						aChar = '\r';
					} else if (aChar == 'n') {
						aChar = '\n';
					} else if (aChar == 'f') {
						aChar = '\f';
					}
					outBuffer.append(aChar);
				}
			} else {
				outBuffer.append(aChar);
			}
		}
		return outBuffer.toString();
	}

}
