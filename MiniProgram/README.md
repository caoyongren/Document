## 微信小程序文档
***
#### ubuntu16.04上使用微信开发工具
  - [教程](https://www.jianshu.com/p/fe6ef14b02a3)
  - 关键点
    - sudo　apt install wine
    - git clone https://github.com/cytle/wechat_web_devtools.git
    - cd wechat_web_devtools
    - ./bin/wxdt
    - WINEARCH=win32 WINEPREFIX=~/.wine32 winecfg
    - cd wechat_web_devtools
    - ./bin/wxdt install
    - ./bin/wxdt
    - git pull origin # 更新
