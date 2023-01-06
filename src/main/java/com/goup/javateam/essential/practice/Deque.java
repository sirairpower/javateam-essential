package com.goup.javateam.essential.practice;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;

@Slf4j
public class Deque  {
    public static void main(String[] args) {
        java.util.Deque deque = new ArrayDeque<Integer>();
        java.util.Deque deque1 = new LinkedList();
        for(int i=0;i<=10;i++){
            deque.add(i);
        }
        //add addFirst addLast 雙向加入
        log.info("deque{}",deque);
        deque.add(100);
        log.info("deque.add(100) = {}",deque);
        deque.addFirst(-1);
        log.info("deque.addFirst(-1) = {}",deque);

        //offer offerFirst offerLast 同時傳回是否成功
        deque.offer(200);
        log.info("deque.offer(200) = {}",deque);
        log.info("deque.offer(200) = {}",deque.offer(200));
        Iterator iterator =deque.descendingIterator();
        while (iterator.hasNext()){
            log.info("descendingIterator 倒過來遍歷{}",iterator.next());
        }

        log.info("pop 刪除頭部元素並返回該元素{}",deque.pop());
        //removeFirst():刪除在頭部元素
        //removeLast():刪除在尾部元素

        //poll():刪除在頭部元素，或者返回Null值假如是空的Aarray  pollFirst() pollLast():
        //刪除在尾部元素，或者返回Null值假如是空的Aarray。
        log.info("deque1.poll() = 刪除在頭部元素，或者返回Null值假如是空的Aarray = {}", deque1.poll());

        //peek():搜索及返回在頭部元素，或者返回Null值假如是空的Aarray peekFirst() peekLast():
        log.info("deque.peek()= {} ",deque.peek());
    }
}
