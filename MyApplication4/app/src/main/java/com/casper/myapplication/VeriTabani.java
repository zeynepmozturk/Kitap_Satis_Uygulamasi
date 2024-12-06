package com.casper.myapplication;

public class VeriTabani {

    public static final String VT_Adi="Kayıtlar";

    public static final int VT_Versiyonu=1;

    public static final String Tablo_Adi="Kayıtlarım_Tablo";



    public static final String Sabit_Ad="Ad";
    public static final String Sabit_Soyad="Soyad";
    public static final String Sabit_Tel="Telefon";
    public static final String Sabit_Email="Email";
    public static final String Sabit_Cinsiyet="Cinsiyet";
    public static final String Sabit_Parola="Parola";
    public static final String Sabit_ID="ID";




    public static final String Tablo_Olustur= " CREATE TABLE "+Tablo_Adi+"("

            +Sabit_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +Sabit_Ad+" TEXT,"
            +Sabit_Soyad+" TEXT,"
            +Sabit_Tel+" TEXT,"
            +Sabit_Email+" TEXT,"
            +Sabit_Cinsiyet+" TEXT,"
            +Sabit_Parola+" TEXT,"
            + ")";


}
