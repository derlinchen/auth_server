## postman获取Token ##

1. 打开postman

2. 在Authorization选择Basic Auth，在UserName和Password输入client的用户名和密码

3. 切换到Body，选择form-data，输入key-value分别如下

	    grant_type 	password
	    username 	user1
	    password 	123456789
	    
4. 权限验证调用，输入：`localhost:8080/user` 选择`Bearer Token`，输入获取的token值进行调用 