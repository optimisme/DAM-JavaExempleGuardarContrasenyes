rem run with: .\run.bat

cls
rm -r -force .\bin
rm -r -force .\src\.*
rm -r -force .\lib\javafx-windows\lib\.*
mkdir bin
xcopy .\assets .\bin\assets /E /I /Y

javac -cp ".;.\\bin;.\\lib\\password4j-1.6.2.jar;.\\lib\\slf4j-simple-1.6.1.jar;.\\lib\\slf4j.api-1.6.1.jar" -d .\bin\ .\src\*.java
java -cp ".;.\\bin;.\\lib\\password4j-1.6.2.jar;.\\lib\\slf4j-simple-1.6.1.jar;.\\lib\\slf4j.api-1.6.1.jar" Main