package com.foch.springserver.model.donate;

import java.sql.Timestamp;

public class Donate {

    public int accPoint;

    public int waitingNumber;

    public Timestamp time;

    public void setDonatePoint(int accPoint){this.accPoint = accPoint;}

    public int getDonatePoint(){return accPoint;}

    public void setWaitingNumber(int waitingNumber){this.waitingNumber = waitingNumber;}

    public int getWaitingNumber(){return waitingNumber;}

}
