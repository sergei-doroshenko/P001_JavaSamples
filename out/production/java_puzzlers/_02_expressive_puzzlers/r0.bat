:: Replace '-' to '_' in folders (packages) names
@echo off
setlocal enabledelayedexpansion
set "pattern=-"
set "replace=_"

For /D %%f in (*) do (
	:: ~d is drive, ~p is the path (without drive), ~n is the file name
	set "oldname=%%~nf"
    set "newname=!oldname:%pattern%=%replace%!"
	echo !oldname! !newname!
	:: %~x1        - expands %1 to a file extension only
    ren "%%f" "!newname!%%~xf"
)

pause