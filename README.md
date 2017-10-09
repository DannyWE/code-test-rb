# The Code Test
The code test for search and calculate cart price based on two json files.

## :dog: Setup
This project needs Java `8` and Scala `2.12.3`
[Install Java](https://java.com/en/download/help/index_installing.xml)

```bash
# Install Scala
$ brew install scala
$ brew install sbt

# Compile project
$./sbt clean compile
```
---

## :rabbit: Running
```bash
$java -jar ./artifact/code-test-cart-price-assembly-0.1.jar ${cart json path} ${price json path}

```
---

## :bear: Testing
```bash
$./sbt test
```

---

## How to generate executable jar
```bash
$./sbt assembly
```

---

## :tiger: Technology Stack
| Tech | Description | Learn more |
| --- | --- | --- |
| Circe | 	An functional JSON library. | [Circe](https://github.com/circe/circe) |
| scalatest | The Test library for Scala | [ScalaTest](http://www.scalatest.org) |
| sbt-assmebly | Deploy fat JARs. Restart processes. | [Sbt-Assembly](https://github.com/sbt/sbt-assembly) |

