# CSE232B-Database Systems

This is the project for UCSD CSE232B [Database Systems: Advanced Topics and Implementation](https://cseweb.ucsd.edu/classes/wi20/cse232B-a/)

## Table of Contents

* [About the Project](#about-the-project)
  * [Milestone1](#Milestone1)
  * [Milestone2](#Milestone2)
  * [Milestone3](#Milestone3)
  * [Milestone4](#Milestone4)
  * [Reference](#Reference)
* [Getting Started](#getting-started)
  * [Environment](#Environment)
  * [Installation](#installation)
* [Usage](#usage)
* [Contributing](#contributing)



## About the Project

This project is the construction of an XQuery processor. We consider a subset/modification of XML’s data model, XQuery, and XQuery’s type system as described in [this note](https://cseweb.ucsd.edu/classes/wi20/cse232B-a/notes/xpath-semantics.pdf). The processor receives an XQuery, parses it into an abstract tree representation, optimizes it and finally executes the optimized plan.

### Milestone1

In Milestone1, we have inplemented a straightforward query execution engine receives the simplified XPath and an input XML file and evaluates the query using a recursive evaluation routine which, given an **path expression**  and a list of input nodes, produces a list of output nodes. For the XPath parser, we utilized the **ANTLR4**. Provided with a grammar, ANTLR generates a compiler which automatically constructs abstract syntax trees of its input expressions.



### Milestone2

In Milestone2, we have inplemented a straightforward query execution engine receives the simplified XQuery and an input XML file and evaluates the query using a recursive evaluation routine which, given an **XQuery expression (path, concatenation, element creation, etc)**  and a list of input nodes, produces a list of output nodes. For the XQuery parser, we also utilized the **ANTLR4**. Provided with a grammar, ANTLR generates a compiler which automatically constructs abstract syntax trees of its input expressions.



### Milestone3

In Milestone3, we have implemented a join operator as defined. Using hash map to detect the fact that the FOR and WHERE clause computation can be implemented using the join operator. Assume that the input XQueries to be optimized are in the simplified syntax.



### Milestone4

In Milestone4, we have implement the controlling of the shape of the join plan. We can control the rewrite module with two flags:

* L stands for “left-deep” join plan, as discussed in class In such plans, when a join operator takes as input the result of another join operator, this may only be the left input.

The consequence is that a join of n+1 tables leads to a plan that is a cascade of join operators.

* B stands for “bushy” join plan.

Here, join results may appear as both the left and the right input to a join operator. Your task is to arrange the subqueries to be joined in a bushy join plan that

1. has smallest possible height

2. while avoiding Cartesian products when the user query contains none of them

The details of how to control the join plan will be shown in **"Usage"** part.



### Reference

In this project, we have utilized ANTLR4

* [ANTRL4 documentation](https://github.com/antlr/antlr4/blob/master/doc/index.md)
* [The Definitive ANTLR4 Reference](http://lms.ui.ac.ir/public/group/90/59/01/15738_ce57.pdf)  by Terence Parr -- antlr4 reference book (has examples of using listener VS visitor methods) 
* [ANTLR Java API](https://www.antlr.org/api/Java/index.html)

## Getting Started

### Environment

If you want to build this project, you will need:

* Java 1.8+ (in this project we use **Java 1.8.0_221**)
* Antlr v4 dependencies

### Installation

To install the prerequisite environment, you can follow the following help links:

* [ANTLR Java JAR](https://www.antlr.org/download.html)

* Intellij IDEA [ANTLR v4 grammar plugin](https://plugins.jetbrains.com/plugin/7358-antlr-v4-grammar-plugin)

## Usage

* ***Initialize and run the project***:

  If you are an Intellij IDEA user, after you download the project, you need to enable your [ANTLR v4 grammar plugin](https://plugins.jetbrains.com/plugin/7358-antlr-v4-grammar-plugin).

* ***Milestoe1: XPath***

  After you download the project, you can find the ***"27_CSE232BWI20_XPath.jar"***, and you can run the project by the following directions:

  * In your project home directory, you need to use **"XPathTest.txt"** file to input your XPath query. You can write all your input line by line. After that, you can just run the **"XPath.java"** and in the command output, you can get the number of nodes found in the query, and in the file **"XPathOutput.txt"**, you can get all the nodes of your XPath queries.

  * As for a packaged jar file, you can use **"XPathTest.txt"** file to input your XPath query. You can write all your input line by line. After that you can run the project by

    `java -jar 27_CSE232BWI20_XPath.jar`

    to get the output in the **"XPathOutput.txt"** file.

* ***MileStone2: XQuery***

  After you download the project, you can find the ***"27_CSE232BWI20_XQuery.jar"***, and you can run the project by the following directions:
  
  * In your project directory, you need to use **"XQueryTest.txt"** file to input your Query query. You can write all your input query sentence line by line, but you can **only input one query once in the input file**, if you have more than one query, you need erase all your previous input in the input file and reinput. After the input file get your input query, you can run the **"Query.java"** and in the command output, you can get the number of nodes found in the query(The nodes can be queried or created). And moreover, it will also show the nodes found in your Query query.
  
  * As for a packaged jar file, you can use **"XQueryTest.txt"** file to input your Query query. As mentioned, You can **only input one query once in the input file**. After input your query, you can run the project by
  
    `java -jar 27_CSE232BWI20_XQuery.jar`
  
    And get the query result in the terminal.

* ***MileStone3: Join***

  After you download the project, you can find the ***"27_CSE232BWI20_Join.jar"***, and you can run the project by the following directions:

  * In your project directory, you need to use **"XQueryTest.txt"** file to input your Query query. You can **only input one query once in the input file**, if you have more than one query, you need erase all your previous input in the input file and reinput. After the input file get your input query, you can run the **"XQueryOptimize.java"** and you can get the rewrite file in **"OptimizedQuery.txt"**.
    In the command output, you can get the number of nodes found in the query(The nodes can be queried or created). And moreover, it will also show the nodes found in your Query query.

  * As for a packaged jar file, you can use **"XQueryTest.txt"** file to input your Query query. As mentioned, You can **only input one query once in the input file**. After input your query, you can run the project by

    `java -jar 27_CSE232BWI20_XQuery.jar`

    And get the rewritten query in the  result in the **"OptimizedQuery.txt"** and get the query result in the terminal.

* ***MileStone4: Change Join Plan***

  After you download the project, you can find the ***"27_CSE232BWI20_MileStone4.jar"***, and you can run the project by the following directions:

  * In ***Intellij IDEA***, In your project directory, you need to use **"XQueryTest.txt"** file as *args[0]* to input your Query query. You can **only input one query once in the input file**, if you have more than one query, you need erase all your previous input in the input file and reinput. After the input file get your input query, you need to choose your join plan(left join or right join). You need to set the flag in *args[1]* as ***-L: left join, -B: bushy join***. Then you can run the **"XQueryOptimize.java"** and you can get the rewrite file in **"OptimizedQuery.txt"**.
    In the command output, you can get the number of nodes found in the query(The nodes can be queried or created). And moreover, it will also show the nodes found in your Query query.
    And we can also get a file named as ***MileStone4_Output.txt*** which contains all the information including the rewritten query, query output and query summary.

  * As for a packaged jar file, you can use **"XQueryTest.txt"** file to input your Query query. As mentioned, You can **only input one query once in the input file**. After input your query, you can run the project by

    `java -jar 27_CSE232BWI20_XQuery.jar <filename> -L` for left join or

    `java -jar 27_CSE232BWI20_XQuery.jar <filename> -B` for bushy join
    (Example filename: XQueryTest.txt)

    And get the rewritten query in the  result in the **"OptimizedQuery.txt"** and get the query result in the terminal.

    And we can also get a file named as ***MileStone4_Output.txt*** which contains all the information including the rewritten query, query output and query summary.



## Contributing

* Zhiqiang Sun [![LinkedIn][linkedin-shield]][Zhiqiang-url]
* Xiaohan Zhu [![LinkedIn][linkedin-shield]][Xiaohan-url]





<!-- LINKS -->

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=flat-square&logo=linkedin&colorB=555
[Zhiqiang-url]: https://www.linkedin.com/in/zhiqiang-sun/
[Xiaohan-url]: https://www.linkedin.com/in/xh-zhu/

