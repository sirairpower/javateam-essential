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

  static void exeNoDuplicate(){
    log.info("--- --- remove duplicate value --- ---");
    List<Integer> numList = Arrays.asList(111,129,3,3,129,
                                          111,3,4,5,6,
                                          4,3,2,111);
    log.info("size of numList:{}",numList.size());
    Set<Integer> numSet = numList.stream().collect(Collectors.toSet());
    numSet.add(2);
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

  static void bulkOperation(){
    log.info("--- --- Bulk Operations containall --- ---");
    List<Integer> numList1 = Arrays.asList(1,2,3,4,5);
    List<Integer> numList2 = Arrays.asList(11,13,5);
    List<Integer> numList3 = Arrays.asList(1,3,5);
    Set<Integer> numSet1 = numList1.stream().collect(Collectors.toSet());
    Set<Integer> numSet2 = numList2.stream().collect(Collectors.toSet());
    Set<Integer> numSet3 = numList3.stream().collect(Collectors.toSet());
    log.info("numSet2 all of numSet1 : {}", numSet1.containsAll(numSet2));
    log.info("numSet3 all of numSet1 : {}", numSet1.containsAll(numSet3));

  }

  static <T>void bulkOperation(List<T> s1,List<T> s2 ,FunctionTwo<Set<T>> op){
    log.info("--- --- Bulk Operations --- ---");
    Set<T> numSet1 = s1.stream().collect(Collectors.toSet());
    Set<T> numSet2 = s2.stream().collect(Collectors.toSet());
    op.apply(numSet1,numSet2);
    log.info("{}", numSet1);
    log.info("{}", numSet2);
  }

  @FunctionalInterface
  interface FunctionTwo<M> {
    public void apply(M one, M two);
  }


  public static void main(String[] args) {

//    exeNoDuplicate();
    bulkOperation();
    bulkOperation(Arrays.asList(1,2,3,4,5),Arrays.asList(11,13,5),(o,t)->{o.addAll(t);});
    bulkOperation(Arrays.asList(1,2,3,4,5),Arrays.asList(1,3,5),(o,t)->{o.addAll(t);});
    bulkOperation(Arrays.asList(1,2,3,4,5),Arrays.asList(1,3,5),(o,t)->{o.removeAll(t);});
    bulkOperation(Arrays.asList(1,2,3,4,5),Arrays.asList(11,13,5),(o,t)->{o.retainAll(t);});

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
