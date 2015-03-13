:: Replace '-' to '_' in folders (packages) names
@echo off
setlocal enabledelayedexpansion
set "pattern=-"
set "replace=_"

For /D %%f in (*) do (
	:: ~d is drive, ~p is the path (without drive), ~n is the file name
	set "oldname=%%~nf"
    set "newname=!oldname:%pattern%=%replace%!"
	set "newname=!newname:~-3!_!newname:~0,6!"
	echo !oldname! !newname!
	:: %~x1        - expands %1 to a file extension only
    ren "%%f" "!newname!%%~xf"
)

set str=politic
echo.%str%
set str=%str:~-4%
echo.%str%

pause