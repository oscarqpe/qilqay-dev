package com.os.foro.entity;

/**
 * 
 * @author OscarEdmit
 *
 */
public enum GroupUserType {
     ADMINISTRATOR 
    ,USER;

   public static GroupUserType getGroupUserType(String groupUserType){
       if(groupUserType.equals(ADMINISTRATOR.name())) return ADMINISTRATOR;
       return USER;
   }
}
