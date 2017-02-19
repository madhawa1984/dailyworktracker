package com.oriansolution.dwt.utility.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * Created by madhawa on 12/22/16.
 */
public class EnumContainer {

    public enum Priority implements Serializable {
        IMEDIATE("Imediate",1,"Imediate"),IMPORTANT("Important",2,"Important");
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

        CEO("Chief Executive Officer",1,"Chief Executive Officer"), CFO("Chief financial Officer",2,"Chief financial Officer"),GENERALMANAGERMANAGER("Manager",3,"Manager"),
        REGIONALMANAGER("Regional Manager",4,"Regional Manager"),BRANHCMANAGER("Branch Manager",5,"Branch Manager"),
        BRANCHOFFICER("Branch Officer",6,"Branch Officer"),OPERATOR("Operator",7,"Operator");

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

        DETAILED("Detailed",1,"Detailed"),SUMMARY("Summary",2,"Summary") ;

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

        EXCELSHEET("Excel Sheet",1,"Excel Sheet"),CSV("CSV",2,"CSV"),PDF("PDF",3,"PDF") ;

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

        DAILY("Daily",1,"Daily"),ADHOC("Adhoc",2,"Adhoc"),WEEKLY("Weekly",3,"Weekly"),MONTHLY("Monthly",3,"Monthly"),QUARTERLY("Quarterly",4,"Quarterly"),YEARLY("Yearly",5,"Yearly") ;

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

    public enum Status implements Serializable {

        CREATED("Created",1,"Created"),PENDINGAPPROVAL("Pending Approval",2,"Pending Approval"),APPROVED("Approved",3,"Approved"),
        REJECTED("Rejected",4,"Rejected"),ASSIGNED("Assigned",5,"Assigned"), WORKINPROGRESS("Work inprogress",6,"Work inprogress"),
        PENDINGINFO("Pending Info",7,"Pending Info"),COMPLETED("Completed",8,"Completed");

        Status (String name,int value,String text) {
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
