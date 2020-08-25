package com.guozy.design.principle.srp.method;

public class Method {

    private void modifyUserInfo(String userName,String address){
        userName = "guozy";
        address = "北京";
    }

    private void modifyUserInfo(String userName,String... filed){
    }


    private void modifyUserInfo(String userName,String address, boolean bool){

    }

    private void modifyUserName(String userName){

    }
    private void modifyAddress(String address){

    }
}
