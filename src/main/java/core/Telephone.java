package core;

import java.util.List;
import java.util.regex.Pattern;

public class Telephone {
    private String number;
    private String areaCode;
    private String exchangeCode;
    private String subscriberNumber;

    public Telephone(String number) {
        this.number = number;
    }

    public String getNumber() {
        if(number.equals("") || number.equals(null)){
            return("invalid");
        }
        String returnNumber = "";
        String start = "" + number.charAt(0) + number.charAt(1);

        if(start.equals("+1")){
            returnNumber += start;
            int i = 2;
            boolean flag = true;
            while(flag){
                int value = number.charAt(i);
                if(value >= 48 && value <= 57 ){
                    returnNumber += number.charAt(i);
                }
                if(number.length() -1 == i){
                    flag = false;
                }
                else {
                    i++;
                }
            }
            if(returnNumber.length() == 12){
                return returnNumber;
            }
        }
        return checkNumberAgainstCode();
    }

    public String getNumber1() {
        StringBuilder returnNumber = new StringBuilder();
        String start = "" + number.charAt(0) + number.charAt(1);
        if(start.equals("+1")){
            returnNumber.append(start);
            int i = 2;
            boolean flag = true;
            while(flag){
                int value = number.charAt(i);
                if(value >= 48 && value <= 57 ){
                    returnNumber.append(number.charAt(i));
                }
                if(number.length() -1 == i){
                    flag = false;
                }
                else {
                    i++;
                }
            }
            if(returnNumber.length() == 12){
                return returnNumber.toString();
            }
        }
        return checkNumberAgainstCode();
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }

    public String getSubscriberNumber() {
        return subscriberNumber;
    }

    public void setSubscriberNumber(String subscriberNumber) {
        this.subscriberNumber = subscriberNumber;
    }

    private String checkNumberAgainstCode(){
        String[] list = number.split("-");
        if(list.length != 3){
            return "invalid";
        }
        areaCode = list[0];
        exchangeCode = list[1];
        subscriberNumber = list[2];

        boolean pass = true;
        if(areaCode.equals("NPA")){
            System.out.println(1);
            if(Pattern.matches("N\\w\\w", exchangeCode)){
                if(Pattern.matches("\\d\\d\\d\\d", subscriberNumber)){
                    return areaCode + " " + exchangeCode + " " + subscriberNumber;
                }
                else{
                    return "invalid";
                }
            }
            else{
                return "invalid";
            }
        }
        else{
            return "invalid";
        }
    }
}
