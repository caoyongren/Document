## TextEditor开源软件分析
***
  - [920编辑器调研](https://github.com/openthos/systemui-analysis/blob/master/LJH/920%E7%BC%96%E8%BE%91%E5%99%A8%E8%B0%83%E7%A0%94.md)
### 版本控制
  - origin git://192.168.0.185/openthos/oto-TextEditor(fetch)
  - origin git://192.168.0.185/openthos/oto-TextEditor(push)
  - remotes/origin/master
  - remotes/origin/multiwindow
  - git pull origin master
  - git push origin master : master
  
### 前言
  - 该富文本编辑器: 内核使用的是ace(https://githup.com/ajaxorg/ace) , 所以编译该项目需要先编辑ace内核。
  - 前提: 先安装 node node.js npm
  - 方法: 
    - cd tools/assets/ace/
    - node ./Makefile.dryice.js
  - 常出现的问题:
    - 会出现一些问题: 比如Modules　thow error . 可以查看(https://github.com/nodejs/help/issues/663) 进行解决。
    
### 整体结构
  - 服务器代码位置: origin  git://192.168.0.185/TextEditor.git
  - 项目工程(app)
    - ui包
      - 编辑器的主要界面的搭建。
  - file_explore
    - 文件浏览module用于打开/另存为/保存时，文件存储位置的浏览.
  - common
  - styles
    - 这两个module主要是一些辅助。
    
***

### 核心代码
  - assets资源文件夹
    - ace文件夹
      - ace内核
      - 这里都是js的文件
    - css
      - 文本编辑区的样式
  - 这部分核心编辑区的开发需要web的知识。

### 功能需求
  - 这个主要还是原项目的内容
  - 原项目: https://github.com/jecelyin/920-text-editor-v2
  
### 项目逻辑代码分析
  - EditAreaView.java
    - 富文本编辑器的实现都是通过extends　WebView.
    - 基础配置如下:
    
    ```
        WebSettings ws = getSettings();
        ws.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        ws.setAllowContentAccess(true);
        ws.setAllowFileAccess(true);
        ws.setBuiltInZoomControls(false);
        ws.setDefaultTextEncodingName("utf-8");
        ws.setDisplayZoomControls(false);
        ws.setSupportZoom(false);
        ws.setLoadWithOverviewMode(false);

        ws.setJavaScriptEnabled(true);
        ws.setAppCacheEnabled(false);
        ws.setDomStorageEnabled(true);
        ws.setAppCacheMaxSize(1024 * 1024 * 80);
        ws.setAppCachePath(context.getCacheDir().getPath());
        //ws.setAllowFileAccess(true);
        ws.setCacheMode(WebSettings.LOAD_DEFAULT);

        addJavascriptInterface(new JavascriptApi(), "AndroidEditor");

        setWebViewClient(new EditorViewClient());
        setWebChromeClient(new EditorViewChromeClient());
    ```
  - InputConnectionHacker.java
    - 该类 implements InputConnection
      - InputConnection.java- 用于文本输入的接口
      - openthos 系统中在InputConnection中添加了 isLauncherFocus(boolean isFocus)方法
        - 在InputConnectionHacker中也需要实现该方法；
        
  - MenuDialog.java
    - 顶部菜单的dialog实现
  - TabManager.java
    - implements TabViewPager.OnPageChangeListener
    - 对编辑栏的增加
  - TabAdapter.java
    - extends RecyclerView.Adapter
    - 实现布局的
    
### 文件文本选择
  - [OtoEileSelect设计文档](https://github.com/openthos/systemui-analysis/blob/master/LJH/%E6%96%87%E4%BB%B6%E9%80%89%E6%8B%A9%E6%96%87%E6%A1%A3.md)

