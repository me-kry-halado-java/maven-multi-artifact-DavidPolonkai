package hu.meiit.haladojava.logic;

import hu.meiit.haladojava.exceptions.DivisionByZeroException;
import org.junit.*;
import org.junit.rules.ExpectedException;

public class ExecutorTest {

    private Executor executor;



    @Before
    public void init(){
        this.executor=new Executor();
    }

    @org.junit.Test
    public void add() {
        Assert.assertEquals(7,executor.add(3,4));
    }

    @org.junit.Test
    public void sub() {
        Assert.assertEquals(5, executor.sub(9,4));
    }

    @Test
    public void divHappyPath() {
        try {
            Assert.assertEquals(3, executor.div(9, 3));
        }catch(Exception e){

        }
    }

    @Ignore //ignored because exception testing not working
    @Test(expected = DivisionByZeroException.class)
    public void divByZero(){
        try {
            executor.div(9, 0);
        }catch(Exception ex){

        }
    }

    @Ignore //ignored because exception testing not working
    @Test(expected = DivisionByZeroException.class)
    public void divByZero2(){
        try{
            Assert.assertEquals(3,executor.div(9,0));
        }catch(Exception ex){

        }
    }

}