package com.goup.javateam.essential.practice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WhatEnumCanHelp {

  int add=1;
  int minus=2;
  int plus=3;
  int divide=4;
  int mod=5;

  public static int doAction(int op,int f1,int f2){
    int result = 0;
    if(op==1){
      result = f1+f2;
      //
    }else if(op==2){
      result = f1-f2;
    }else if(op==3){
      result = f1*f2;
    }else if(op==4){
      result = f1/f2;
    }
    return result;
  }


  public static void main(String[] args) {
    log.info("{}",doAction(1,1,5));
    log.info("{}",doAction(2,1,5));
    log.info("{}",doAction(3,1,5));
    log.info("{}\n\n\n",doAction(4,10,5));

    // ---  --- --- ---

    log.info("{}",doEnumAction(Op.ADD,1,5));
    log.info("{}",doEnumAction(Op.MINUS,1,5));
    log.info("{}",doEnumAction(Op.PLUS,1,5));
    log.info("{}",doEnumAction(Op.DIVIDE,10,5));
    log.info("{}",doEnumAction(Op.MOD,10,5));
  }

  public static int doEnumAction(Op op,int f1,int f2){
    return op.doAction(f1,f2);
  }

  enum Op{
    NONE {
      @Override
      int doAction(int f1, int f2) {
        return 0;
      }
    },ADD {
      @Override
      int doAction(int f1, int f2) {
        return f1+f2;
      }
    },MINUS {
      @Override
      int doAction(int f1, int f2) {
        return f1-f2;
      }
    },PLUS {
      @Override
      int doAction(int f1, int f2) {
        return f1*f2;
      }
    },DIVIDE {
      @Override
      int doAction(int f1, int f2) {
        return f1/f2;
      }
    },MOD {
      @Override
      int doAction(int f1, int f2) {
        return f1%f2;
      }
    };

    abstract int doAction(int f1 ,int f2);
  }

}
