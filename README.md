JarsH20
=======

Algoritmos no informados para el problema de las Jarras
http://cs.gettysburg.edu/~tneller/resources/ai-search/uninformed-java/index.html
## Reglas
Nodo Objetivo: Jarra de 4 litros debe juntar *2 litros* de líquido
#### Implementación de la búsqueda
[NoInformado.java](https://github.com/dvdyzag/JarsH20/blob/master/src/fiusac/ia1/search/NoInformado.java)
## Autores
Nombre | Carné
------------- | -------------
David Yzaguirre Gonzalez  | 200819312
Erick Roberto Dominguez Aldi  | 200815170
## Sentencias de consola comunes
### Compilar
#### utilizando javac
```bash
mkdir bin
cd src
javac fiusac/ia1/Main.java -d ../bin
```
#### utilizando ant
```bash
ant
```
### Run
```bash
cd ../bin/
java fiusac.ia1.Main
```
### Crear Jar
```bash
jar cfe JarsH20.jar fiusac.ia1.Main *
```
### Run Jar
```bash
java -jar JarsH20.jar c4.conf
```
donde `c4.conf` es un fichero de texto con propiedades que el usuario ha elegido. Por defecto intenta abrir `c1.conf`.
### Guardar la salida en un fichero de texto
```bash
java -jar JarsH20.jar c4.conf > resultado_c4.txt
```