@echo off
if not exist "Main.class" (
  javac Main.java
)

java Main
echo;
echo Press any key to close.
echo Closing in 30 seconds...
timeout /t 30
