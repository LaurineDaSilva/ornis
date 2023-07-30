# Java

# Factorize a ID mapping

1. How to factorize the ID mapping ?

=> It is not the Java's responsability to assigne the ID but it is the database.

* **Process**:
> In the **package Entity**, create an _Abstract class_ named _AbstractEntity_ (name by Convention)

> In the **entities**, delete ID and des getters/setters **and** add an _extends AbstractEntity_ in order to link the entities and the AbsctractEntity file

> Add a _@MappedSuperClass_ annotation  which contains some mappings elements

* **Why to extend**  ?
> It allows to factorize the code in the parent classes and benefits from an already existing implementation.

> It is about specializing a behavior by redefining a method.

* **Abstract class cannot be directly instantiated**.

* **Domains/business objects = abstraction/simplification of reality**

2. Visibility level in Java

=> _4 visibilities level_ in Java but **3 keys words**
* **package visible = no keyword = package default** -> allows a variable or method to be seen by all methods of a class or other classes that are part of the same package
* **public** -> access from anywhere in the app
* **private** -> access inside the class
* **protected** -> (à définir par Frank)

With the **package visible** no more to have a **setId**

It is the database which deal with the next ID's value.

**What to do with the setId**?
1. _Wrong practice_: delete or do not put the **setId** in the class. Howerver, if someone does not know the process, he could add a **setId** which will cause errors in the application.

2. _Best practice_: add the method but do not make it accessible by putting an @SuppressWarnings("Unused") annotation + add a comment like **//prevent from accidental assignment (set by DB)**

**BE CAREFUL**: this process to factorize the mapping ID is
* not by default
* not for all projects
* because we have an explainantion


