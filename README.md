# springBoot 整合 webSocket
> 主要功能
- 给某一用户发消息
- 给所有用户群发消息

> 访问url
- 用户1，用户id写死在页面里了   
localhost:8089/ws
- 用户2，用户id写死在页面里了   
localhost:8089/ws1
- 给某一用户发消息   
localhost:8089/sysSeed?userId=wjup001&message=工资涨到5万/月
- 给所有人发消息   
localhost:8089/seedAll?message=所有人注意：明天放假一周