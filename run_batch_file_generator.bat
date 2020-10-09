@echo off
if not exist "Main.class" (
  javac Main.java
)

java Main
echo;
echo Closing in 3 seconds...
timeout /t 3 > nul
exit 0
