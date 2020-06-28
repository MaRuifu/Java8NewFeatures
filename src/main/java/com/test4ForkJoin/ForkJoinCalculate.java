package com.test4ForkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join 框架：就是在必要的情况下，
 * 将一个大任务，进形拆分（fork）成若干个小任务（拆到不可再拆时），再将一个个的小任务运行的结果进行join汇总。
 */


/**
 * Fork/Join 框架与传统线程池的区别：
 *
 * 采用“工作窃取”模式(work-stealing):
 * 当执行新的任务时，它可以将其拆分成更小的任务执行，并将小任务加到线程队列中，
 * 然后再从一个随机线程的队列中偷一个并把它放在自己的队列中。
 *
 * 相对于一般的线程池实现,fork/join框架的优势体现在对其中包含的任务的处理方式上.在一般的线程池中,
 * 如果一个线程正在执行的任务由于某些原因无法继续运行,那么该线程会处于等待状态.而在fork/join框架实现中,
 * 如果某个子问题由于等待另外一个子问题的完成而无法继续运行.
 * 那么处理该子问题的线程会主动寻找其他尚未运行的子问题来执行.这种方式减少了线程的等待时间,提高了性能。
 *
 */


public class ForkJoinCalculate extends RecursiveTask<Long> {

    private static final long serialVersionUID = 1234567890L;//序列号


    private long start;
    private long end;

    //临界点
    private static final long THRESHOLD = 1_0000L;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long len = end - start;
        //不大于临界值直接计算结果
        if(len < THRESHOLD){
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum  +=  i;
            }
            return sum;
        }else{
            //大于临界值时,拆分为两个子任务
            Long mid = (start+end)/2;
            ForkJoinCalculate task1 = new ForkJoinCalculate(start,mid);
            ForkJoinCalculate task2 = new ForkJoinCalculate(mid + 1,end);
            task1.fork();
            task2.fork();
            //合并计算
            return task1.join()+task2.join();
        }

    }

}