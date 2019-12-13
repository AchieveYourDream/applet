package com.kute.appletcore.util.weixin;

import com.kute.appletcore.util.MD5Util;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

/**
 * @ClaseName
 * @Auther 王斌
 * @Date
 **/
public class WxChatXmlUtil {

    /**
     * Map转换成XML
     * @param data
     * @return
     * @throws Exception
     */
    public static String recursionMapToXml(Map<String, Object> data) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder= documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        Element root = document.createElement("xml");
        document.appendChild(root);
        for (String key: data.keySet()) {
            String value = data.get(key).toString();
            if (value == null) {
                value = "";
            }
            value = value.trim();
            Element filed = document.createElement(key);
            filed.appendChild(document.createTextNode(value));
            root.appendChild(filed);
        }

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(document);
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
        String output = writer.getBuffer().toString();

        try {
            writer.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        output = output.substring(output.indexOf("?>")+2,output.length());
        return output;
    }


    /**
     * XML 字符串转 Map
     * @param xmlStr
     * @return
     */
    public static Map<String, String> xml2ToMap(String xmlStr) {

        Map<String, String> map = new HashMap<String, String>();
        if (isNullorEmpty(xmlStr)) {
            throw new IllegalArgumentException("xml is empty");
        } else {
            Document document = null;
            try {
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                try {
                    DocumentBuilder documentBuilder= documentBuilderFactory.newDocumentBuilder();
                    InputStream is = new ByteArrayInputStream(xmlStr.getBytes());
                    document  =documentBuilder.parse(is);
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


            Element element = document.getDocumentElement();
            if (element != null) {
                NodeList nodeList = element.getChildNodes();
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    String nodeName = node.getNodeName();
                    String nodeText = node.getTextContent();
                    if("#text".equals(nodeName)){
                        continue;
                    }
                    map.put(nodeName, nodeText);
                }
            }
        }
        return map;
    }


    public static boolean isNullorEmpty(String xmlStr) {
        if (null == xmlStr || "".equals(xmlStr)) {
            return true;
        } else {
            return false;
        }
    }

    public static String createSign(SortedMap<String, Object> map, String key) {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Object> m : map.entrySet()) {
            if ("".equals(m.getValue()) || null == m.getValue()) {
                continue;
            }
            sb.append(m.getKey()).append("=").append(m.getValue()).append("&");
        }
        sb.append("key=" + key);
        return MD5Util.MD5(sb.toString()).toUpperCase();
    }
}
