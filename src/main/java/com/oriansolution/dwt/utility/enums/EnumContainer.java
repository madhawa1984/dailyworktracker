package com.oriansolution.dwt.utility.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * Created by madhawa on 12/22/16.
 */
public class EnumContainer {

    public enum Priority implements Serializable {
        IMEDIATE("IMEDIATE",1,"Imediate"),URGENT("URGENT",2,"Urgent"),IMPORTANT("IMPORTANT",3,"Important");
        Priority (String name,int value,String text) {
            this.name = name;
            this.value = value;
            this.text = text;
        }

        public String getName() { return name; }
        public int getValue() { return value; }
        public String getText() { return text; }

        public static Priority getTextByIntValue(String value) {
            Priority returnPriority = IMPORTANT;
            switch(value) {
                case "1":
                    returnPriority = IMEDIATE;
                    break;
                case "2":
                    returnPriority = URGENT;
                    break;
                case "3":
                    returnPriority = IMPORTANT;
                    break;
                default:
                    returnPriority = IMPORTANT;
                    break;

            }
            return returnPriority;
        }

        private final String name;
        private final int value;
        private final String text;
    }

    public enum Designations implements Serializable {

        CEO("CEO",1,"Chief Executive Officer"), CFO("CFO",2,"Chief financial Officer"),GENERALMANAGERMANAGER("MANAGER",3,"Manager"),
        REGIONALMANAGER("REGIONALMANAGER",4,"Regional Manager"),BRANHCMANAGER("BRANCHMANAGER",5,"Branch Manager"),
        BRANCHOFFICER("BRANCHOFFICER",6,"Branch Officer"),OPERATOR("OPERATOR",7,"Operator");

        Designations (String name,int value,String text) {
            this.name = name;
            this.value = value;
            this.text = text;
        }

        public String getName() { return name; }
        public int getValue() { return value; }
        public String getText() { return text; }

        private final String name;
        private final int value;
        private final String text;
    }

    public enum RequestTypes implements Serializable {

        DETAILED("DETAILED",1,"Detailed"),SUMMARY("SUMMARY",2,"Summary") ;

        RequestTypes (String name,int value,String text) {
            this.name = name;
            this.value = value;
            this.text = text;
        }

        public String getName() { return name; }
        public int getValue() { return value; }
        public String getText() { return text; }

        private final String name;
        private final int value;
        private final String text;
    }

    public enum DelieveryFormat implements Serializable {

        EXCELSHEET("EXCELSHEET",1,"Excel Sheet"),CSV("CSV",2,"Csv"),PDF("PDF",3,"PDF") ;

        DelieveryFormat (String name,int value,String text) {
            this.name = name;
            this.value = value;
            this.text = text;
        }

        public String getName() { return name; }
        public int getValue() { return value; }
        public String getText() { return text; }

        private final String name;
        private final int value;
        private final String text;
    }

    public enum Frequency implements Serializable {

        DAILY("DAILY",1,"Daily"),ADHOC("ADHOC",2,"ADHOC"),WEEKLY("WEEKLY",3,"Weekly"),MONTHLY("MONTHLY",3,"Monthly"),YEARLY("YEARLY",4,"Yearly") ;

        Frequency (String name,int value,String text) {
            this.name = name;
            this.value = value;
            this.text = text;
        }

        public String getName() { return name; }
        public int getValue() { return value; }
        public String getText() { return text; }

        private final String name;
        private final int value;
        private final String text;
    }

    public enum DelieveryMode implements Serializable {

        EMAIL("EMAIL",1,"EMAIL"),FAX("FAX",2,"FAX");

        DelieveryMode (String name,int value,String text) {
            this.name = name;
            this.value = value;
            this.text = text;
        }

        public String getName() { return name; }
        public int getValue() { return value; }
        public String getText() { return text; }

        private final String name;
        private final int value;
        private final String text;
    }

}
