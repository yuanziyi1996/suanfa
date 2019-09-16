import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class getStatus {

  public static final String VOICE_MESSAGE_INTERCEPTED_STRING = "voice-message-intercepted";
  public static final String VOICE_MAIL_INTERCEPTED_STRING = "voice-mail-intercepted";
  public static final String VOICE_MAIL_RECORDING_STRING = "voice-mail-recording";
  private static final int INITIATED = 1;// 1
  private static final int QUEUED = 1 << 1;// 2
  private static final int RINGING = 1 << 2;// 4
  private static final int IN_PROGRESS = 1 << 3;// 8
  private static final int ANSWERED = 1 << 4;// 16
  private static final int COMPLETED = 1 << 5;// 32
  private static final int BUSY = 1 << 6;// 64
  private static final int FAILED = 1 << 7;// 128
  private static final int NO_ANSWER = 1 << 8;// 256
  private static final int CANCELED = 1 << 9;// 512
  private static final int VOICE_MESSAGE_INTERCEPTED = 1 << 10;// 1024
  private static final int VOICE_MAIL_RECORDING = 1 << 11;// 2048
  private static final int VOICE_MAIL_INTERCEPTED = 1 << 12; // 4096
  private static final Map<String, Integer> STATUS_INT_VALUE_MAP = new HashMap<String, Integer>();

  private static final Map<Integer, String> INT_TO_STATUS_VALUE = new HashMap<Integer, String>();
  //int 对状态status

  private static final Map<Integer, List<String>> STRINGLIST_VALUE_TO_INT_MAP =
    new ConcurrentHashMap<>();
  static {
    STATUS_INT_VALUE_MAP.put("INITIATED", INITIATED);
    STATUS_INT_VALUE_MAP.put("QUEUED", QUEUED);
    STATUS_INT_VALUE_MAP.put("RINGING", RINGING);
    STATUS_INT_VALUE_MAP.put("IN_PROGRESS", IN_PROGRESS);
    STATUS_INT_VALUE_MAP.put("ANSWERED", ANSWERED);
    STATUS_INT_VALUE_MAP.put("COMPLETED", COMPLETED);
    STATUS_INT_VALUE_MAP.put("BUSY", BUSY);
    STATUS_INT_VALUE_MAP.put("FAILED", FAILED);
    STATUS_INT_VALUE_MAP.put("NO_ANSWER", NO_ANSWER);
    STATUS_INT_VALUE_MAP.put("CANCELED", CANCELED);
    STATUS_INT_VALUE_MAP.put(VOICE_MESSAGE_INTERCEPTED_STRING, VOICE_MESSAGE_INTERCEPTED);
    STATUS_INT_VALUE_MAP.put(VOICE_MAIL_RECORDING_STRING, VOICE_MAIL_RECORDING);
    STATUS_INT_VALUE_MAP.put(VOICE_MAIL_INTERCEPTED_STRING, VOICE_MAIL_INTERCEPTED);

    INT_TO_STATUS_VALUE.put(INITIATED, "INITIATED");
    INT_TO_STATUS_VALUE.put(QUEUED, "QUEUED");
    INT_TO_STATUS_VALUE.put(RINGING, "RINGING");
    INT_TO_STATUS_VALUE.put(IN_PROGRESS,"IN_PROGRESS");
    INT_TO_STATUS_VALUE.put(ANSWERED, "ANSWERED");
    INT_TO_STATUS_VALUE.put(COMPLETED, "COMPLETED");
    INT_TO_STATUS_VALUE.put(BUSY, "BUSY");
    INT_TO_STATUS_VALUE.put(FAILED,"FAILED");
    INT_TO_STATUS_VALUE.put(NO_ANSWER, "NO_ANSWER");
    INT_TO_STATUS_VALUE.put(CANCELED, "CANCELED");
    INT_TO_STATUS_VALUE.put(VOICE_MESSAGE_INTERCEPTED, VOICE_MESSAGE_INTERCEPTED_STRING);
    INT_TO_STATUS_VALUE.put(VOICE_MAIL_RECORDING, VOICE_MAIL_RECORDING_STRING);
    INT_TO_STATUS_VALUE.put(VOICE_MAIL_INTERCEPTED, VOICE_MAIL_INTERCEPTED_STRING);


    //初始化key为0的value为null
    STRINGLIST_VALUE_TO_INT_MAP.put(0, Arrays.asList(""));
  }


  /**
   * 传入status的数字相加的和返回所有对应的string类型的状态
   */
  public static List<String> listStatusBySumStatus(int sumStatus) {
    List<String> statusStringList = STRINGLIST_VALUE_TO_INT_MAP.get(sumStatus);
    if (!CollectionUtils.isEmpty(statusStringList)) {
      return statusStringList;
    }
    statusStringList = new ArrayList<>();
    List<Integer> statusIntegerList = new ArrayList<>();//保存包含的状态对应int
    for (Map.Entry<Integer, String> stringIntegerEntry : INT_TO_STATUS_VALUE.entrySet()) {
      if ((stringIntegerEntry.getKey() & sumStatus) != 0) {//用于判断sumStatus 不为0？
        System.out.println(stringIntegerEntry.getKey());
        statusIntegerList.add(stringIntegerEntry.getKey());
      }
    }
    System.out.println(statusIntegerList);
    statusIntegerList.sort((status1, status2) -> {
      if (status1 > status2) {
        return 1;
      } else if (status1 < status2) {
        return -1;
      } else {
        return 0;
      }
    });
    for (Integer statusinteger : statusIntegerList) {
      System.out.println("statusinteger:  "+statusinteger);
      statusStringList.add(INT_TO_STATUS_VALUE.get(statusinteger));
    }
    System.out.println(("this get status list sumStatus={},STRING_VALUE_TO_INT_MAP={},statusStringList={}"+
      sumStatus+"=="+ STRINGLIST_VALUE_TO_INT_MAP+"=="+ statusStringList));
    STRINGLIST_VALUE_TO_INT_MAP.put(sumStatus, statusStringList);

    return statusStringList;
  }

  public static void main(String[] args) {
    listStatusBySumStatus(2092);
  }
}
