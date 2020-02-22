# CSE232B-Database

<!-- TABLE OF CONTENTS -->

##Table of Contents

* [About the Project](#about-the-project)
  * [Milestone1](#Milestone1)
  * [Milestone2](#Milestone2)
  * [Milestone2](#Milestone2)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)
* [Acknowledgements](#acknowledgements)



<!-- ABOUT THE PROJECT -->

##About the Project

This project is the construction of an XQuery processor. We consider a subset/modification of XML’s data model, XQuery, and XQuery’s type system as described in [this note](https://cseweb.ucsd.edu/classes/wi20/cse232B-a/notes/xpath-semantics.pdf). The processor receives an XQuery, parses it into an abstract tree representation, optimizes it and finally executes the optimized plan.

### Milestone1

In Milestone1, we have inplemented a straightforward query execution engine receives the simplified XPath and an input XML file and evaluates the query using a recursive evaluation routine which, given an path expression  and a list of input nodes, produces a list of output nodes. For the XPath parser, we utilized the **ANTLR4**. Provided with a grammar, ANTLR generates a compiler which automatically constructs abstract syntax trees of its input expressions.



### Milestone2

In Milestone2, we have inplemented a straightforward query execution engine receives the simplified XQuery and an input XML file and evaluates the query using a recursive evaluation routine which, given an **XQuery expression (path, concatenation, element creation, etc)**  and a list of input nodes, produces a list of output nodes. For the XQuery parser, we also utilized the ANTLR4. Provided with a grammar, ANTLR generates a compiler which automatically constructs abstract syntax trees of its input expressions.