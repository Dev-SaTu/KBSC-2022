package com.foch.springserver.model.donate;

import java.sql.Timestamp;

public class Donate {

    public int donatePoint;

    public int waitingNumber;

    public Timestamp time;

    public void setDonatePoint(int donatePoint){this.donatePoint = donatePoint;}

    public int getDonatePoint(){return donatePoint;}

    public void setWaitingNumber(int waitingNumber){this.waitingNumber = waitingNumber;}

    public int getWaitingNumber(){return waitingNumber;}

}
