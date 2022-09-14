package com.foch.springserver.model.manager;

import java.sql.Timestamp;

public class Manager {

    public int accPoint;
    public int sequence_num;
    public Timestamp updated_time;

    public void setUpdated_time(Timestamp updated_time){this.updated_time = updated_time;}
    public Timestamp getUpdated_time(){return updated_time;}
    public void setSequence_num(int sequence_num){this.sequence_num = sequence_num;}
    public int getSequence_num(){return sequence_num;}

    public void setAccPoint(int accPoint){this.accPoint = accPoint;}
    public int getAccPoint(){return accPoint;}
}
