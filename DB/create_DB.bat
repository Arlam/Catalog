IF "%1"=="" GOTO End
mysql.exe --host=localhost  --user=root --password=%1 < catalog.sql
mysql.exe --host=localhost  --user=root --password=%1 < user.sql
:End