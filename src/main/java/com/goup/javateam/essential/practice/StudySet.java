package com.goup.javateam.essential.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudySet {

  static void exeNoDuplicate(int i){
    List<Integer> numList = Arrays.asList(111,129,3,3,129,
                                          111,3,4,5,6,
                                          4,3,2,111);
    log.info("size of numList:{}",numList.size());
    Set<Integer> numSet = numList.stream().collect(Collectors.toSet());
    log.info("size of numSet:{}, each of them : {}",numSet.size(),numSet);

    String b = "b";
    List<String> strList = Arrays.asList("a","bbb","c","c","bbc","a","d","a","a",b);
    log.info("size of strList:{}",strList.size());
    Set<String> strSet = strList.stream().collect(Collectors.toSet());
    log.info("size of strList:{}, each of them : {}",strSet.size(),strSet);


    Element e1 = new Element("e1");
    Element e2 = new Element("e1");
    Element e3 = new Element("e1");
    List<Element> elementList = Arrays.asList(e1,e2,e3,e1,e2,e3);
    log.info("size of elementList:{}",elementList.size());
    Set<Element> elementSetSet = elementList.stream().collect(Collectors.toSet());
    log.info("size of elementSetSet:{}, each of them : {}",elementSetSet.size(),elementSetSet);
  }

  public static void main(String[] args) {
    log.info("--- --- remove duplicate value --- ---");
    exeNoDuplicate(3);
  }

  @Data
  @AllArgsConstructor
  public static class Element{
    private String name;
  }

//  public static class Element{
//    private String name;
//
//    Element(String name){
//      this.name = name;
//    }
//  }

}
