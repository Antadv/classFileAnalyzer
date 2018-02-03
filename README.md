## ClassFileAnalyzer

Java 解析 class 文件

详细参考[自己动手解析 Class 文件](https://somelogs.com/article/analyze-class)

## class demo

源码

```java
package com.somelogs.bug;

import java.io.Serializable;

/**
 * 描述
 *
 * @author LBG - 2018/1/18 0018
 */
public class TestClass implements Serializable {

    public static final String HELLO = "hello";
    public static int A = 232;
    public static final double B = 3.2;
    public static final long C = 23L;

    private int m;

    public int add() throws IllegalArgumentException, NullPointerException {
        return this.m + 1;
    }
}

```

## TestClass.class

    cafe babe 0000 0033 002e 0a00 0500 2509
    0004 0026 0900 0400 2707 0028 0700 2907
    002a 0100 0548 454c 4c4f 0100 124c 6a61
    7661 2f6c 616e 672f 5374 7269 6e67 3b01
    000d 436f 6e73 7461 6e74 5661 6c75 6508
    002b 0100 0141 0100 0149 0100 0142 0100
    0144 0640 0999 9999 9999 9a01 0001 4301
    0001 4a05 0000 0000 0000 0017 0100 016d
    0100 063c 696e 6974 3e01 0003 2829 5601
    0004 436f 6465 0100 0f4c 696e 654e 756d
    6265 7254 6162 6c65 0100 124c 6f63 616c
    5661 7269 6162 6c65 5461 626c 6501 0004
    7468 6973 0100 1c4c 636f 6d2f 736f 6d65
    6c6f 6773 2f62 7567 2f54 6573 7443 6c61
    7373 3b01 0003 6164 6401 0003 2829 4901
    000a 4578 6365 7074 696f 6e73 0700 2c07
    002d 0100 083c 636c 696e 6974 3e01 000a
    536f 7572 6365 4669 6c65 0100 0e54 6573
    7443 6c61 7373 2e6a 6176 610c 0016 0017
    0c00 1500 0c0c 000b 000c 0100 1a63 6f6d
    2f73 6f6d 656c 6f67 732f 6275 672f 5465
    7374 436c 6173 7301 0010 6a61 7661 2f6c
    616e 672f 4f62 6a65 6374 0100 146a 6176
    612f 696f 2f53 6572 6961 6c69 7a61 626c
    6501 0005 6865 6c6c 6f01 0022 6a61 7661
    2f6c 616e 672f 496c 6c65 6761 6c41 7267
    756d 656e 7445 7863 6570 7469 6f6e 0100
    1e6a 6176 612f 6c61 6e67 2f4e 756c 6c50
    6f69 6e74 6572 4578 6365 7074 696f 6e00
    2100 0400 0500 0100 0600 0500 1900 0700
    0800 0100 0900 0000 0200 0a00 0900 0b00
    0c00 0000 1900 0d00 0e00 0100 0900 0000
    0200 0f00 1900 1100 1200 0100 0900 0000
    0200 1300 0200 1500 0c00 0000 0300 0100
    1600 1700 0100 1800 0000 2f00 0100 0100
    0000 052a b700 01b1 0000 0002 0019 0000
    0006 0001 0000 000a 001a 0000 000c 0001
    0000 0005 001b 001c 0000 0001 001d 001e
    0002 0018 0000 0031 0002 0001 0000 0007
    2ab4 0002 0460 ac00 0000 0200 1900 0000
    0600 0100 0000 1400 1a00 0000 0c00 0100
    0000 0700 1b00 1c00 0000 1f00 0000 0600
    0200 2000 2100 0800 2200 1700 0100 1800
    0000 1f00 0100 0000 0000 0711 00e8 b300
    03b1 0000 0001 0019 0000 0006 0001 0000
    000d 0001 0023 0000 0002 0024 

## 解析

```java

@Test
public void test() throws Exception {
    ClassFileAnalyzer.analyze("C:/Users/Administrator/Desktop/TestClass.class").print();
}

```

结果

    magic: cafebabe
    minor version: 0
    major version: 51
    Access flags: ACC_PUBLIC ACC_SUPER 
    
    Constant pool: 46
    #1=Methodref java/lang/Object.<init>:()V
    #2=Fieldref com/somelogs/bug/TestClass.m:I
    #3=Fieldref com/somelogs/bug/TestClass.A:I
    #4=Class com/somelogs/bug/TestClass
    #5=Class java/lang/Object
    #6=Class java/io/Serializable
    #7=Utf8 HELLO
    #8=Utf8 Ljava/lang/String;
    #9=Utf8 ConstantValue
    #10=String hello
    #11=Utf8 A
    #12=Utf8 I
    #13=Utf8 B
    #14=Utf8 D
    #15=Double 3.2
    #17=Utf8 C
    #18=Utf8 J
    #19=Long 23L
    #21=Utf8 m
    #22=Utf8 <init>
    #23=Utf8 ()V
    #24=Utf8 Code
    #25=Utf8 LineNumberTable
    #26=Utf8 LocalVariableTable
    #27=Utf8 this
    #28=Utf8 Lcom/somelogs/bug/TestClass;
    #29=Utf8 add
    #30=Utf8 ()I
    #31=Utf8 Exceptions
    #32=Class java/lang/IllegalArgumentException
    #33=Class java/lang/NullPointerException
    #34=Utf8 <clinit>
    #35=Utf8 SourceFile
    #36=Utf8 TestClass.java
    #37=NameAndType <init>:()V
    #38=NameAndType m:I
    #39=NameAndType A:I
    #40=Utf8 com/somelogs/bug/TestClass
    #41=Utf8 java/lang/Object
    #42=Utf8 java/io/Serializable
    #43=Utf8 hello
    #44=Utf8 java/lang/IllegalArgumentException
    #45=Utf8 java/lang/NullPointerException
    
    Class FQN: com/somelogs/bug/TestClass
    Super class FQN: java/lang/Object
    
    Interfaces: 1
    java/io/Serializable
    
    Fields Count: 5
    public static final Ljava/lang/String; HELLO
    	{type=ConstantValue, value=hello}
    public static I A
    public static final D B
    	{type=ConstantValue, value=3.2}
    public static final J C
    	{type=ConstantValue, value=23L}
    private I m
    
    Method Count: 3
    public ()V <init>
    	{type=Code, maxStack=1, maxLocals=1, codeLength=5, opcodes=[2a, b7, 0, 1, b1], exceptions=[], attribute=[{type=LineNumberTable, table=[{start=0, lineNumber=10}]}, {type=LocalVariableTable, LocalVariableInfo=[{start=0, length=5, name=this, descriptor=Lcom/somelogs/bug/TestClass;, index=0}]}]}
    public ()I add
    	{type=Code, maxStack=2, maxLocals=1, codeLength=7, opcodes=[2a, b4, 0, 2, 4, 60, ac], exceptions=[], attribute=[{type=LineNumberTable, table=[{start=0, lineNumber=20}]}, {type=LocalVariableTable, LocalVariableInfo=[{start=0, length=7, name=this, descriptor=Lcom/somelogs/bug/TestClass;, index=0}]}]}
    	{type=Exceptions, exceptions=[java/lang/IllegalArgumentException, java/lang/NullPointerException]}
     static ()V <clinit>
    	{type=Code, maxStack=1, maxLocals=0, codeLength=7, opcodes=[11, 0, e8, b3, 0, 3, b1], exceptions=[], attribute=[{type=LineNumberTable, table=[{start=0, lineNumber=13}]}]}
    
    Attribute Count: 1
    {type=SourceFile, fileName=TestClass.java}