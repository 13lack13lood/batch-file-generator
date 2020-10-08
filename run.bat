@echo off
if not exist "Main.class" (
  javac Main.java
)

java Main
pause
