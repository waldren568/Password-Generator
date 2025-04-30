@echo off
javac LauncherApp.java
if %errorlevel% equ 0 (
    start javaw -cp . LauncherApp
    exit
)