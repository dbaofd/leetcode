import java.util.HashMap;
import java.util.Map;

/**
 * Created by dbaofd on 2020/9/15.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        String numStr=String.valueOf(num);
        int digit=1;
        String romans="";
        Map<Integer,String> romeMap = new HashMap<>();
        romeMap.put(1,"I");
        romeMap.put(5,"V");
        romeMap.put(10,"X");
        romeMap.put(50,"L");
        romeMap.put(100,"C");
        romeMap.put(500,"D");
        romeMap.put(1000,"M");
        romeMap.put(4,"IV");
        romeMap.put(9,"IX");
        romeMap.put(40,"XL");
        romeMap.put(90,"XC");
        romeMap.put(400, "CD");
        romeMap.put(900, "CM");
        for (int i=numStr.length()-1;i>=0;i--){
            int digitNum=Integer.parseInt(Character.toString(numStr.charAt(i)));
            if(digit==1){
                if(digitNum==4||digitNum==9){
                    romans=romeMap.get(digitNum);
                }else if(digitNum<4){
                    for(int j=0;j<digitNum;j++){
                        romans+=romeMap.get(1);
                    }
                }else if(digitNum>=5){
                    romans+=romeMap.get(5);
                    for(int j=0;j<digitNum-5;j++){
                        romans+=romeMap.get(1);
                    }
                }
            }else if(digit==10){
                digitNum*=digit;
                if(digitNum==40||digitNum==90){
                    romans=romeMap.get(digitNum)+romans;
                }else if(digitNum<40){
                    for(int j=0;j<digitNum/10;j++){
                        romans=romeMap.get(10)+romans;
                    }
                }else if(digitNum>=50){
                    String t="";
                    t=romeMap.get(50);
                    for (int j=0;j<(digitNum-50)/10;j++){
                        t+=romeMap.get(10);
                    }
                    romans=t+romans;
                }
            }else if(digit==100){
                digitNum*=digit;
                if(digitNum==400||digitNum==900){
                    romans=romeMap.get(digitNum)+romans;
                }else if(digitNum<400){
                    for(int j=0;j<digitNum/100;j++){
                        romans=romeMap.get(100)+romans;
                    }
                }else if(digitNum>=500){
                    String t="";
                    t=romeMap.get(500);
                    for (int j=0;j<(digitNum-500)/100;j++){
                        t+=romeMap.get(100);
                    }
                    romans=t+romans;
                }
            }else if(digit==1000){
                for(int j=0;j<digitNum;j++){
                    romans=romeMap.get(1000)+romans;
                }
            }
            digit*=10;
        }
        return romans;
    }
}
