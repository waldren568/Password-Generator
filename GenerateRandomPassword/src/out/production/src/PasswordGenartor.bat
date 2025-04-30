@echo off
javac -encoding UTF-8 LauncherApp.java
if %errorlevel% equ 0 (
    java Main
)
pause