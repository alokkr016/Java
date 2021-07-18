package recurssion;

public class PrintSubSequence {
    public static void subSequence(String str) {
        subSequence(str,"");
    }
    public static void subSequence(String str,String stringSoFar){
        if(str == ""){
            System.out.println(stringSoFar);
            return;
        }
        subSequence(str.substring(1),stringSoFar);

        subSequence(str.substring(1),stringSoFar + str.charAt(0));

    }

    public static void main(String[] args) {
        String str = "xyz";
        subSequence(str);
    }

}
