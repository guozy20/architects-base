package com.gupaoedu.design.principle.SRP.method;

/**
 * @ProjectName gupao-design
 * @Classname Method
 * @Description TODO
 * @Date 2021/1/5 13:52
 * @Created by guoziyang
 */
public class Method {
    private void modifyUserInfo(String userName,String address){
        userName = "Tom";
        address = "Changsha";
    }

    private void modifyUserInfo(String userName,String ... fileds){

    }

    private void modifyUserInfo(String userName,String address,boolean bool){
        if(bool){

        }else{

        }
    }

    private void modifyUserName(String userName){
        userName = "Tom";
    }

    private void modifyAddress(String address){
        address = "changsha";
    }
}
