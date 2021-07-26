package temp;

public class ReturnKeypad {
        public static String[] keypads(int n) {
            if (n == 0) {
                String[] temp = {""};
                return temp;
            }
            String keys[] = helper(n % 10);
            String result[] = keypads(n / 10);
            String finalString[] = new String[keys.length * result.length];
            int k = 0;
            for (int i = 0; i < keys.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    finalString[k] = result[j] + keys[i];
                    k++;
                }
            }


            return finalString;


        }


            public static String[] helper(int n){
                String two[] = {"a","b","c"};
                String three[] = {"d","e","f"};
                String four[] = {"g","h","i"};
                String five[] = {"j","k","l"};
                String six[] = {"m","n","o"};
                String seven[] = {"p","q","r","s"};
                String eight[] = {"t","u","v"};
                String nine[] = {"w","x","y","z"};
                if(n== 2){
                    return two;
                }
                else if(n == 3){
                    return three;
                }
                else if(n == 4){
                    return four;
                }
                else if(n == 5){
                    return five;
                }
                else if(n == 6){
                    return six;
                }
                else if(n == 7){
                    return seven;
                }
                else if(n == 8){
                    return eight;
                }
                else if(n == 9){
                    return nine;
                }
                else {
                    String str[] = {""};
                    return str;
                }
            }

        public static void main(String[] args){
            String str[] =  ReturnKeypad.keypads(23);
            for (int i = 0; i < str.length; i++){
                System.out.println(str[i]);
            }
        }

    }
