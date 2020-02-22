# CSE232B-Database Systems

This is the project for UCSD CSE232B [Database Systems: Advanced Topics and Implementation](https://cseweb.ucsd.edu/classes/wi20/cse232B-a/)

##Table of Contents

* [About the Project](#about-the-project)
  * [Milestone1](#Milestone1)
  * [Milestone2](#Milestone2)
  * [Milestone2](#Milestone2)
  * [Reference](#Reference)
* [Getting Started](#getting-started)
  * [Environment](#Environment)
  * [Installation](#installation)
* [Usage](#usage)
* [Contributing](#contributing)



##About the Project

This project is the construction of an XQuery processor. We consider a subset/modification of XML’s data model, XQuery, and XQuery’s type system as described in [this note](https://cseweb.ucsd.edu/classes/wi20/cse232B-a/notes/xpath-semantics.pdf). The processor receives an XQuery, parses it into an abstract tree representation, optimizes it and finally executes the optimized plan.

### Milestone1

In Milestone1, we have inplemented a straightforward query execution engine receives the simplified XPath and an input XML file and evaluates the query using a recursive evaluation routine which, given an **path expression**  and a list of input nodes, produces a list of output nodes. For the XPath parser, we utilized the **ANTLR4**. Provided with a grammar, ANTLR generates a compiler which automatically constructs abstract syntax trees of its input expressions.



### Milestone2

In Milestone2, we have inplemented a straightforward query execution engine receives the simplified XQuery and an input XML file and evaluates the query using a recursive evaluation routine which, given an **XQuery expression (path, concatenation, element creation, etc)**  and a list of input nodes, produces a list of output nodes. For the XQuery parser, we also utilized the **ANTLR4**. Provided with a grammar, ANTLR generates a compiler which automatically constructs abstract syntax trees of its input expressions.



### Milestone3

To be continued.



### Reference

In this project, we have utilized ANTLR4

* [ANTRL4 documentation](https://github.com/antlr/antlr4/blob/master/doc/index.md)
* [The Definitive ANTLR4 Reference](http://lms.ui.ac.ir/public/group/90/59/01/15738_ce57.pdf)  by Terence Parr -- antlr4 reference book (has examples of using listener VS visitor methods) 
* [ANTLR Java API](https://www.antlr.org/api/Java/index.html)

## Getting Started

This project is maintained by Apache Maven.

### Environment

If you want to build this project, you will need:

* Java 1.8+ (in this project we use **Java 1.8.0_221**)
* Maven 3.0.5 or later(in this project we use **Maven 3.5.4**)
* Antlr v4 dependencies

### Installation

To install the prerequisite environment, you can follow the following help links:

* [install maven](https://maven.apache.org/install.html)

* [ANTLR Java JAR](https://www.antlr.org/download.html)

* Intellij IDEA [ANTLR v4 grammar plugin](https://plugins.jetbrains.com/plugin/7358-antlr-v4-grammar-plugin)

## Usage

* Initialize the project:

  After you down the project, you can open your IDE and install all the dependencies in the project by

  `mvn install`

  If you are an Intellij IDEA user, you need to enable your ANTLR v4 plugin.

* XPath

  In your home directory, you need to use **"XPathTest.txt"** file to input your XPath query. You can write all your input line by line. After that, you can just run the **"XPath.java"** and in the command output, you can get the number of nodes found in the query, and in the file **"XPathOutput.txt**, you can get all the nodes of your XPath queries.

* XQuery

  In your home directory, you need to use **"XQueryTest.txt"** file to input your Query query. You can write all your input query sentence line by line, but you can **only input one query once in the input file**, if you have more than one query, you need erase all your previous input in the input file and reinput. After the input file get your input query, you can run the **"Query.java"** and in the command output, you can get the number of nodes found in the query(The nodes can be queried or created). And moreover, it will also show the nodes found in your Query query.



## Contributing

[![Zhiqiang Sun][contributors-shield]][Zhiqiang-url]

[![Xiaohan Zhu][contributors-shield]][Xiaohan-url]





<!-- LINKS -->

[Zhiqiang-url]:https://www.linkedin.com/in/zhiqiang-sun/
[Xiaohan-url]: https://www.linkedin.com/in/xh-zhu/

