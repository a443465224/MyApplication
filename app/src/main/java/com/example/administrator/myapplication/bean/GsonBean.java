package com.example.administrator.myapplication.bean;

import com.google.gson.JsonElement;

import java.util.List;

/**
 * Created by XDH.
 */
public class GsonBean {


    /**
     * code : 0
     * data : [["LJSXSDMTEST100004",["114.0506252646446228","22.57091249715686132"]],["LJSXSDMTEST100003",["114.07306462526321411","22.6164969224864123"]],["LJSXSDMTEST100006",["113.92877787351608276","22.54979826989956848"]],["LJSXSDMTEST100013",["113.9291265606880188","22.5608952791351598"]],["LJSXSDMTEST100012",["113.92915338277816772","22.56197253562787353"]],["LJSXSDMTEST110001",["113.92533391714096069","22.54246025214327886"]],["LJSXSDMTEST100008",["113.94357830286026001","22.67572828653784711"]],["LJSXSDMTEST100002",["113.92705053091049194","22.66492783967790814"]],["XSSCT4TEST8052103",["113.86831015348434448","22.58540096330364833"]],["LJSXSDMTEST000000",["113.86819213628768921","22.58550995631349423"]],["XSSCT4TEST8051501",["113.86415809392929077","22.5846760330520695"]],["LJSXSDMTEST100001",["113.83711069822311401","22.60572942700154186"]],["LJSXSDMTEST100010",["114.02734369039535522","22.75787859931202206"]],["XSSCT4TEST8032801",["113.81420999765396118","22.61071775824311914"]],["LJSXSDMTEST100011",["113.81598562002182007","22.65347850420116771"]],["LJSXSDMTEST100014",["113.80872219800949097","22.6636021805115675"]],["LJSXSDMTEST100009",["113.80548745393753052","22.66673002642219359"]],["LJSXSDMTEST100007",["113.8895532488822937","22.80321715668912219"]],["LJSXSDMTEST100005",["113.88953715562820435","22.80324757334303598"]],["XSSCT4TEST8042001",["113.42620164155960083","23.74400933163168048"]]]
     */

    private int code;
    private List<List<JsonElement>> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<List<JsonElement>> getData() {
        return data;
    }

    public void setData(List<List<JsonElement>> data) {
        this.data = data;
    }
}