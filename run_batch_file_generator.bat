@echo off
if not exist "Batch_File_Generator.class" (
  javac Batch_File_Generator.java
)

java Batch_File_Generator
echo;
echo Closing in 3 seconds...
timeout /t 3 > nul
exit 0
