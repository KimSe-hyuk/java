package com.himeda.practice;

public interface N_Vending {
    boolean setTotalMoney(int totalMoney);
    int getTotalMoney();
    void printMenu();
    int getChoice();
    void getMoney();
    int calcMoney(int totalMoney);
    void printException();
}
