package Json;

import collection.CollectionUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.google.common.base.Throwables;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.*;

/**
 * copy com.dialer.server.util.JacksonUtils
 */
public class JacksonUtil {

  private final static ObjectMapper objMapper = new ObjectMapper();

  static {
  }

  public static Object json2Object(String json, Class cls) throws IOException {
    ObjectMapper om = new ObjectMapper();
    Object obj = om.readValue(json, cls);
    return obj;
  }

  /**
   * 调用get方法生成json字符串 <br>
   * 2015年1月27日:下午12:26:55<br>
   * <br>
   */
  public static String toJson(Object obj) {
    try {
      return objMapper.writeValueAsString(obj);
    } catch (Exception e) {
      throw Throwables.propagate(e);
    }
  }

  /**
   * 转换成jsonnode
   */
  public static JsonNode toJsonNode(String jsonText) {
    JsonNode jsonNode = null;
    try {
      jsonNode = objMapper.readTree(jsonText);
    } catch (Exception e) {
      throw Throwables.propagate(e);
    }
    return jsonNode;
  }

  public static Map<String, Object> toMap(Object obj) {
    try {
      if (null == obj) {
        return new HashMap<String, Object>();
      }
      String jsonStr = objMapper.writeValueAsString(obj);
      Map<String, Object> map = objMapper.readValue(jsonStr, Map.class);
      return map;
    } catch (Exception e) {
      throw Throwables.propagate(e);
    }
  }

  public static String getNodeText(JsonNode node, String path) {
    return node.has(path) ? node.get(path).asText().trim() : StringUtils.EMPTY;
  }

  public static List<String> getJsonStrListFromJson(String json) throws IOException {
    JsonNode arrayNode = objMapper.readTree(json);
    if (arrayNode.isArray()) {
      List<String> resultList = new ArrayList<>();
      for (JsonNode jsonNode : arrayNode) {
        resultList.add(jsonNode.toString());
      }
      return resultList;
    } else {
      return Collections.emptyList();
    }
  }

  /**
   * 对obj对象进行序列话，序列化是依据jsonViewClazz的配置
   */
  public static <T> String toJson(Object obj, Class<T> jsonViewClazz) {
    try {
      return objMapper.writerWithView(jsonViewClazz).writeValueAsString(
        obj);
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * 利用Jackson序列化时，指定clazz类型及其需要包含的输出属性
   *
   * @param obj           需要序列化的对象
   * @param clazz         指定的类型
   * @param includeFileds 指定的需要输出的属性
   */
  @SuppressWarnings("rawtypes")
  public static String toJsonWithInclude(Object obj, Class clazz,
                                         String... includeFileds) {
    Map<Class, Set<String>> include = new HashMap<>();
    include.put(clazz, new HashSet<>(Arrays.asList(includeFileds)));
    return toJson(obj, include, null);
  }


  /**
   * 利用Jackson序列化时，指定多个类型及其需要输出的属性
   *
   * @param obj     需要序列化的对象
   * @param include 每种类型对应的需要输出的属性
   */
  @SuppressWarnings("rawtypes")
  public static String toJsonWithInclude(Object obj,
                                         Map<Class, Set<String>> include) {
    return toJson(obj, include, null);
  }


  public static void main(String[] args) {
    Map<String, Object> dataMap = new HashMap<String, Object>();
    Map<Class, Set<String>> include = new HashMap<Class, Set<String>>();
    String json = "{\n" +
      "    \"RECORDS\": [\n" +
      "        {\n" +
      "            \"contact_id\": \"0\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26487\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3769\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2822\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"55849\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"55848\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46560\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20886\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"25729\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"94439670095548416\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"94439803575078912\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2784\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"54914\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46732\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"15101\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2472\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"320\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2823\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2251\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2821\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"108674\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103085\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"15260\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"25555\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26330\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"25549\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"10752\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2479\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26460\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2367\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"25714\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"55847\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2819\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2480\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46531\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"547\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2820\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20816\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3600\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103071\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"839\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26350\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103098\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"25319\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103091\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3602\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2384\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"21015\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"104171\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46729\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26038\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20810\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"119212\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"21012\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"21180\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"21014\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"21013\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"42270885310107648\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3551\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"100918\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26485\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20889\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3073\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"10751\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"150769\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103257\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"100897\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"108773\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"510\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2789\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"10708\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2478\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26486\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"104239\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"563\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2366\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3257\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"94439358873997312\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26247\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26105\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2728\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"21107\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2507\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"104219\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103315\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"15076\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2764\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"421\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103212\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"278\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"15080\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3956\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"14999\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103073\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"485\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2477\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"773\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"104224\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"25573\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"21178\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"10748\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26258\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103156\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"108652\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20888\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"10688\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46728\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"10756\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"100893\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"150713\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"267\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3760\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"101032\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103261\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2476\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2641\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103894\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26403\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2444\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103996\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"515\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"14998\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"872\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103203\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103194\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103893\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"538\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2475\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"55846\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103189\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2282\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"446449\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26445\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"514\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"153491\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"21176\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26404\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"78953987927183360\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"101111\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103208\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"21179\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103316\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46726\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"546\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2632\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"14917\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"1972\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46747\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2294\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"21031\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103186\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"106597\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"108995\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2469\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"104240\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"152746\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"5989\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"15078\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"123\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3724\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"21030\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103054\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3155\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"21029\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"55850\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26488\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103916\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"14926\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2620\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"99\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"152747\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103155\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103070\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"544\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"21032\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2765\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"536\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"25836\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"108997\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"504\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"15259\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2408\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2470\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20815\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"104241\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"511\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20830\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3153\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"519\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"531\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2916\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3152\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"446453\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"500\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"11283\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3959\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"509\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"21055\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"10689\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"517\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"196621736236589056\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"152210\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103100\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103206\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2471\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103917\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"119213\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"534\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"755\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3019\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"10760\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46721\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3154\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"15257\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2247\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2619\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"100894\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"150719\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2455\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3614\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46695\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"25681\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"104019\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"10746\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103066\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46550\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"530\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"15255\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3151\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"14776\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46746\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"11282\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2897\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"505\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"589\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103074\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"535\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26489\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"525\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3953\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"10749\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"503\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2253\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2624\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"21041\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103205\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103047\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"108862\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"104205\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"502\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"15072\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"727\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20899\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"545\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46748\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"15256\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"21033\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"518\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103259\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2898\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103209\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26397\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2725\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103258\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"497\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"134979873176293376\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"1913\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20887\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"79527425683230720\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26244\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"12\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"100976\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"42270950762221568\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3641\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"25781\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103222\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"15258\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"42270885310107650\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2074\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20911\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"482\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20833\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"521\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"393\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"21040\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103211\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46739\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"501\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2064\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2534\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"717\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26313\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103133\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3761\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"14850\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20862\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103191\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"152745\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"83482\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103113\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103064\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"15070\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103317\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46792\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"25602\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26494\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3149\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"10811\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"281\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103918\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20856\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"786\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"526\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"10750\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2067\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73161\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2256\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2434\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2763\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3601\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46646\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46773\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73124\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20818\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"772\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"21052\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"10770\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73087\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2075\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73179\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20955\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"818\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2382\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26336\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103099\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"10709\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"129\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"188\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73141\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20839\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"785\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2420\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2695\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46518\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46744\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"15122\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73104\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2081\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73196\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"876\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2394\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103184\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2066\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73159\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"794\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2432\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2755\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103072\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46566\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46751\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73121\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2406\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"105\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"15074\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73084\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73176\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"810\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3638\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"128\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73139\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"783\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2418\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2687\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46366\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46743\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73101\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2080\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73193\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2392\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2065\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73156\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20874\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"791\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2430\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2735\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3567\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46561\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46750\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"533\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73118\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73211\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2404\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2950\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2073\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73173\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"808\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3617\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103898\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46720\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46801\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"127\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73136\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"778\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"21159\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2416\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2680\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103046\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"45831\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"10703\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"150827\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73098\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2079\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73190\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"865\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2390\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"10747\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73153\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20873\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2428\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2733\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103260\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"119201\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73116\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20814\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73208\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2402\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"10753\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2071\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73170\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20890\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"806\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"23377\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2776\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46799\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"125\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73133\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20829\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"776\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2414\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2677\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103210\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"10698\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73096\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2078\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73187\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2388\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73150\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"789\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2132\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2426\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"33779\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73113\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20813\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73205\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2400\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2070\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73167\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"803\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103081\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3613\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46688\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46795\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"124\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73130\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20828\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"774\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2412\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"25621\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"101108\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"446452\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73093\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2077\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73185\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2386\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"10745\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"499\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73147\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20858\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"787\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2424\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"527\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73110\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20812\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73202\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2398\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"26481\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"3957\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"104233\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2068\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73164\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"799\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2436\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46662\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73127\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2082\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"21054\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2410\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"516\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73090\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2076\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73182\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"20993\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"820\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"10742\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73144\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2422\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"27032\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"103062\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46521\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"46745\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"152208\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73107\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"73199\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"883\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2396\"\n" +
      "        },\n" +
      "        {\n" +
      "            \"contact_id\": \"2873\"\n" +
      "        }\n" +
      "    ]\n" +
      "}";
//    CallSearchSummaryDto callSearchSummaryDto = CallSearchSummaryDto.builder().averageSeconds(2)
//      .inboundCount(3)
//      .outboundCount(4).totalCount(1).totalSeconds(2).recordVoiceMessageCount(5).build();
//    CallSearchSingleDto callSearchSingleDto = CallSearchSingleDto.builder().userId(3211).uuid
//      ("567").teamId(345)
//      .build();
//    List<CallSearchSingleDto> callSearchSingleDtoList = new ArrayList();
//    callSearchSingleDtoList.add(callSearchSingleDto);
//    callSearchSingleDto.setUserId(567);
//    callSearchSingleDtoList.add(callSearchSingleDto);
//    callSearchSummaryDto.setCalls(callSearchSingleDtoList);
//    dataMap.put(BellBaseConstant.KEY_4_ERROR_CODE_IN_CONTROLLER_RESULT, 200);
//    dataMap.put(BellBaseConstant.KEY_4_STRING_IN_CONTROLLER_RESULT, callSearchSummaryDto);
//    Set<String> stringSet = new HashSet();
//    stringSet.add("startTime");
//    stringSet.add("uuid");
//    include.put(CallSearchSingleDto.class, stringSet);
//    json = toJson(dataMap, include, null);
//    System.out.print(json);
    List<JsonNode> nodes = findJsonNodesByKey(json,"contact_id");
    List<Long> referenceIds = new ArrayList<>();
    for (JsonNode node:nodes) {
      referenceIds.add(Long.parseLong(node.asText()));
    }
    System.out.println(referenceIds);
  }

  /**
   * 利用Jackson序列化时，指定clazz代表的类型需要过滤掉得属性
   *
   * @param obj           需要序列化的对象
   * @param clazz         指定的类型
   * @param excludeFields 需要排除掉得字段
   */
  @SuppressWarnings("rawtypes")
  public static String toJsonWithExclude(Object obj, Class clazz,
                                         String... excludeFields) {
    Map<Class, Set<String>> exclude = new HashMap<Class, Set<String>>();
    exclude.put(clazz, new HashSet<String>(Arrays.asList(excludeFields)));
    return toJson(obj, null, exclude);
  }

  /**
   * 利用Jackson序列化时，指定clazz代表的类型需要过滤掉得属性
   *
   * @param obj           需要序列化的对象
   * @param clazz         指定的类型
   * @param excludeFields 需要排除掉得字段,传入Set<String>
   */
  @SuppressWarnings("rawtypes")
  public static String toJsonWithExcludeSet(Object obj, Class clazz,
                                            Set<String> excludeFields) {
    Map<Class, Set<String>> exclude = new HashMap<Class, Set<String>>();
    exclude.put(clazz, excludeFields);
    return toJson(obj, null, exclude);
  }


  /**
   * 利用Jackson序列化时，指定需要多个类型及其需要过滤掉得属性
   *
   * @param obj     序列化的对象
   * @param exclude 每种类型对应的需要排除的属性
   */
  @SuppressWarnings("rawtypes")
  public static String toJsonWithExclude(Object obj,
                                         Map<Class, Set<String>> exclude) {
    return toJson(obj, null, exclude);
  }

  /**
   * 利用Jackson序列化时，指定各种类型及其对应的过滤条件<br> <br> include exclude可以其中之一为空或者同时为空<br>
   * include为空只过滤exclude<br> exclude为空，只根据include的配置输出字段<br> 同时为空时不进行过滤
   *
   * @param obj     需要序列化的对象
   * @param include 指定class序列化时需要包含的属性
   * @param exclude 指定class序列化时需要排除的属性
   * @return 根据include exclude进行属性的过滤后的对象生成的json 串
   */
  @SuppressWarnings({"serial", "rawtypes"})
  public static String toJson(Object obj, Map<Class, Set<String>> include,
                              Map<Class, Set<String>> exclude) {

    if ((null == include || include.isEmpty())
      && (null == exclude || exclude.isEmpty())) {
      toJson(obj);
    }

    ObjectMapper mapper = new ObjectMapper();

    // 设置包含过滤器
    FilterProvider filters = new SimpleFilterProvider();
    if (null != include && !include.isEmpty()) {
      for (Map.Entry<Class, Set<String>> entry : include.entrySet()) {
        Class clazz = entry.getKey();
        Set<String> includeFileds = entry.getValue();
        ((SimpleFilterProvider) filters).addFilter(clazz.getName(),
          SimpleBeanPropertyFilter.filterOutAllExcept(includeFileds));
      }
    }

    // 设置排除过滤器
    if (null != exclude && !exclude.isEmpty()) {
      for (Map.Entry<Class, Set<String>> entry : exclude.entrySet()) {
        Class clazz = entry.getKey();
        Set<String> excludeFileds = entry.getValue();
        ((SimpleFilterProvider) filters).addFilter(clazz.getName(),
          SimpleBeanPropertyFilter.serializeAllExcept(excludeFileds));
      }
    }
//    mapper.setFilterProvider(filters);

    // 都是有哪些过滤器名
    final Set<String> filterNames = new HashSet<String>();
    if (null != include && !include.isEmpty()) {
      for (Class clazz : include.keySet()) {
        filterNames.add(clazz.getName());
      }
    }
    if (null != exclude && !exclude.isEmpty()) {
      for (Class clazz : exclude.keySet()) {
        filterNames.add(clazz.getName());
      }
    }

    mapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector() {
      public Object findFilterId(Annotated ac) {
        String name = ac.getName();
        if (filterNames.contains(name)) {
          return name;
        } else {
          return null;
        }
      }
    });

    try {
      return mapper.writeValueAsString(obj);
    } catch (Exception e) {
      return null;
    }
  }


  /**
   * 从json字符串中获取指定key的node
   */
  public static JsonNode findJsonNodeByKey(String jsonText, String key) {

    List<JsonNode> jsonNodes = findJsonNodesByKey(jsonText, key);
    return CollectionUtil.isNotEmpty(jsonNodes) ? jsonNodes.get(0) : null;
  }

  public static List<JsonNode> findJsonNodesByKey(String jsonText, String key) {

    JsonNode jsonNode = toJsonNode(jsonText);
    return Optional.ofNullable(jsonNode).map(o -> o.findValues(key))
      .orElseGet(() -> Collections.emptyList());
  }

  /**
   * 转换json为clazz. <br> <strong>依赖get和set方法</strong> <br> 2015年1月27日:下午12:26:18<br> <br>
   */
  public static <T> T fromJson(String jsonText, Class<T> clazz) throws
    Exception {
    if (jsonText == null || "".equals(jsonText)) {
      return null;
    }
    return objMapper.readValue(jsonText, clazz);
  }

  /**
   * 转换为集合类型的对象集合 <strong>依赖get和set方法</strong> <br> 2015年3月10日:上午11:19:14<br> <br>
   * <strong>example:</strong>
   *
   * <pre>
   * JacksonUtils.fromJson(jsonText, new TypeReference&lt;List&lt;FeedImage&gt;&gt;() {
   * });
   * </pre>
   *
   * @param valueTypeRef org.codehaus.jackson.type.TypeReference
   */
  public static <T> T fromJson(String jsonText, TypeReference<T> valueTypeRef)
    throws IOException {
    if (jsonText == null || "".equals(jsonText)) {
      return null;
    }
    return objMapper.readValue(jsonText, valueTypeRef);
  }

  public static <T> List<T> fromJson2List(String jsonText, Class<T> clazz)
    throws IOException {
    if (jsonText == null || "".equals(jsonText)) {
      return null;
    }
    List<T> objList = null;
    JavaType t = objMapper.getTypeFactory().constructParametricType(
      List.class, clazz);
    objList = objMapper.readValue(jsonText, t);
    return objList;
  }

  public static boolean isJson(String jsonText) {
    if (StringUtils.isEmpty(jsonText)) {
      return false;
    }
    try {
      objMapper.readTree(jsonText);
      return true;
    } catch (Exception e) {
      return false;
    }
  }


  private JacksonUtil() {
  }

}
