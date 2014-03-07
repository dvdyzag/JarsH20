JarsH20
=======

Algoritmos no informados para el problema de las Jarras
http://cs.gettysburg.edu/~tneller/resources/ai-search/uninformed-java/index.html

Compile
```bash
mkdir bin
cd src
javac fiusac/ia1/Main.java -d ../bin
```
Or just use Ant
```bash
ant
```
Run
```bash
cd ../bin/
java fiusac.ia1.Main
```
Make Jar
```bash
jar cfe JarsH20.jar fiusac.ia1.Main *
```
Run Jar
```bash
java -jar JarsH20.jar c4.conf

```
Guardar la salida en un fichero de texto
```bash
java -jar JarsH20.jar c4.conf > resultado_c4.txt

```
