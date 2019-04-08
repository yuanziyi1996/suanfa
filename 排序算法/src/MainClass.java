//class Solution {
//  public boolean searchMatrix(int[][] matrix, int target) {
//    int temp1=-1;
//    for(int i=0;i<matrix.length;i++){
//      if(target>matrix[i][0]){
//        temp1=i;
//      }
//    }
//    int temp2=-1;
//    for(int j=0;j<matrix[0].length;j++){
//      if(target>matrix[0][j]){
//        temp2=j;
//      }
//    }
//
//    if(temp1==-1&&temp2==-1)
//      return false;
//    for(int k=0;k<temp1;k++){
//      if(matrix[temp2][k]==target){
//        return true;
//      }
//    }
//
//    for(int k=0;k<temp2;k++){
//      if(matrix[k][temp2]==target){
//        return true;
//      }
//    }
//    return false;
//  }
//}
//
//public class MainClass {
//  public static int[] stringToIntegerArray(String input) {
//    input = input.trim();
//    input = input.substring(1, input.length() - 1);
//    if (input.length() == 0) {
//      return new int[0];
//    }
//
//    String[] parts = input.split(",");
//    int[] output = new int[parts.length];
//    for(int index = 0; index < parts.length; index++) {
//      String part = parts[index].trim();
//      output[index] = Integer.parseInt(part);
//    }
//    return output;
//  }
//
//  public static int[][] stringToInt2dArray(String input) {
//    JsonArray jsonArray = JsonArray.readFrom(input);
//    if (jsonArray.size() == 0) {
//      return new int[0][0];
//    }
//
//    int[][] arr = new int[jsonArray.size()][];
//    for (int i = 0; i < arr.length; i++) {
//      JsonArray cols = jsonArray.get(i).asArray();
//      arr[i] = stringToIntegerArray(cols.toString());
//    }
//    return arr;
//  }
//
//  public static String booleanToString(boolean input) {
//    return input ? "True" : "False";
//  }
//
//  public static void main(String[] args) throws IOException {
//    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//    String line;
//    while ((line = in.readLine()) != null) {
//      int[][] matrix = stringToInt2dArray(line);
//      line = in.readLine();
//      int target = Integer.parseInt(line);
//
//      boolean ret = new Solution().searchMatrix(matrix, target);
//
//      String out = booleanToString(ret);
//
//      System.out.print(out);
//    }
//  }
//}