update mysql.user set password=password('mysql123') where user='root';
flush privileges;